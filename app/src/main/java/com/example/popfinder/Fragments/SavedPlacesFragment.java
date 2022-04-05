package com.example.popfinder.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.popfinder.CurrentSavedPlacesModel;
import com.example.popfinder.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SavedPlacesFragment extends Fragment {
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    List<CurrentSavedPlacesModel> placeList = new ArrayList<> ();
    CurrentSavedPlacesModel places ;
    ListView listView;



    public SavedPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.fragment_saved_places, container, false );
        listView = view.findViewById ( R.id.listview );


        firebaseDatabase=FirebaseDatabase.getInstance ("https://pop-finder-c631e-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference ("Placesinfo");
        databaseReference.addChildEventListener ( new ChildEventListener () {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


                    Map<String,String> map = (Map<String, String>) snapshot.getValue ();

                    places = new CurrentSavedPlacesModel();

                    places.setPlcName ( map.get ( "plcName" ) );
                    places.setPlcinfo ( map.get("plcinfo") );
                    places.setPlcimage ( map.get("plcimage") );
                    places.setPlclong ( map.get("plclong") );
                    places.setPlcLatit ( map.get("plcLatit") );

                    placeList.add(places);

                MyAdapter myAdapter = new MyAdapter (getActivity(),placeList);


                listView.setAdapter ( myAdapter );


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }




        } );



        return view ;
    }

    //////////////
    public class MyAdapter extends BaseAdapter{

        Context context;
        List<CurrentSavedPlacesModel> stringList;
        TextView txtPlace;
        TextView txtinf2;
        ImageView imgPlace;

        public MyAdapter(Context context, List<CurrentSavedPlacesModel> stringList) {
            this.context = context;
            this.stringList = stringList;
        }

        @Override
        public int getCount() {
            return stringList.size ();
        }

        @Override
        public Object getItem(int i) {
                return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view=LayoutInflater.from ( context ).inflate ( R.layout.items2,viewGroup, false );
            txtPlace= view.findViewById ( R.id.txtCity );
            txtinf2=view.findViewById ( R.id.txtinf2 );
            imgPlace=view.findViewById ( R.id.imgPlace );

            txtinf2.setText ( stringList.get ( i ).getPlcinfo () );

            byte[] imageAsByte = Base64.decode ( placeList.get ( i ).getPlcimage ().getBytes( StandardCharsets.UTF_8 ),Base64.DEFAULT );
            txtPlace.setText ( stringList.get ( i ).getPlcName () );
            Bitmap bitmap = BitmapFactory.decodeByteArray ( imageAsByte,0, imageAsByte.length );
            imgPlace.setImageBitmap ( bitmap );

            return view;
        }
    }
  ////////////////////////////////




}
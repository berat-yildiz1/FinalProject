package com.example.popfinder.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
        TextView lat2;
        TextView long2;
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
            lat2=view.findViewById ( R.id.lat2 );
            long2=view.findViewById ( R.id.long2 );

            lat2.setText ( stringList.get ( i ).getPlcLatit () );
            long2.setText ( stringList.get ( i ).getPlclong () );


            txtinf2.setText ( stringList.get ( i ).getPlcinfo () );

            byte[] imageAsByte = Base64.decode ( placeList.get ( i ).getPlcimage ().getBytes( StandardCharsets.UTF_8 ),Base64.DEFAULT );
            txtPlace.setText ( stringList.get ( i ).getPlcName () );
            Bitmap bitmap = BitmapFactory.decodeByteArray ( imageAsByte,0, imageAsByte.length );
            imgPlace.setImageBitmap ( bitmap );

            view.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    Fragment newFragment = new ToGoogleMap ();

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    transaction.replace(R.id.rec, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                    String long22 = String.valueOf ( stringList.get ( i ).getPlclong () );
                    String lat22 = String.valueOf ( stringList.get ( i ).getPlcLatit () );
                    String name22 = String.valueOf ( stringList.get ( i ).getPlcName () );
                    String info22 = String.valueOf ( stringList.get ( i ).getPlcinfo () );
                    String img22 = String.valueOf ( stringList.get ( i ).getPlcimage () );


                    Bundle result11 =  new Bundle ();
                    result11.putString ( "df11", long22 );

                    Bundle result22 =  new Bundle ();
                    result22.putString ( "df11",lat22 );


                    Bundle result33 =  new Bundle ();
                    result33.putString ( "df11", img22 );

                    Bundle result44 =  new Bundle ();
                    result44.putString ( "df11",name22 );

                    Bundle result55 =  new Bundle ();
                    result55.putString ( "df11",info22 );


                    getParentFragmentManager ().setFragmentResult ( "dataForm11",result11 );
                    getParentFragmentManager ().setFragmentResult ( "dataForm22",result22 );
                    getParentFragmentManager ().setFragmentResult ( "dataForm33",result33 );
                    getParentFragmentManager ().setFragmentResult ( "dataForm44",result44 );
                    getParentFragmentManager ().setFragmentResult ( "dataForm55",result55 );

                }
            } );

            return view;
        }
    }
  ////////////////////////////////




}
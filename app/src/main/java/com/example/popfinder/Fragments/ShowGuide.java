package com.example.popfinder.Fragments;

import com.example.popfinder.Adapter.GuideAdapter;
import com.example.popfinder.Model.AddGuideModel;
import com.example.popfinder.R;
import com.example.popfinder.databinding.FragmentShowGuideBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.github.nikartm.button.FitButton;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;


public class ShowGuide extends Fragment {

    public static final String TITLE = "title";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String AGE = "age";
    private FitButton addPerson, savePerson, queryPersonList;
    private View personLayout;
    private FirebaseFirestore firebaseFirestoreDb;
    private EditText userTitle, userName, userSurname, userAge;
    private RecyclerView recyclerView;
    private CollectionReference collectionReference;
    private GuideAdapter adapter;
    private Query query;

    private FragmentShowGuideBinding binding;
    private FloatingActionButton btnAdd;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<AddGuideModel> list = new ArrayList<>();
    private GuideAdapter guideAdapter;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShowGuideBinding.inflate(inflater, container, false);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Turist Rehberi Görüntüle");

        recyclerView = binding.recyclerView;
        btnAdd = binding.btnAdd;

        progressDialog = new ProgressDialog(requireContext());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Data Yükleniyor...");
        guideAdapter = new GuideAdapter(requireContext(), list);
        guideAdapter.setDialog(new GuideAdapter.Dialog() {
            @Override
            public void onClick(int pos) {
                final CharSequence[] dialogItem = {"Edit", "Sil"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(requireContext());
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                AddGuideFragment fragment = new AddGuideFragment();
                                Bundle args = new Bundle();
                                args.putString("id", list.get(pos).getId());
                                args.putString("name", list.get(pos).getName());
                                args.putString("phone", list.get(pos).getPhone());
                                args.putString("location", list.get(pos).getLocation());
                                fragment.setArguments(args);
                                FragmentManager fragmentManager=getFragmentManager();
                                FragmentTransaction transaction=fragmentManager.beginTransaction();
                                transaction.replace(R.id.fragmentContainer,fragment);
                                transaction.commit();
                                break;
                            case 1:
                                deleteData(list.get(pos).getId());
                                break;
                        }
                    }
                });
                dialog.show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(guideAdapter);

        btnAdd.setOnClickListener(v -> {
            AddGuideFragment fragment = new AddGuideFragment();
            FragmentManager fragmentManager=getFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentContainer,fragment);
            transaction.commit();
        });

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {
        progressDialog.show();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (document.getBoolean("isActive")){
                                    AddGuideModel guide = new AddGuideModel(
                                            document.getString("location"),
                                            document.getString("name"),
                                            document.getString("phone"),
                                            document.getString("profile_photo"));

                                    guide.setId(document.getId());
                                    list.add(guide);
                                }

                            }
                            guideAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(requireContext(), "Veri alımı başarısız oldu!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void deleteData(String id) {
        progressDialog.show();
        db.collection("users").document(id)
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(requireContext(), "Veriler silinemedi!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                        getData();
                    }
                });
    }

}
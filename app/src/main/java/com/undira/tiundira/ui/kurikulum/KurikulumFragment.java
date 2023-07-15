package com.undira.tiundira.ui.kurikulum;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.undira.tiundira.R;
import com.undira.tiundira.databinding.FragmentKurikulumBinding;
import com.undira.tiundira.widget.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class KurikulumFragment extends Fragment {

    private FragmentKurikulumBinding binding;
    private Context context;
    private ExpandableListView expListView;
    ExpandableListAdapter listAdapter;

    List<String> listDataParent;
    HashMap<String, List<String>> listDataChild;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        KurikulumViewModel homeViewModel =
                new ViewModelProvider(this).get(KurikulumViewModel.class);


        binding = FragmentKurikulumBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        this.context = this.getActivity();






        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        expListView = (ExpandableListView) view.findViewById(R.id.expListView);

        createListData();

        // Expandable Listview on group click listerner
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO GroupClickListener work
                return false;
            }
        });

        // Expandable Listview Group Expanded Listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO GroupExpandListener work
            }
        });

        // Expandable Listview Group Collapsed listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO GroupCollapseListener work
            }
        });

        // Expandable Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText( context,
                        "Awesome, I clicked:  "+ Objects.requireNonNull(listDataChild.get(listDataParent.get(groupPosition))).get(childPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void createListData() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://tiundiraandroid-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();


        listDataParent = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataParent.add("Semester 1");
        listDataParent.add("Semester 2");
        listDataParent.add("Semester 3");
        listDataParent.add("Semester 4");
        listDataParent.add("Semester 5");
        listDataParent.add("Semester 6");
        listDataParent.add("Semester 7");
        listDataParent.add("Semester 8");

        // Adding child data
        List<String> Semester1 = new ArrayList<String>();
        List<String> Semester2 = new ArrayList<String>();
        List<String> Semester3 = new ArrayList<String>();
        List<String> Semester4 = new ArrayList<String>();
        List<String> Semester5 = new ArrayList<String>();
        List<String> Semester6 = new ArrayList<String>();
        List<String> Semester7 = new ArrayList<String>();
        List<String> Semester8 = new ArrayList<String>();


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                   for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem1").getChildren()){
                       Semester1.add(snapshot.getValue().toString());
                   }
                    for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem2").getChildren()){
                        Semester2.add(snapshot.getValue().toString());
                    }
                    for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem3").getChildren()){
                        Semester3.add(snapshot.getValue().toString());
                    }
                    for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem4").getChildren()){
                        Semester4.add(snapshot.getValue().toString());
                    }
                    for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem5").getChildren()){
                        Semester5.add(snapshot.getValue().toString());
                    }
                    for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem6").getChildren()){
                        Semester6.add(snapshot.getValue().toString());
                    }
                    for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem7").getChildren()){
                        Semester7.add(snapshot.getValue().toString());
                    }
                    for(DataSnapshot snapshot: dataSnapshot.child("kurikulum").child("konten_sem8").getChildren()){
                        Semester8.add(snapshot.getValue().toString());
                    }

                System.out.println(dataSnapshot.getChildren());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });








        listDataChild.put(listDataParent.get(0), Semester1); // Header, Child data
        listDataChild.put(listDataParent.get(1), Semester2);
        listDataChild.put(listDataParent.get(2), Semester3);
        listDataChild.put(listDataParent.get(3), Semester4);
        listDataChild.put(listDataParent.get(4), Semester5);
        listDataChild.put(listDataParent.get(5), Semester6);
        listDataChild.put(listDataParent.get(6), Semester7);
        listDataChild.put(listDataParent.get(7), Semester8);


        listAdapter = new ExpandableListAdapter(context, listDataParent, listDataChild);
        expListView.setAdapter(listAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
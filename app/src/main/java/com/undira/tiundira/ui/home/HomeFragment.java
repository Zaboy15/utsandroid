package com.undira.tiundira.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.undira.tiundira.R;
import com.undira.tiundira.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://tiundiraandroid-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        DatabaseReference membersRef = mDatabase.child("beranda").child("header");

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView textViewToChange =  (TextView) root.findViewById(R.id.text_beranda);
        TextView textViewKonten =  (TextView) root.findViewById(R.id.text_konten_tentang);




        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                textViewToChange.setText(dataSnapshot.child("beranda").child("sub_header").getValue().toString());
                textViewKonten.setText(dataSnapshot.child("beranda").child("konten").child("0").getValue().toString());
                System.out.println(dataSnapshot.getChildren());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
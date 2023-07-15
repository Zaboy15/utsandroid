package com.undira.tiundira.ui.tujuan;

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
import com.undira.tiundira.databinding.FragmentTujuanBinding;

public class TujuanFragment extends Fragment {

    private FragmentTujuanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TujuanViewModel homeViewModel =
                new ViewModelProvider(this).get(TujuanViewModel.class);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://tiundiraandroid-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        DatabaseReference membersRef = mDatabase.child("beranda").child("header");
        binding = FragmentTujuanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView textViewKonten1 =  (TextView) root.findViewById(R.id.bull_konten_tujuan_1);
        TextView textViewKonten2 =  (TextView) root.findViewById(R.id.bull_konten_tujuan_2);
        TextView textViewKonten3 =  (TextView) root.findViewById(R.id.bull_konten_tujuan_3);
        TextView textViewKonten4 =  (TextView) root.findViewById(R.id.bull_konten_tujuan_4);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                textViewKonten1.setText(dataSnapshot.child("tujuanprogram").child("konten_tujuan").child("0").getValue().toString());
                textViewKonten2.setText(dataSnapshot.child("tujuanprogram").child("konten_tujuan").child("1").getValue().toString());
                textViewKonten3.setText(dataSnapshot.child("tujuanprogram").child("konten_tujuan").child("2").getValue().toString());
                textViewKonten4.setText(dataSnapshot.child("tujuanprogram").child("konten_tujuan").child("3").getValue().toString());
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
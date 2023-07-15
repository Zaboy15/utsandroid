package com.undira.tiundira.ui.studi;

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
import com.undira.tiundira.databinding.FragmentStudiBinding;

public class StudiFragment extends Fragment {

    private FragmentStudiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StudiViewModel homeViewModel =
                new ViewModelProvider(this).get(StudiViewModel.class);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://tiundiraandroid-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();


        binding = FragmentStudiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView textViewChange1 =  (TextView) root.findViewById(R.id.konten_studi_1);
        TextView textViewChange2 =  (TextView) root.findViewById(R.id.konten_studi_2);
        TextView textViewChange3 =  (TextView) root.findViewById(R.id.konten_studi_3);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                textViewChange1.setText(dataSnapshot.child("mengapa").child("konten").child("0").getValue().toString());
                textViewChange2.setText(dataSnapshot.child("mengapa").child("konten").child("1").getValue().toString());
                textViewChange3.setText(dataSnapshot.child("mengapa").child("konten").child("2").getValue().toString());
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
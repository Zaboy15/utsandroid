package com.undira.tiundira.ui.visimisi;

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
import com.undira.tiundira.databinding.FragmentVisiBinding;

public class VisiFragment extends Fragment {

    private FragmentVisiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VisiViewModel homeViewModel =
                new ViewModelProvider(this).get(VisiViewModel.class);

        binding = FragmentVisiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://tiundiraandroid-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        TextView textViewSubHeader1 =  (TextView) root.findViewById(R.id.textView);
        TextView textViewKonten1 =  (TextView) root.findViewById(R.id.textView2);
        TextView textViewSubHeader2 =  (TextView) root.findViewById(R.id.header_misi);
        TextView textViewBull1 =  (TextView) root.findViewById(R.id.bull_kontent_misi_1);
        TextView textViewBull2 =  (TextView) root.findViewById(R.id.bull_kontent_misi_2);
        TextView textViewBull3 =  (TextView) root.findViewById(R.id.bull_kontent_misi_3);
        TextView textViewBull4 =  (TextView) root.findViewById(R.id.bull_kontent_misi_4);
        TextView textViewBull5 =  (TextView) root.findViewById(R.id.bull_kontent_misi_5);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                textViewSubHeader1.setText(snapshot.child("visimisi").child("sub_header").child("sub_header_misi").getValue().toString());
                textViewKonten1.setText(snapshot.child("visimisi").child("konten_visi").child("0").getValue().toString());
                textViewSubHeader2.setText(snapshot.child("visimisi").child("sub_header").child("sub_header_visi").getValue().toString());
                textViewBull1.setText(snapshot.child("visimisi").child("konten_misi").child("0").getValue().toString());
                textViewBull2.setText(snapshot.child("visimisi").child("konten_misi").child("1").getValue().toString());
                textViewBull3.setText(snapshot.child("visimisi").child("konten_misi").child("2").getValue().toString());
                textViewBull4.setText(snapshot.child("visimisi").child("konten_misi").child("3").getValue().toString());
                textViewBull5.setText(snapshot.child("visimisi").child("konten_misi").child("4").getValue().toString());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + error.getCode());

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
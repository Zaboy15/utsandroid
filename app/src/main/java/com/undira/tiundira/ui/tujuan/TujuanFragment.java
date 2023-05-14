package com.undira.tiundira.ui.tujuan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.undira.tiundira.databinding.FragmentTujuanBinding;

public class TujuanFragment extends Fragment {

    private FragmentTujuanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TujuanViewModel homeViewModel =
                new ViewModelProvider(this).get(TujuanViewModel.class);

        binding = FragmentTujuanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
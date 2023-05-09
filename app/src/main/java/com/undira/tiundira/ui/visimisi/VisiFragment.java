package com.undira.tiundira.ui.visimisi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.undira.tiundira.databinding.FragmentVisiBinding;

public class VisiFragment extends Fragment {

    private FragmentVisiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VisiViewModel homeViewModel =
                new ViewModelProvider(this).get(VisiViewModel.class);

        binding = FragmentVisiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
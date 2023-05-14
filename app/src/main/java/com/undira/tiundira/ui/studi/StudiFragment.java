package com.undira.tiundira.ui.studi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.undira.tiundira.databinding.FragmentStudiBinding;

public class StudiFragment extends Fragment {

    private FragmentStudiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StudiViewModel homeViewModel =
                new ViewModelProvider(this).get(StudiViewModel.class);

        binding = FragmentStudiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
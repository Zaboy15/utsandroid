package com.undira.tiundira.ui.hubungi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.undira.tiundira.databinding.FragmentHubungiBinding;

public class HubungiFragment extends Fragment {

    private FragmentHubungiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HubungiViewModel homeViewModel =
                new ViewModelProvider(this).get(HubungiViewModel.class);

        binding = FragmentHubungiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
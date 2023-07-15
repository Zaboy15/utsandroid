package com.undira.tiundira.ui.profil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Picasso;
import com.undira.tiundira.R;
import com.undira.tiundira.databinding.FragmentProfilBinding;

public class ProfilFragment extends Fragment {

    private FragmentProfilBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfilViewModel homeViewModel =
                new ViewModelProvider(this).get(ProfilViewModel.class);

        binding = FragmentProfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ImageView imageView = root.findViewById(R.id.banner_ti);
        ImageView imageView2 = root.findViewById(R.id.banner_network);
        ImageView imageView3 = root.findViewById(R.id.banner_nee);
        ImageView imageView4 = root.findViewById(R.id.banner_lanjut);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/tiundiraandroid.appspot.com/o/banner_ti.png?alt=media&token=17148b33-f3a2-452a-966a-fe52a764286a")
                .into(imageView);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/tiundiraandroid.appspot.com/o/banner_network.png?alt=media&token=1987dc0f-1014-47a0-9293-dda834f9ec7d")
                .into(imageView2);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/tiundiraandroid.appspot.com/o/banner_nee.png?alt=media&token=3060bf37-135f-4e69-a40d-3fa5e9058b1c")
                .into(imageView3);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/tiundiraandroid.appspot.com/o/banner_studi.png?alt=media&token=e9a89721-b1ce-46bb-8360-27be3b9adc7a")
                .into(imageView4);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
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
        Semester1.add("Kalkulus");
        Semester1.add("Aplikasi Komputer");
        Semester1.add("Algoritma & Pemrograman 1");
        Semester1.add("Pengantar Sistem Digital");
        Semester1.add("Sistem Basis Data");
        Semester1.add("Bahasa Indonesia");
        Semester1.add("Pancasila");

        List<String> Semester2 = new ArrayList<String>();
        Semester2.add("Struktur Data dan Algoritma");
        Semester2.add("Algoritma & Pemrograman 2");
        Semester2.add("Aljabar Linier");
        Semester2.add("Pendidikan Karakter");
        Semester2.add("Kewirausahaan I");
        Semester2.add("Perancangan Basis Data");

        List<String> Semester3 = new ArrayList<String>();
        Semester3.add("Kewirausahaan 2");
        Semester3.add("Rekayasa Perangkat Lunak");
        Semester3.add("Pemrograman Basis Data");
        Semester3.add("Pendidikan Agama");
        Semester3.add("Bahasa Inggris 1");
        Semester3.add("Sistem Operasi");
        Semester3.add("Matematika Diskrit");


        List<String> Semester4 = new ArrayList<String>();
        Semester4.add("Pemrograman Berorientasi Objek");
        Semester4.add("Dasar Pemrograman Web");
        Semester4.add("Bahasa Inggris 2");
        Semester4.add("Sistem Multimedia");
        Semester4.add("Interaksi Manusia-Komputer");
        Semester4.add("Kewarganegaraan");
        Semester4.add("Pengantar Jaringan Komputer");

        List<String> Semester5 = new ArrayList<String>();
        Semester5.add("Pengantar Kecerdasan Buatan");
        Semester5.add("Statistika dan Probabilitas");
        Semester5.add("Komputer dan Masyarakat");
        Semester5.add("Pilihan Software Engineer");
        Semester5.add("Analisa Pengembangan Perangkat Lunak");
        Semester5.add("Pemrograman Web Lanjut");
        Semester5.add("Desain Web UI & UX");
        Semester5.add("Basis Data Lanjut");
        Semester5.add("Pilihan Network Enterprise Engineer");
        Semester5.add("Praktikum Pengantar Jaringan Komputer");
        Semester5.add("Sistem Operasi Open Source");
        Semester5.add("Cloud Computing");
        Semester5.add("IT Essential");

        List<String> Semester6 = new ArrayList<String>();
        Semester6.add("Kerja Praktek");
        Semester6.add("Penulisan Karya Ilmiah");
        Semester6.add("Manajemen Proyek");
        Semester6.add("Pemrograman Android");
        Semester6.add("Pengembangan Perangkat Lunak Agile");
        Semester6.add("Switching dan Routing");
        Semester6.add("Praktikum Switching dan Routing");
        Semester6.add("Keamanan Jaringan Komputer");
        Semester6.add("Jaringan Enterprise");
        Semester6.add("Pemrograman Web Full Stack");

        List<String> Semester7 = new ArrayList<String>();
        Semester7.add("Metodologi Penelitian Teknologi Informasi");
        Semester7.add("English Conversation");
        Semester7.add("Pemrograman Games");
        Semester7.add("Pengenalan Big Data");
        Semester7.add("Proyek Perangkat Lunak");
        Semester7.add("Implementasi Proyek Perangkat Lunak");
        Semester7.add("Keamanan Sistem Informasi");
        Semester7.add("Internet of Things (IOT)");
        Semester7.add("Jaringan VOIP");
        Semester7.add("Proyek Jaringan Komputer");
        Semester7.add("Implementasi Proyek Jaringan Komputer");
        Semester7.add("Network Otomatisasi Scripting");

        List<String> Semester8 = new ArrayList<String>();
        Semester8.add("Tugas Akhir");






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
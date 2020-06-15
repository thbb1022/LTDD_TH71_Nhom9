package com.example.docsach;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Book> lstBook;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleview_id);
        lstBook = new ArrayList<>();
        lstBook.add(new Book("Linh vũ thiên hạ", "(Tiên hiệp)", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));
        lstBook.add(new Book("Tên truyen", "category", "description", R.drawable.a));

        Context context = container.getContext();
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(context, lstBook);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(myAdapter);
        return view;
    }

}

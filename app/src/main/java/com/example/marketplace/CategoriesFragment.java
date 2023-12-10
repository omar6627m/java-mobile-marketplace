package com.example.marketplace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Objects;


public class CategoriesFragment extends Fragment implements CategoryAdapter.OnCategoryClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        // List the categories
        String[] categoryArray = {"Cars", "Houses", "Phones", "Laptops", "Furniture"};

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2)); // Two columns
        recyclerView.setAdapter(new CategoryAdapter(categoryArray, this));

        return view;
    }

    @Override
    public void onCategoryClick(String category) {
        // Handle the category click, for example, show a toast
        Toast.makeText(requireContext(), "Clicked: " + category, Toast.LENGTH_SHORT).show();
    }
}
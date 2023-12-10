package com.example.marketplace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class AddProductFragment extends Fragment {
    private EditText editTextName;
    private EditText editTextImageUrl;
    private EditText editTextPrice;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_product, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextImageUrl = view.findViewById(R.id.editTextImageUrl);
        editTextPrice = view.findViewById(R.id.editTextPrice);


        Button addProductButton = view.findViewById(R.id.buttonAddProduct);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return view;
    }
}
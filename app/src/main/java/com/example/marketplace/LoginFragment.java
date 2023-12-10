package com.example.marketplace;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketplace.model.User;
import com.example.marketplace.model.UserSingleton;


public class LoginFragment extends Fragment {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonSignup;
    private TextView textViewError;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonSignup = view.findViewById(R.id.buttonSignup);
        textViewError = view.findViewById(R.id.textViewError);

        buttonLogin.setOnClickListener(v -> {
            // Perform login logic here
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            // Example: Check if username and password are not empty
            if (!username.isEmpty() && !password.isEmpty()) {
                if (username.equals("ramo") && password.equals("1234")){
                    // Successful login, hide error message
                    textViewError.setVisibility(View.GONE);
                    UserSingleton.getInstance().setCurrentUser(new User("ramo","1234"));
                    if (reloadListener != null) {
                        reloadListener.onReload();
                    }
                    Toast.makeText(requireContext(), "Logged In!", Toast.LENGTH_SHORT).show();
                    navigateToAnotherFragment();
                }else{
                    // Display error message
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Incorrect Username or Password.");
                }
            } else {
                // Display error message
                textViewError.setVisibility(View.VISIBLE);
                textViewError.setText("Please enter both username and password.");
            }
        });

        buttonSignup.setOnClickListener(v -> {
            // Perform login logic here
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            // Example: Check if username and password are not empty
            if (!username.isEmpty() && !password.isEmpty()) {
                if (username.equals("ramo") && password.equals("1234")){
                    // Successful login, hide error message
                    textViewError.setVisibility(View.GONE);
                    UserSingleton.getInstance().setCurrentUser(new User("ramo","1234"));
                    if (reloadListener != null) {
                        reloadListener.onReload();
                    }
                    Toast.makeText(requireContext(), "Signed Up!", Toast.LENGTH_SHORT).show();
                    navigateToAnotherFragment();
                }else{
                    // Display error message
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Incorrect Username or Password.");
                }
            } else {
                // Display error message
                textViewError.setVisibility(View.VISIBLE);
                textViewError.setText("Please enter both username and password.");
            }
        });

        return view;
    }

    private void navigateToAnotherFragment() {
        // Replace the current fragment with another one
        if (getActivity() != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, new CategoriesFragment()) // Replace with the fragment you want to navigate to
                    .addToBackStack(null) // Optional: Add to the back stack
                    .commit();
        }
    }

    public interface ReloadActivityListener {
        void onReload();
    }

    private ReloadActivityListener reloadListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ReloadActivityListener) {
            reloadListener = (ReloadActivityListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement ReloadActivityListener");
        }
    }
}
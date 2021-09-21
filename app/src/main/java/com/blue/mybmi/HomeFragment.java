package com.blue.mybmi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    FragmentActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle(R.string.textHome);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);
        EditText etHeight = view.findViewById(R.id.etHeight);
        EditText etWeight = view.findViewById(R.id.etWeight);


        button.setOnClickListener(v -> {
            String height = etHeight.getText().toString();
            String weight = etWeight.getText().toString();
            Bmi bmi = new Bmi(height, weight);
            bmi.getBMI();
            Bundle bundle = new Bundle();
            bundle.putSerializable("result", bmi);
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_resultFragment, bundle);
        });
    }
}
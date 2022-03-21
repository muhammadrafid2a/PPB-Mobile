package com.example.uas;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SimpleFragment extends Fragment {

        public SimpleFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_simple,
                    container, false);

            AppCompatActivity view;
            Button floatingActionButton2 = (Button) view.findViewById(R.id.floatingActionButton2);
            floatingActionButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
package com.example.fragmentexample3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {


    View view;
    private TextView textView_title;
    private TextView textView_text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);

        textView_title = view.findViewById(R.id.textView2);
        textView_text = view.findViewById(R.id.textView3);
        if(getArguments()!=null) {
            if(getArguments().getString("title") != null) {
                textView_title.setText(getArguments().getString("title"));
            }
            if(getArguments().getString("text") != null) {
                textView_text.setText(getArguments().getString("text"));
            }

        }

        return view;
    }
}

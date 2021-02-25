package com.example.fragmentexample3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SecondFragment frag = new SecondFragment();
        if(getIntent().getBooleanExtra("house",false)) {
            Bundle bundle = new Bundle();
            bundle.putString("title","House Information");
            bundle.putString("text",getString(R.string.house));
            frag.setArguments(bundle);
        }
        loadFragment(frag,R.id.fragContainer_second);
    }

    public void loadFragment(Fragment fragment, int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
}

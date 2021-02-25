package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean twoPane = false;
    private Button button_personality;
    private Button button_house;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if we cannot find the second fragment in the alyout
        //that means we only have 1 column -> portrait mode
        //if we can, that means landscape mode (2 panes)
        if(findViewById(R.id.fragContainer_land_second) != null) {
            twoPane = true;
        }

        //loading in whether 1 or 2 fragments based on this boolean variable
        if(!twoPane) { //portrait
            loadFragment(new FirstFragment(),R.id.fragContainer_first);
            button_personality = findViewById(R.id.button_personality);
            button_personality.setOnClickListener(v -> launchActivity(v));

            button_house = findViewById(R.id.button_house);
            button_house.setOnClickListener(v -> launchActivityHouse(v));
        } else {
            loadFragment(new FirstFragment(),R.id.fragContainer_land_first);
            loadFragment(new SecondFragment(),R.id.fragContainer_land_second);
            Bundle bundle = new Bundle();
            bundle.putString("title","House Information");
            bundle.putString("text",getString(R.string.house));
            SecondFragment frag = new SecondFragment();
            frag.setArguments(bundle);
            loadFragment(frag,R.id.fragContainer_land_third);
        }
    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("house",false);
        startActivity(intent);
    }
    public void launchActivityHouse(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("house",true);
        startActivity(intent);
    }
}
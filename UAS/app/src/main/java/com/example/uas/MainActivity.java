package com.example.uas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

//public class MainActivity extends AppCompatActivity {
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.d( "lifecycle",  "onCreate dijalankan");
//        Toast.makeText(this, "onCreate dijalankan", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d( "lifecycle",  "onStart dijalankan");
//        Toast.makeText(this, "onStart dijalankan", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d( "lifecycle",  "onResume dijalankan");
//        Toast.makeText(this, "onResume dijalankan", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d( "lifecycle",  "onPause dijalankan");
//        Toast.makeText(this, "onPause dijalankan", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d( "lifecycle",  "onStop dijalankan");
//        Toast.makeText(this, "onStop dijalankan", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d( "lifecycle",  "onRestart dijalankan");
//        Toast.makeText(this, "onRestart dijalankan", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d( "lifecycle",  "onDestroy dijalankan");
//        Toast.makeText(this, "onDestroy dijalankan", Toast.LENGTH_SHORT).show();
//    }
//}


public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                mWordList.addLast("+ TUGAS " + wordListSize);
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        for (int i = 0; i < 2; i++) {
            mWordList.addLast("TUGAS " + i);
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
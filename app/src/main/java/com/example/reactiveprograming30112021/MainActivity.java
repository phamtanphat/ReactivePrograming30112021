package com.example.reactiveprograming30112021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> arrNames = new ArrayList<>(Arrays.asList("Tèo","Tý","Tủn"));
        Iterable<String> data = handleData(arrNames);

        Iterator<String> value = data.iterator();

        while (value.hasNext()){
            Log.d("BBB",value.next());
        }
    }

    public Iterable<String> handleData(List<String> arrNames) {
        for (int i = 0; i < arrNames.toArray().length; i++) {
            if (i == 1) {
                arrNames.set(i, arrNames.get(i) + " edit");
            }
        }
        return arrNames;
    }


}


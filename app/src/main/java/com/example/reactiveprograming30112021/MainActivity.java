package com.example.reactiveprograming30112021;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Log.d("BBB",generateString().get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Future<String> generateString() {
        Executor executor = Executors.newFixedThreadPool(1);
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        FutureTask<Void> future = new FutureTask<Void>(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Thread.sleep(2000);
                completableFuture.complete("abc");
                return null;
            }
        });
        executor.execute(future);
        return completableFuture;
    }


}


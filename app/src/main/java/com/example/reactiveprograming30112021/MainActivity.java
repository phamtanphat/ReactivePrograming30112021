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
import java.util.concurrent.ExecutorService;
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

        try {
            Log.d("BBB","Kết quả 1 : " + generateString().get());
            Log.d("BBB","Kết quả 2 : " + generateString1().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.d("BBB","Lỗi " + e.getMessage());
        } catch (InterruptedException e) {
            Log.d("BBB","Lỗi " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Future<String> generateString() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d("BBB",Thread.currentThread().getName());
                Thread.sleep(2000);
                return "abc";
            }
        });
        return future;
    }
    public Future<String> generateString1() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d("BBB",Thread.currentThread().getName());
                Thread.sleep(2000);
                return "def";
            }
        });
        return future;
    }


}


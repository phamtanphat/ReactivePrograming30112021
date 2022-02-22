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
import java.util.Random;
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


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
////            Log.d("BBB","Kết quả 1 : " + );
////            Log.d("BBB","Kết quả 2 : " + generateString1().get());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//            Log.d("BBB","Lỗi " + e.getMessage());
//        } catch (InterruptedException e) {
//            Log.d("BBB","Lỗi " + e.getMessage());
//            e.printStackTrace();
//        }
        try {
            Log.d("BBB","Kết quả : " + generateString2().get());
        } catch (ExecutionException e) {
            Log.d("BBB",e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            Log.d("BBB",e.getMessage());
            e.printStackTrace();
        }
    }

    public void generateString() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        Future<String> future = executorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Log.d("BBB",Thread.currentThread().getName());
//                Thread.sleep(2000);
//                return "abc";
//            }
//        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("BBB","1 " + Thread.currentThread().getName());
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB","2 " + Thread.currentThread().getName());
            }
        });
//        return future;
    }
    public void generateString1() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> future1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d("BBB",Thread.currentThread().getName());
                Thread.sleep(5000);
                return "def";
            }
        });


        Future<String> future2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d("BBB",Thread.currentThread().getName());
//                Thread.sleep(2000);
                return "abc";
            }
        });

        try {
            Log.d("BBB","Data 1 : + " + future1.get());
            Log.d("BBB","Data 2 : + " + future2.get());

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        return future;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<String> generateString2() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                if (random.nextBoolean()){
                    completableFuture.complete("Có data 1");
                }else{
                    completableFuture.completeExceptionally(new Throwable("Lỗi gì đó 1"));
                }
            }
        });

        return completableFuture;
    }

}


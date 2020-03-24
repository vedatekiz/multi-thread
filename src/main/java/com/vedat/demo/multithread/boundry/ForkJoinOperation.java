package com.vedat.demo.multithread.boundry;

import com.vedat.demo.multithread.util.Util;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ForkJoinOperation implements MultiThreadOperation {

    private int threadCount;

    public ForkJoinOperation(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public void doOperation(int listSize) {
        List<Long> applicationIdList = Util.generateApplicationIdList(listSize);
        Future result = ForkJoinPoolFactory.getPoolInstance(threadCount).submit(() -> {
            applicationIdList.parallelStream().forEach(id -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("Record Processed. Number: " + id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        // wait till operation is finished.
        try {
            result.get();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("InterruptedException");
        }catch (ExecutionException e) {
            System.out.println("ExecutionException" );
        }
    }

    @Override
    public String operationName() {
        return "FORK JOIN";
    }
}

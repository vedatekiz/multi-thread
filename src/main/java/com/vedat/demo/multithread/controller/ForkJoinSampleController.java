package com.vedat.demo.multithread.controller;

import com.vedat.demo.multithread.boundry.ForkJoinPoolFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/forkjoin")
public class ForkJoinSampleController {

    @RequestMapping("/start-process")
    public void forkjoin() {
        Long[] applicationIdList = new Long[300];
        for(int i = 0;i<300;i++){
            applicationIdList[i] = Long.valueOf(i);
        }

        List<Long> applicationIds = Collections.synchronizedList(Arrays.asList(applicationIdList));
        System.out.println("*****STARTED*****");
        long startTime = System.currentTimeMillis();
        Future result = ForkJoinPoolFactory.getPoolInstance(8).submit(() -> {
            applicationIds.parallelStream().forEach(id -> {
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
            System.out.println("*****FINISHED*****");
            long endTime = System.currentTimeMillis();
            System.out.println("EXECUTION TIME: " + (endTime - startTime));
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("InterruptedException");
        }catch (ExecutionException e) {
            System.out.println("ExecutionException" );
        }
    }
}
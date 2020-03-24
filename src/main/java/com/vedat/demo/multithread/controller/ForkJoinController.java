package com.vedat.demo.multithread.controller;

import com.vedat.demo.multithread.boundry.ForkJoinOperation;
import com.vedat.demo.multithread.boundry.MultiThreadOperationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/forkjoin")
public class ForkJoinController {

    @RequestMapping("/start-process/{listSize}")
    public ResponseEntity<Long> multiThread(@PathVariable("listSize") Integer listSize) {
        MultiThreadOperationContext context = new MultiThreadOperationContext(new ForkJoinOperation(8));
        return ResponseEntity.ok(context.executeMultiThreadOperation(listSize));
        /*
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

         */
    }
}
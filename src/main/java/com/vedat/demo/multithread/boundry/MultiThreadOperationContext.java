package com.vedat.demo.multithread.boundry;

public class MultiThreadOperationContext {

    private MultiThreadOperation multiThreadOperation;

    public MultiThreadOperationContext(MultiThreadOperation multiThreadOperation) {
        this.multiThreadOperation = multiThreadOperation;
    }

    public Long executeMultiThreadOperation(int listSize){
        System.out.println(multiThreadOperation.operationName() + " *****STARTED*****");
        long startTime = System.currentTimeMillis();
        multiThreadOperation.doOperation(listSize);
        System.out.println(multiThreadOperation.operationName() + " *****FINISHED*****");
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(multiThreadOperation.operationName() + " EXECUTION TIME: " + duration);
        return duration;
    }
}

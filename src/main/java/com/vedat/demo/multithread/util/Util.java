package com.vedat.demo.multithread.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Util {

    public static List<Long> generateApplicationIdList(int size){
        Long[] applicationIdList = new Long[size];
        for(int i = 0;i<size;i++){
            applicationIdList[i] = Long.valueOf(i);
        }
        return Collections.synchronizedList(Arrays.asList(applicationIdList));
    }
}

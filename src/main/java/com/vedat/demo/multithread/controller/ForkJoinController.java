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
    }
}
package com.vedat.demo.multithread.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/forkjoin")
public class ForkJoinSampleController {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }
}

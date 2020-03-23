package com.vedat.demo.multithread.boundry;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolFactory {
	
	public static ForkJoinPool getPoolInstance(int parallelism ){
		return new ForkJoinPool(parallelism);
		
	};

}

package com.aoblah.queueshare;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//input queue to send random numbers from Randomizer Thread
		BlockingQueue<Integer> inputQueue = new LinkedBlockingQueue<Integer>();
		//output queue to receive results from Prime Thread
		BlockingQueue<String> outputQueue = new LinkedBlockingQueue<String>();
		
		
		//Instantiate and start Randomizer and Prime Threads
		Randomizer randomizer = new Randomizer(inputQueue, outputQueue);
		Prime prime = new Prime(inputQueue, outputQueue);
		
		System.out.println("Starting Application ...");
		new Thread(randomizer).start();
		new Thread(prime).start();
		
		
	}
	
	
	

}

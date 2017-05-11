package com.aoblah.queueshare;

import java.util.concurrent.BlockingQueue;

/*
 * Prime Class
 */

public class Prime implements Runnable{

	private BlockingQueue<Integer> inputQueue; // queue from randomizer containing input
	private BlockingQueue<String> outputQueue; // queue from prime containing result
	private String answer = "";
	private Boolean isPrime = false;


	
	//Constructor for queue initialization
	public Prime(BlockingQueue<Integer> inputQueue,
			BlockingQueue<String> outputQueue) {
		// TODO Auto-generated constructor stub
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
	}

	/* 
	 * Thread gets number from input queue (from Randomizer thread), checks if number is
	 * prime and returns the result to the output queue in the string format
	 * <number>:<boolean value> ex: "2:true"
	 */
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{ 
				if (!inputQueue.isEmpty()){
					int number = inputQueue.take();
					isPrime = checkPrime(number) ? true:false;
					answer = number + ":";
					answer += isPrime; 
					outputQueue.put(answer);		
				}
				
				// Making this thread sleep for a second so results are observable
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}

		}


	}


	private Boolean checkPrime(int n){

		// if n is 0 or 1 or negative, return false
		if(n == 0 || n == 1 || n < 0){
			return false;
		}

		//if n is 2, return prime (true)
		if (n == 2){
			return true;
		}

		//check if n is a multiple of 2 - if n is not 2 and a multiple of true, it's not prime
		if (n%2==0){
			return false;
		}

		//if not, then just check the odds
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0){
				return false;
			}
		}

		return true;		
	}

}

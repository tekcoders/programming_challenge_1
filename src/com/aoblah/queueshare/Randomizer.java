package com.aoblah.queueshare;


import java.util.concurrent.BlockingQueue;

public class Randomizer implements Runnable {

	private BlockingQueue<Integer> inputQueue; // queue from randomizer containing input
	private BlockingQueue<String> outputQueue; // queue from prime containing result
	private int randomNumber = 0;
	private String answer = "";

	public Randomizer(BlockingQueue<Integer> inputQueue,
			BlockingQueue<String> outputQueue) {
		// TODO Auto-generated constructor stub
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
	}

	/*
	 * Randomizer thread sends random integers to the input queue and reads output from
	 * the Prime thread containing the result. 
	 */
	

	@Override
	public void run() {
		while(true){
			try{

				// gets & places random integers in the inputQueue
				randomNumber = getRandomNumber();
				inputQueue.put(randomNumber);

				//reads results from the outputQueue
				if (!outputQueue.isEmpty()){
					answer = outputQueue.take();
					if(answer.split(":")[1].equals("true")){
						System.out.println(answer.split(":")[0] + " --> " + "Prime");
					}
					else{
						System.out.println(answer.split(":")[0] + " --> " + "Not Prime");
					}

				}

				// Making this thread sleep for a second so results are observable
				Thread.sleep(1000);

			}
			catch(Exception e){
				e.printStackTrace();
			}
		}




	}

	/*
	 * Generates random integers between 1 and 100
	 */

	private int getRandomNumber(){
		int randomNumber = (int) (Math.random() * (100 + 1));
		return randomNumber;
	}

}

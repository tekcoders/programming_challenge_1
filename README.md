# Programming Challenge 1

This repository contains the code for programming challenge 1

## Brief Description of the Program:

* This program contains two threads which share a queue.
* Randomizer thread generates random numbers between 1 and 100 (customizable) and sends it to the input queue.
* Prime Thread receives the numbers from the inputQueue, checks if they are prime and writes the result to the output queue 
* Randomizer thread then receives the result from the output queue and displays it. 
* A blocking queue is used for this purpose.
* Threads run infinitely until you stop it. 

## Instructions to run the program

* Import the project in your IDE (I've used Eclipse)
* Run App.java and view the results in the console. 

## Video to see the code in action.

https://streamable.com/nsnpr

Please let me know if you need any more information. 

package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("How much money are you starting with?");
		double startAmount = in.nextDouble();
		double startingPoint = startAmount;
		
		System.out.println("What is the probability that you win?");
		double winChance = in.nextDouble();
		
		System.out.println("At what amount will you be happy to leave?");
		double winLimit = in.nextDouble();
		
		System.out.println("How many days do you want to simulate?");
		int totalSimulations = in.nextInt();
		
		int ruins = 0;
		
		for(int i = 1; i <= totalSimulations; i++) {
			System.out.println("Day " + i);
			int timesPlayed = 0;
			while(startAmount < winLimit && startAmount != 0) {
				if(Math.random() <= winChance) {
					startAmount++;
				}
				else {
					startAmount--;
				}
				timesPlayed++;
			}
		
			if (startAmount == winLimit) {
				System.out.println("You won!");
			}
			else {
				System.out.println("You lost!");
				ruins++;
			}
			
			System.out.println("You played " + timesPlayed + " times.");
			
			startAmount = startingPoint;
		}
		
		double ruinRate = (double) (1.0 * ruins / totalSimulations);
		double a = (1 - winChance) / winChance;
		double expectedRuinRate = 0;
		
		if (winChance == 0.5) {
			expectedRuinRate = 1 - startAmount/winLimit;
		}
		else {
			expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		
		System.out.println("Losses: " + ruins);
		System.out.println("Simulations: " + totalSimulations);
		
		System.out.println("Ruin rate: " + ruinRate);
		System.out.println("Expected ruin rate: " + expectedRuinRate);
	}
	
}

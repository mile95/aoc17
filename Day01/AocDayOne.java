
import java.util.*;
import java.io.*;

public class AocDayOne {

	static ArrayList<Integer> testArray; 
	static int sum = 0; 
	static String input;

	public static void main(String [] args) {

		testArray = new ArrayList<Integer>();

		//Get input from inputDay1.txt --> Go from string to int. --> Save in testArray.

		try {
			File file = new File("inputDay1.txt");
			Scanner sc = new Scanner(file);
			input = sc.nextLine();
		}
		catch (Exception e) {
		}

		for (int i = 0; i < input.length(); i++) {
			int tmp = Character.getNumericValue(input.charAt(i));
			testArray.add(tmp);
		}
		System.out.println(countSumPartB(testArray));
	}

	public static int countSumPartA (ArrayList<Integer> sequence) {

		for(int i = 0; i < sequence.size(); i++) {
			int temp = sequence.get(i);

			if(i != sequence.size() - 1) {

				if(temp == sequence.get(i+1)) {
					sum = sum + temp; 
				}
			}
			//Circular, check if last value == first value

			if(i == sequence.size() - 1) {
				if(sequence.get(i) == sequence.get(0)) {
					sum = sum + sequence.get(i);
				}
			}
		}
		return sum;
	}

	public static int countSumPartB (ArrayList<Integer> sequence) {

		int lengthOfList = sequence.size();
		int halfLength 	 = lengthOfList/2; 

		//Using % since circular. 

		for(int i = 0; i < sequence.size(); i++) {
			int temp = sequence.get(i); 
				if(temp == sequence.get((i + halfLength)%lengthOfList)) {
					sum = sum + temp;
				}
			}
		return sum; 
	}
}
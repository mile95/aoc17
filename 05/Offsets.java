import java.util.*;
import java.io.*;


public class Offsets {
 
	static Scanner sc; 
	static ArrayList<Integer> inputList; 

	public static void main (String[] args) {

		inputList = new ArrayList<Integer>(); 

		try {
			File file = new File("input.txt");
			sc = new Scanner(file);	

			while(sc.hasNext()) {
				inputList.add(sc.nextInt());
			}

		}
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(partA(inputList));
		System.out.println(partB(inputList));
	}


	public static int partA (ArrayList<Integer> aList) {

		int steps 	= 0; 
		int i 		= 0; 

		while( i < aList.size()) {

			if(aList.get(i).equals(0)) {
				aList.set(i,1); 
				steps++; 
			}

			else  {
				Integer tmp = aList.get(i); 
				aList.set(i, tmp + 1);
				i = i + tmp;
				steps++; 
			}
		}

		return steps;
	}


	public static int partB (ArrayList<Integer> aList) {
			
		int steps	 = 0; 
		int i 		 = 0; 

		while( i < aList.size()) {

			if(aList.get(i).equals(0)) {
				aList.set(i,1); 
				steps++; 
			}

			else  {
				Integer tmp = aList.get(i);

				if(tmp >= 3) {
					aList.set(i, tmp - 1);	
				}
				else {
					aList.set(i,tmp + 1);
				}

				i = i + tmp;
				steps++; 
			}

		}

	return steps; 

	}

}
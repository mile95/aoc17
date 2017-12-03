import java.util.*;
import java.io.*;


public class Checksum {

	static int sum = 0; 
	static List<List<Integer>> inputList;
	static List<String> inputListTemp; 


	public static void main(String[] args) {

		inputListTemp = new ArrayList<>();
		inputList 	  = new ArrayList<>();

		try {
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);
			for(int i = 0; sc.hasNextLine(); i++) {
				inputListTemp.add(sc.nextLine());
			}
		}
		catch (Exception e) {
		}

		//Going from List<String> to List<List<Integer>>

		for(int i = 0; i < inputListTemp.size(); i++) {
			List<String> parts = Arrays.asList(inputListTemp.get(i).split("\\s+"));
			List<Integer> convertList = new ArrayList<>();
			for(int k = 0; k < parts.size();k++) {
				convertList.add(Integer.parseInt(parts.get(k)));
			}
			inputList.add(convertList);
		}

		System.out.println(getChecksumPartB(inputList));
	}

	public static int getChecksumPartA(List<List<Integer>> input) {

		for(int i = 0; i < input.size(); i++) {
			int max = Collections.max(input.get(i));
			int min = Collections.min(input.get(i));
			sum = sum + (max-min);
		}
		return sum;
	}

	//Rewrite this. Works but, not good/ok time complexity.
	//Returning sum/2 since checking all integers with each other twice. 

	public static int getChecksumPartB(List<List<Integer>> input) {

		for(int row = 0; row < input.size(); row++) {
			for(int col = 0; col < input.get(row).size(); col++) {
				for(int pos = 0; pos < input.get(row).size();pos++) {

					int tmp = input.get(row).get(col); 
					int tmpnext = input.get(row).get(pos);
					int tmpFinal = Math.max(tmp,tmpnext);
					int tmpNextFinal = Math.min(tmp,tmpnext);

					if(tmpFinal % tmpNextFinal == 0 && (tmpFinal != tmpNextFinal)) {
						sum = sum + (tmpFinal/tmpNextFinal);
					}
				}
			}
		}
		return sum/2; 
	}
}
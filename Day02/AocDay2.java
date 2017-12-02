
import java.util.*;
import java.io.*;


public class AocDay2 {

	static int sum = 0; 
	static List<List<Integer>> list = new ArrayList<>();
	static List<String> subList = new ArrayList<>();


	public static void main(String[] args) {

		try {
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);
			int i = 0; 
			while(sc.hasNext()) {
				subList.add(sc.nextLine());
				System.out.println(subList.get(i));
				i++;
			}

		}
		catch (Exception e) {
		}
	}

	public int getChecksum() {

		return 0;
	}
}
import java.util.*;
import java.io.*;

public class Passphrase {

	static int sum = 0; 
	static Scanner sc; 
	static List<Boolean> listOfOkPass; 
	static boolean taskA = false; 
	static boolean taskB = !taskA; 

	public static void main(String [] args) {

		try {
			File file = new File("input.txt");
			sc = new Scanner(file);	
		
			for(int i = 0; sc.hasNext();i++){
				String tmpString = sc.nextLine();
				String[] splited = tmpString.split("\\s+"); //Get every word. 

				if(taskA) {
					if(isAlone(splited)) {
						sum = sum + 1;						//If alone --> sum++; 
					}
				}

				if(taskB) {
					if(checkAnagramWholeList(splited)) {
						sum = sum + 1;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(sum);	
	}

	private static boolean isAlone (String[] s) {
        Set<String> set = new HashSet<>(Arrays.asList(s)); //Only unique words. 
        return set.size() == s.length; 					   // If same length, no duplicate words.
    }

    private static boolean checkAnagramFirst(String s1 , String s2) {
    	char [] s1List = s1.toCharArray();
    	char [] s2List = s2.toCharArray();
    	Arrays.sort(s1List);								// Sort by letters.
    	Arrays.sort(s2List);
    	return Arrays.equals(s1List,s2List);
    }

    private static boolean checkAnagramWholeList (String [] s) {

    	for(int i = 0; i < s.length - 1; i++) {	
    		for(int k = i + 1; k < s.length; k++) {
    			if(checkAnagramFirst(s[i],s[k])) {			//Check every word with every other words. 
    				return false;
    			}
    		} 
    	}
    	return true;
    }
}
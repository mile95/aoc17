import java.util.*;

// Comments: Needed some help with this solution. Not entirely my solution. Only part a. 

public class SpiralPattern {

	/*Input: 
	17 16 15 14    13
	18 5  4   3    12 
	19 6  1	  2    11
	20 7  8	  3^2  10
	21 22 23  24   5^2
	-- -- --  --   -- 7^2*/

	static int input = 361527;
	static int total = 1; 
	static int level = 1; 

	public static void main(String[] args) {
		System.out.println(getSteps(input));
	}

	public static double getSteps(int input) {

		while(total < input) {
			level = level + 2; 
			total = (int) Math.pow(level,2);	
		}

		int offset = total - input; 
		int steps  = offset % (level - 1);

		return (level - 1) / 2 + (int) Math.abs((level / 2) - steps);
	}
}
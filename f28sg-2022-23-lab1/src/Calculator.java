import java.util.Arrays;

// exception used for Q5
class CalculateException extends RuntimeException{    
	public CalculateException(String err) {
		super(err);
	}
}

/**
 * @author Ahmad Meda
 *
 */
public class Calculator {

	/*
	 *  Methods for Part 3
	 */
	/**
	 * @param cmds
	 * @return the final value after the assigned calculations
	 */
	public static int calculate(String [] cmds){
		Stack pstack = new Stack(100);
		//reversing the array using the reverse function
		Reverse.reverse(cmds);
		System.out.println(Arrays.toString(cmds));
		//To Print out each element
		for(int i = 0; i < cmds.length; i++) {
			String string1 = cmds[i];
			if(isNumber(string1)== false) {
				//As 2 numbers are needed for a calculation
				// variable used to store the first number popped out of the stack
				String value1 = pstack.pop().toString();
				// second variable to store the popped number 
				String value2 = pstack.pop().toString();
				//push the final value after doing the calculation of 2 numbers using the applyOp method
				pstack.push(applyOp(value1,cmds[i],value2));
			}else {
				pstack.push(cmds[i]);
			}
		}
		
		return convert(pstack.pop().toString());
	}	

	/**
	 * @param s
	 * @return value of string converted to integer
	 * @throws NumberFormatException
	 */
	public static int convert(String s) throws NumberFormatException{
		//cmd of turning a value string to an integer value
		return Integer.parseInt(s); 
		
	}

	/**
	 * @param s
	 * @return a boolean value on whether if its a string or a number
	 */
	public static boolean isNumber(String s){
		boolean sample_bool = false;
		for(int i = 0; i < s.length(); i++) {
			// 
			sample_bool = Character.isDigit(s.charAt(i));
		}
		return sample_bool; 
	}

	// apply the operator after converting the numbers
	/**
	 * @param fst
	 * @param op
	 * @param snd
	 * @return the value done after the assigned calculation
	 */
	public static int applyOp(String fst,String op,String snd){
		int nm_1 = convert(fst);
		int nm_2 = convert(snd);
		if (op=="+") {
			return nm_1 + nm_2;	
		}
		if (op=="-") {
			return nm_1 - nm_2;	
		}
		if (op=="*") {
			return nm_1 * nm_2;	
		}
		if (op=="/") {
			return nm_1 / nm_2;	
		}
		return 0;
		
	}

	// main operation to calculate using Polish notation directly
    public static int calculatePolish(String [] cmds){
    	return -1; // dummy value
    }
}

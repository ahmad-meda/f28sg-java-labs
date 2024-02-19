
/**
 * @author Ahmad Meda
 *
 */
public class Reverse {

	// Part 2
	/**
	 * @param arr
	 */
	//method for returning a a reversed array
	public static void reverse(String[] arr){ 
		// to reverse, push elements in arr array to stack and then add them back to the array
		Stack stack_ob = new Stack(arr.length);
		
		//for loop to push the elements in the arr array to the stack
		for(int i = 0; i < arr.length; i++) {
			stack_ob.push(arr[i]);
		}
		
		//for loop to push the elements in the stack to the arr array
		for(int i = 0; i < arr.length; i++) {
			arr[i] =(String)stack_ob.pop();
			
		}
	}
	
}

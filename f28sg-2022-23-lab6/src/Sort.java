
/**
 * @author Ahmad Meda
 *
 */
public class Sort {
	/**
	 * Part 4
	 * @param arr
	 */
	public static void sort(int[] arr){	
		//Create an object of type PriorityQueue
		PriorityQueue temp_queue = new PriorityQueue(arr.length);
		//Iterate through each element Of PriorityQueue and add it do temp_queue
		for(int i = 0; i < arr.length; i++ ) {
			temp_queue.insert(arr[i]);
		}
		//Arrange the elements of the array in order(Ascending) 
		for(int i = 0; i < arr.length; i++ ) {
			arr[i] = temp_queue.removeMin();
		}
		
		
		
	}
	
	public static void main(String[] args){
		int[] arr = {53,3,5,2,4,67};
		Sort.sort(arr);
		// should be printed in order
		System.out.println(arr[0]);
		System.out.println(arr[1]);	
		System.out.println(arr[2]);
		System.out.println(arr[3]);	
		System.out.println(arr[4]);	
		System.out.println(arr[5]);	
	}
	
}

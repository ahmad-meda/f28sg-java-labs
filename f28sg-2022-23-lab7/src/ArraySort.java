import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Ahmad Meda
 *
 */
public class ArraySort {

	/** Insertion sort of an array
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/** Insertion sort of an array
	 * 
	 * This is Question 3
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {
		boolean swap = true;
		while (swap == true) {
			swap = false;
			for (int i = 0; i < (arr.length -1); i++) {
				if (arr[i+1] < arr[i]) {
					int temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
					swap = true;
				}
			}
		}
		
	}

	// Part 5 : complete implementation
	
	/**
	 * @param S
	 * @return the sorted array by using the method quick sort
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {
		//If condition: if the size of the list is 0 or 1,it is sorted so return the array S
		if (S.size() <= 1) {
			return S;
		}
		//Get the middle element of the Array
		int pivot_element = S.get(S.size()/2);
		//store elements of S that are less than the pivot 
		ArrayList<Integer> L = new ArrayList<Integer>();
		//store elements of S that are Equal than the pivot 
		ArrayList<Integer> E = new ArrayList<Integer>();
		//store elements of S that are Greater than the pivot 
		ArrayList<Integer> G = new ArrayList<Integer>();
		
		while(!S.isEmpty()) {
			//Delete the first element of the S array
			int del_element = S.get(0);
			S.remove(0);
			//If the deleted element is less than pivot than add it to L array
			if (del_element < pivot_element) {
				L.add(del_element);
			}
			//If the deleted element is greater than pivot than add it to G array
			else if (del_element > pivot_element) {
				G.add(del_element);
			}
			//If the deleted element is Equal to the pivot than add it to E array
			else {
				E.add(del_element);
			}
		}
		//use recursion to sort the elements in array L and G
		quickSort(L);
		quickSort(G);
		//Add all L,E and G arrays to S
		S.addAll(L);
		S.addAll(E);
		S.addAll(G);
		//Return S
		return S;
		
	}

	
	/** predicate to check if array is sorted
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	
	/** predicate to check if arrayList is sorted.
	 *  Useful for checking ArrayList<Integer> lists returned
	 *  from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	
	/** Helper printing methods for testing
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};

	}

}

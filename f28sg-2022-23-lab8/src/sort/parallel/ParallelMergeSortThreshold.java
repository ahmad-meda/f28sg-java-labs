/**
 * @author Ahmad Meda
 *
 */
package sort.parallel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import sort.sequential.SequentialMergeSort;
import sort.sequential.SortingCommon;
import utils.Benchmark;

/*
 * Merge Sort results with thresholding
 * ~~~~~~~~~~~~~~~~~~
 *
 * After parallelisation:
 * - 1 thread
 *   - no threshold:3155
 *   - threshold=128:3204
 *   - threshold=512:3000
 *   - threshold=2048:3577
 *   - threshold=8192:6347
 *
 * - 2 threads
 *   - no threshold:7568
 *   - threshold=128:7477
 *   - threshold=512:7564
 *   - threshold=2048:7422
 *   - threshold=8192:7455
 *   
 * - 4 threads
 *   - no threshold:6926
 *   - threshold=128:7135
 *   - threshold=512:5453
 *   - threshold=2048:2202
 *   - threshold=8192:2132
 *   
 * - 8 threads
 *   - no threshold:2191
 *   - threshold=128:2213
 *   - threshold=512:2149
 *   - threshold=2048:2341
 *   - threshold=8192:2225
 *
 *   <insert more if you have more than 2 CPU cores>
 *
 * Parameters of the shortest runtime:
 * - runtime:2132
 * - how many threads:4
 * - threshold value:8192
 * 
 * Best parallel speedup:1.05
 * 
 * Parallelism efficiency:26.25%
*/

public class ParallelMergeSortThreshold extends RecursiveTask<LinkedList<Integer>> {
	LinkedList<Integer> arr;
	int threshold;

	public ParallelMergeSortThreshold(LinkedList<Integer> arr, int threshold) {
		this.arr = arr;
		this.threshold = threshold;
	}

	@Override
	protected LinkedList<Integer> compute() {
		int length = arr.size();

		// Q2: rewrite the base case condition and body of this if statement,
		// so that you run:
		//
		// sequential merge sort for small inputs (the "base case")
		// by using SequentialMergeSort.mergeSort(..) 
		//
		// or run
		//
		// parallel merge sort in parallel for large inputs (the "recursive" case)
		if (length < 2) {
			return SequentialMergeSort.mergeSort(arr);
		}

		else { // parallel case

			/* compute the size of the two sub arrays */
			int halfSize = length / 2;

			/* declare these as `left` and `right` arrays */
			LinkedList<Integer> left = new LinkedList<Integer>();
			LinkedList<Integer> right = new LinkedList<Integer>();

			/* populate the left array with values */
			Iterator<Integer> it = arr.iterator();
			int index = 0;
			while (index < halfSize) {
				left.add(it.next());
				index++;
			}

			/* populate the right array with values */
			index = 0;
			while (index < length - halfSize) {
				right.add(it.next());
				index++;
			}
			
			// TODO replace this to use the parallel fork/join approach but this
			// time using this ParallelMergeSoftThreshold class to create the two tasks,
			// rather than the ParallelMergeSort class that you used in Q1B. Remember
			// that this time you also need to pass the threshold as the 2nd argument
			// to the constructor.
//			LinkedList<Integer> resultLeft = SequentialMergeSort.mergeSort(left);
//			LinkedList<Integer> resultRight = SequentialMergeSort.mergeSort(right);
			
			ParallelMergeSortThreshold sortLeft = new ParallelMergeSortThreshold(left, threshold);
			ParallelMergeSortThreshold sortRight = new ParallelMergeSortThreshold(right, threshold);
			sortLeft.fork();
			LinkedList<Integer> resultRight = sortRight.compute();
			LinkedList<Integer> resultLeft = sortLeft.join();
			
			/* merge the sorted sub arrays */
			return SequentialMergeSort.merge(resultLeft, resultRight);
		}
	}

	/**
	 * Threshold based parallel merge sort
	 * 
	 * @param numbers     the input list
	 * @param threshold   when to switch from parallel divide-and-conquer to
	 *                    sequential divide-and-conquer
	 * @param parallelism how many threads to use in the ForkJoin workpool
	 * @return the sorted list
	 */
	public static LinkedList<Integer> parallelMergeSortThreshold(LinkedList<Integer> numbers, int threshold,
			int parallelism) {
		ForkJoinPool pool = new ForkJoinPool(parallelism);
		ParallelMergeSortThreshold mergeSortTask = new ParallelMergeSortThreshold(numbers, threshold);
		LinkedList<Integer> result = pool.invoke(mergeSortTask);
		return result;
	}

	/**
	 * Benchmarks threshold based parallel merge sort
	 */
	public static void main(String[] args) {
		/* generates a random list */
		LinkedList<Integer> numbers = SortingCommon.randomList(50000);

		/* gets the number of cores in this computer's CPU */
		int cpuCores = Runtime.getRuntime().availableProcessors();

		/*
		 * 1. prints the runtime for the parallel merge sort from Q1B.
		 * 
		 * 2. prints the runtime for the threshold based parallel merge sort for the
		 * implementation in Q2.
		 */
		for (int threads = 1; threads <= cpuCores; threads *= 2) {
			System.out.print("mergeSort\t no threshold\t\t");
			Benchmark.parallel(new ParallelMergeSort(numbers), threads);
			for (int threshold = 128; threshold <= 8192; threshold *= 4) {
				System.out.print("mergeSort\t threshold=" + threshold + "\t\t");
				Benchmark.parallel(new ParallelMergeSortThreshold(numbers, threshold), threads);
			}
		}
	}

}
package quicksort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class QuickSort {

	public void sort(int[] args, int start, int end) {
		if(start < end) {
			int partition = qsort(args, start, end);
			sort(args, start, partition -1);
			sort(args, partition+1, end);
		}
		System.out.println("Quick Sort");
	}

	public int qsort(int[] args, int start, int end) {
		int randomIndex = start + (int)(Math.random() * ((end-start)+ 1));
		swap(args, randomIndex, start);
		
		int pivot = args[start];
		int i = end;
		for (int j = end; j > start; j--) {
			if(args[j] > pivot) {
				swap(args, i, j);
				i--;
			}
		}
		swap(args, i, start);
		return i;
	}
	
	public static void swap(int[] args, int i, int j) {
		int temp = args[i];
		args[i] = args[j];
		args[j] = temp;
	}
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("input.txt"));
			int arrSize = 0;
			if (sc.hasNextInt()) {
				arrSize = sc.nextInt();
			}
			// Initialize the array's
			// size using user input
			int[] arr = new int[arrSize];
			for (int i = 0; i < arrSize; i++) {
				if (sc.hasNextInt()) {
					arr[i] = sc.nextInt();
				}
			}
			sc.close();
			QuickSort ss = new QuickSort();
			ss.sort(arr, 0, arrSize-1);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

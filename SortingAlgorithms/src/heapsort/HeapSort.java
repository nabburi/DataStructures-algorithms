package heapsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeapSort {

	public void sort(int[] args) {
		System.out.println("Heap Sort");
		int argsLength = args.length;
		
		for (int i = argsLength/2 -1; i >= 0; i--) {
			//max heap
			heapify(args, argsLength, i);
		}
		//sort
		for (int i = argsLength -1; i >= 0; i--) {
			int temp = args[0];
			args[0] = args[i];
			args[i] = temp;
			
			heapify(args, i, 0);
		}		
	}

	public void heapify(int[] args, int argsLength, int index) {
		int largest = index;
		int left = 2*index +1;
		int right = 2*index +2;
		
		if(left < argsLength && args[left] > args[largest]) {
			largest = left;
		}
		if(right < argsLength && args[right] > args[largest]) {
			largest = right;
		}
		if(largest != index) {
			int temp = args[index];
			args[index] = args[largest];
			args[largest] = temp;
			heapify(args, argsLength, largest);
		}
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
			HeapSort hs = new HeapSort();
			hs.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

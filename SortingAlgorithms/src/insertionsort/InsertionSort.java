package insertionsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {

	public void sort(int[] args) {
		System.out.println("Inserion Sort");
//		for (int i = 0; i < args.length; i++) {
//			for (int j = i; j >= 0; j--) {
//				if (j == 0) {
//					continue;
//				} else if (args[j-1] > args[j]) {
//					int temp = args[j-1];
//					args[j-1] = args[j];
//					args[j] = temp;
//				}
//			}
//		}
		for (int i = 1; i < args.length; i++) {
			int key = args[i];
			int j = i-1;
			while (j >= 0 && key < args[j]){
				args[j+1] = args[j];
				--j;
			}
			args[j+1] = key;
		}
		
		for (int i : args) {
			System.out.println(i);
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
			InsertionSort ss = new InsertionSort();
			ss.sort(arr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

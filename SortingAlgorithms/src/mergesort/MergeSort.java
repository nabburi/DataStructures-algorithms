package mergesort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {

	public void sort(int[] args, int start, int end, int mid) {
		System.out.println("Merge Sort");

		int s1 = mid - start + 1;
		int s2 = end - mid;

		int L[] = new int[s1];
		int R[] = new int[s2];

		for (int i = 0; i < s1; ++i) {
			L[i] = args[start + i];
		}
		for (int j = 0; j < s2; ++j) {
			R[j] = args[mid + 1 + j];
		}
		int i = 0;
		int j = 0;

		int k = start;
		while (i < s1 && j < s2) {
			if (L[i] <= R[j]) {
				args[k] = L[i];
				i++;
			} else {
				args[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < s1) {
			args[k] = L[i];
			i++;
			k++;
		}
		while (j < s2) {
			args[k] = R[j];
			j++;
			k++;
		}

	}

	public void msort(int[] args, int start, int end) {
		if (start < end) {

			int mid = start + (end - start) / 2;
			msort(args, start, mid);
			msort(args, mid + 1, end);
			
			sort(args, start, end, mid);
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
			MergeSort ss = new MergeSort();
			ss.msort(arr, 0, arrSize - 1);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

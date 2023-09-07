package practiceproblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SegregateEvenAndOddNumbers {

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
			SegregateEvenAndOddNumbers seo = new SegregateEvenAndOddNumbers();
			seo.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
//do with two pointers
	private void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && ((key % 2) == 0)) {
				arr[j+1] = arr[j];
				--j;
			}  
			arr[j+1] = key;
		}
	}

}

package selectionsort.copy3;
import java.util.Scanner;

public class SelectionSort {

	public void sort(int[] args) {
		// TODO Auto-generated method stub
		System.out.println("Selection Sort");
		System.out.println(args);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Take the array size from the user
		System.out.println("Enter the size of the array: ");
		int arrSize = 0;
		if (sc.hasNextInt()) {
			arrSize = sc.nextInt();
		}

		// Initialize the array's
		// size using user input
		int[] arr = new int[arrSize];

		// Take user elements for the array
		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i < arrSize; i++) {
			if (sc.hasNextInt()) {
				arr[i] = sc.nextInt();
			}
		
		}
		sc.close();
		SelectionSort ss = new SelectionSort();
		ss.sort(arr);
	}
}

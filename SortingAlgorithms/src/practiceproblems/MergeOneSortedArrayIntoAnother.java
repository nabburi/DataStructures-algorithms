package practiceproblems;

public class MergeOneSortedArrayIntoAnother {

	public static void main(String[] args) {
		int sarr[] = {1,5};
		int barr[] = {2,3,4,6,0,0};
		//solve it with two ponters and not using aux space
		int i=0;
		int j=0;
		int k = 0;
		int aux[] = new int[barr.length];
		while(i < sarr.length && j < barr.length) {
			if(barr[j] <= sarr[i]) {
				aux[k] = barr[j];
				j++;
			}else {
				aux[k] = sarr[i];
				i++;
			}
			k++;
		}
		while(j < barr.length && barr[j]!= 0) {
			aux[k] = barr[j];
			j++;
			k++;
		}
		
		for (int l = 0; l < aux.length; l++) {
			System.out.println(aux[l]);
		}
 	}
}

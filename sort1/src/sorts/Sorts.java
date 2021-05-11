package sorts;

import java.util.Arrays;

public class Sorts {
	
	public static void bubbleSort(int[] a, int n) {
		if(n <= 1) return;
		
		for(int i = 0; i < n; i++) {
			boolean flag = false;
			for(int j = 0; j < n - i - 1; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = true;				
				}			
			}
			
			if(!flag)break;
		}
	}
	
	public static void insertionSort(int[] a, int n) {
		if(n <= 1) return;
		
		for(int i = 1; i < n; i++) {
			int value = a[i];
			int j = i - 1;
			for(;j >= 0; j--) {
				if(a[j] > value) {
					a[j+1] = a[j];
				}
				else {
					break;
				}
			}
			a[j+1] = value;
		}
	} 
	
	public static void selectionSort(int[] a, int n) {
		if(n <= 1) return;
		
		for(int i = 0; i < n-1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < n; j++) {
				if(a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			
			int tmp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = tmp;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[] {3, 4, 2, 1, 5, 6, 7, 8};
		bubbleSort(array, array.length);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {32, 42, 32, 51, 5, 6, 7, 90};
		insertionSort(array, array.length);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {31, 47, 32, 5321, 50, 6, 17, 90};
		selectionSort(array, array.length);
		System.out.println(Arrays.toString(array));
	}

}

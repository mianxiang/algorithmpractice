package quicksort;

public class quicksort { 
	
	public static void quickSort(int[] array) {
		if(array.length < 2 || array == null) return;
		
		quickSortInternally(array, 0, array.length-1);
	}
	
	private static void quickSortInternally(int[] array, int p, int r) {
		if(p >= r) return;
		
		int q = partition(array, p, r);
		quickSortInternally(array, p, q-1);
		quickSortInternally(array, q+1, r);		
	}
	
	private static int partition(int[] array, int p, int r) {
		int pivot = array[(p+r)/2];
		array[(p+r)/2] = array[r];
		array[r] = pivot; 
		
		int i = p;
		for(int j = p; j < r; j++) {
			if(array[j] < pivot) {
				if(i == j) {
					i++;
				}else {
					int tmp = array[j];
					array[j] = array[i];
					array[i++] = tmp;
				}
			}
		}
		
		int tmp = array[i];
		array[i] = array[r];
		array[r] = tmp;
		
		return i;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {51, 239, 300, 12, 104, 165, 38, 19};
		quickSort(array);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}

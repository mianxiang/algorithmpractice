package findnumber;

public class findnumber {
	
	/******
	 * Find the kth smallest value in array
	 * @param array
	 * @param k
	 * @return
	 */
	public static int findNumber(int[] array, int k) {
		if(array.length < k || k < 0) {
			return -1;
		}
		
		int q = partition(array, 0, array.length-1);
		while(q + 1 != k) {
			if(q + 1 > k) {
				q = partition(array, 0, q- 1);
			}else if(q + 1 < k) {
				q = partition(array, q + 1, array.length);
			}
		}
		
		return array[q];
		
	}
	
	private static int partition(int[] a, int p, int r) {
		int pivot = a[r];
		int i = p;
		for(int j = p; j < r; ++j) {
			if(a[j] < pivot) {
				if(i == j) {
					i++;
				}else {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					++i;		
				}
					
				
			}
		}
		
		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		
		return i;
	}

	public static void main(String[] args) {
		int[] array = new int[] {100, 27, 3, 1092, 14, 15, 18, 98};
		int value = findNumber(array, 4);
		System.out.print("The 4th value is " + value);

	}

}

/**
 * 
 */
package alg;

import java.util.Arrays;

/**
 * @author ak
 *
 */
public class SortLover {
	public static int [] bubbleSort (int [] arr)
	{
		int j = arr.length;
		int counter = 0;
		for (; j > 0; j --)
		{
			int i = 0;
			int swap = 0;
			for (; i < j - 1; i ++)
			{
				counter ++;
				if (arr [i] > arr [i + 1])
				{
					int tmp = arr [i];
					arr [i] = arr [i + 1];
					arr [i + 1] = tmp;
					swap ++;
				}
			}
			if (swap == 0)
			{
				break;
			}
		}
		System.out.printf("counter: %d\n", counter);
		return arr;
	}
	public static int quickSort (int [] arr, int start, int end)
	{
		int counter = 0;
		if (end > start)
		{
			//pick leftmost as pivot
			int p = arr [start];
			//pick a start point other than pivot
			//find valid element in order (defined by comparison)
			//larger than (right to left) or less than (left to right)
			int i = end;
			//next valid element position, default +1 (out of range) to distinguish miss hit
			int pos = end + 1;
			//define 
			for (; i >= start; i --)
			{
				counter ++;
				//this comparison decides order of the iteration
				//NOTE: we're deciding position of the pivot
				//so anything other than it should be moved (include equals)
				if (arr [i] >= p)
				{
					pos --;
					int tmp = arr [pos];
					arr [pos] = arr [i];
					arr [i] = tmp;
				}
			}
			counter += quickSort (arr, start, pos - 1) + quickSort (arr, pos + 1, end);
		}
		return counter;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//{19, 17, 13, 10, 8, 6, 4, 2, 7, 9, 21, 33, 55, 12, 3}
		int [] a1 = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int [] a2 = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int c = quickSort (a1, 0, a1.length - 1);
		System.out.printf (" quick sort cost %d\n", c);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(bubbleSort (a2)));
	}

}

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
				//break;
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
			int p = arr [end];
			int i = 0;
			int hi = end;
			for (; i< end; i ++)
			{
				counter ++;
				if (arr [i] > p)
				{
					int j = hi - 1;
					for (; j > i; j --)
					{
						counter ++;
						if (arr [j] <= p)
						{
							int tmp = arr [i];
							arr [i] = arr [j];
							arr [j] = tmp;
							hi --;
							break;
						}
					}
					if (arr [i] > p)
					{
						arr [end] = arr [i];
						arr [i] = p;
						break;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
			counter += quickSort (arr, start, i - 1) + quickSort (arr, i + 1, end);
		}
		return counter;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] a1 = new int [] {3, 12, 55, 33, 21, 9, 7, 2};
		int [] a2 = new int [] {3, 12, 55, 33, 21, 9, 7, 2};
		int c = quickSort (a1, 0, a1.length - 1);
		System.out.printf (" quick sort cost %d\n", c);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(bubbleSort (a2)));
	}

}

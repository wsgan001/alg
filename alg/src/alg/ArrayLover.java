/**
 * 
 */
package alg;

import java.util.Arrays;

/**
 * @author cvv
 *
 */

public class ArrayLover
{
	private static void printArray (int [] arr)
	{
		System.out.println (Arrays.toString (arr));
	}
	public static int [] countingSort (int [] array, int level)
	{
		int count [] = new int [10];
		for (int a: array)
		{//count occurrence of each key [0-9]
			int key = a / level % 10; 
			count [key] ++;
		}
		int index = 0;
		for (int i = 0; i < 10; i ++)
		{//calculate starting index of output array for each key
			int offset = count [i];//count offset by occurrence of key
			count [i] = index;//reuse count array to save starting index
			index += offset;
		}
		int [] output = new int [array.length];
		for (int a: array)
		{
			int key = a / level % 10;
			output [count [key]] = a;
			count [key] += 1;
		}
		return output;
	}
	public static int [] radixSort (int [] array)
	{
		int max = array [0];
		for (int i = 1; i < array.length; i ++)
		{//find max num
			if (array [i] > max)
				max = array [i];
		}
		int [] res = null;
		for (int i = 1; max / i > 0; i *= 10)
		{//loop to the highest digit of max
			res = countingSort (array, i);
		}
		return res;
	}
	
	/**
	 * <h2>problem</h2>
	 * <p>There are N children standing in a line. Each child is assigned a rating value.
	 *	You are giving candies to these children subjected to the following requirements:
	 *
	 *  Each child must have at least one candy.
	 *  Children with a higher rating get more candies than their neighbors.
	 *
	 *	What is the minimum candies you must give? </p>
	 * <h2>solution</h2>
	 * <p></p>
	 * @param ratings
	 * @return
	 */
	public static int candy (int [] ratings)
	{
		if (ratings == null || ratings.length == 0)
		{
			return 0;
		}
		else if (ratings.length == 1)
		{
			return 1;
		}
		int sum = 0;
		int [] candy = new int [ratings.length];
		for (int i = 0; i < ratings.length; i ++)
		{
			if (candy [i] == 0)
			{//anyone with no candy will have one candy
				candy [i] = 1;
			}
			if (i == ratings.length - 1)
			{//skip last child
				break;
			}
			if (ratings [i] < ratings [i + 1])
			{
				candy [i + 1] = candy [i] + 1;
			}
		}
		for (int i = ratings.length - 1; i >= 0; i --)
		{
			if (i == 0)
			{//skip last child
				break;
			}
			if (ratings [i] < ratings [i - 1])
			{
				if (candy [i - 1] < candy [i] + 1)
				{
					candy [i - 1] = candy [i] + 1;
				}
			}
		}
		for (int i = 0; i < ratings.length; i ++)
		{
			if (candy [i] == 0)
			{
				candy [i] = 1;
			}
			sum += candy [i];
		}
		printArray (candy);
		return sum;
	}
	/**
	 * two sorted array a and b, capacity of a is M and b is 2M, merge a to b keeping b sorted
	 * @param a
	 * @param b
	 * @param M
	 */
	public static int [] mergeArray(int[] a, int m, int[] b, int n)
	{
        int [] big = a;
        final int bigcount = m;
        int [] small = b;
        final int smallcount = n;
        int x = bigcount - 1;//last number in big
        int y = smallcount - 1;//last in small
        int z = bigcount + smallcount - 1;//last in final
    	while (x >= 0 && y >= 0)
    	{
    		if (big [x] > small[y])
    		{
    			big [z] = big [x];
    			x --;
    		}
    		else
    		{
    			big [z] = small [y];
    			y --;
    		}
    		z --;
    	}
    	while (y >= 0)
    	{
    		big [z] = small [y];
    		z --;
    		y --;
    	}
        return big;
	}
	
    public static int[] twoSum (int[] nums, int sum) {
    	int res [] = new int [2];
    	for (int i = 0; i < nums.length; i ++)
    	{
			res [0] = i;
			for (int j = i + 1; j < nums.length; j ++)
			{
				if (nums [i] + nums [j] == sum)
				{
					res [1] = j;
					return res;
				}
				else
				{
					continue;
				}
			}
    	}
    	return res;
    }
    /**
     * return k largest nums in array
     * @param arr
     * @param k
     * @return
     */
    public static int [] findKLargest (int [] arr, int k)
    {
    	int time = 0;//O(n);
    	if (arr == null || arr.length == 0)
    	{
    		return null;
    	}
    	int size = k;
    	int res [] = new int [size];
    	int i = 0;
    	for (; i < k; i ++)
    	{
    		res [i] = arr [i];
    		time ++;
    	}
    	for (; i < arr.length; i ++)
    	{
    		int idx = 0;
    		int min = res [0];
    		for (int j = 0; j < size; j ++)
    		{
    			if (res [j] < min)
    			{
    				min = res [j];
    				idx = j;
    			}
    			time ++;
    		}
    		if (arr [i] > res [idx])
    		{
    			res [idx] = arr [i];
    		}
    	}
    	Logger.log ("O((n-k)*k + k)={}: n={}, k={}", time, arr.length, k);
    	return res;
    }
    
    public static int stockMaximize (int [] price, int n)
    {
    	if (n == 1)
    	{
    		return 0;
    	}
    	int profit = 0;
    	int max = price [-- n];
    	while (n > 0)
    	{
    		n --;
    		if (max >= price [n])
    		{
    			profit += max - price [n];
    		}
    		else
    		{
    			max = price [n];
    		}
    	}
    	return profit;
    }
    
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        //upper bar
        int max = nums [0];
        for (int i = 0; i < nums.length; i ++)
        {
        	//drop old sum if current number > sum
            sum = Math.max (nums [i], sum + nums [i]);
            //raise max if sum > max
            max = Math.max (sum, max);
        }
        return max;
    }

    /**
     * <h2>merge sort</h2>
     * <p>buffer array is a must</p>
     * @param from
     * @param start
     * @param end
     * @param to
     */
	public static int sort(int from[], int start, int end, int to[]) {
		int time = 0;
		if (end - start > 1)
		{//no need to sort single element
			// split the run longer than 1 item into halves
			int mid = (start + end) / 2;
			// alternately sort data between original and target array
			sort(to, start, mid, from);
			sort(to, mid, end, from);
			// merge the resulting runs from array B[] into A[]
			time += merge(from, start, mid, end, to);
		}
		return time;
	}

	private static int merge(int from[], int start, int mid, int end, int to[]) {
		int time = 0;
		int i = start, j = mid;
		// While there are elements in the left or right runs...
		for (int k = start; k < end; k++) {
			// If left run head exists and is <= existing right run head.
			if (i < mid && (j >= end || from[i] <= from[j])) {
				to[k] = from[i];
				i = i + 1;
			} else {
				to[k] = from[j];
				j = j + 1;
			}
			time ++;
		}
		return time;
	}
	
	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		/*int a [] = new int [] {1,6, 7, 9, 11, 22, 33, 0, 0, 0, 0, 0};
		int b [] = new int [] {1, 2, 3, 4, 19};
		printArray(mergeArray (a, 7, b, b.length));
		int i [] = new int [] {1, 3, 2, 4, 11, 7, 15};
		printArray (twoSum (i, 9));*/
		//System.out.println (candy (new int [] {4,2,3,4,1}));
		//System.out.println((long)Character.MAX_VALUE);
		//int arr [] = new int [] {1, 23, 12, 9, 30, 2, 50};
		//Logger.log (findKLargest (arr, 3));
		//Logger.log (arr);
		
		//Logger.log("good: {}", stockMaximize (new int [] {1,3,1,2}, 4));
		//Logger.log ("{}", maxSubArray (new int [] {1,2}));
		int [] arr = new int [] {10, 7, 1, 9, 2, 11, 5, 3, 8};//
		int [] result = Arrays.copyOf(arr, arr.length);
		Logger.log("O(NlogN): {}, N={}", sort (result, 0, arr.length, arr), arr.length);
		Logger.log (arr);
	}

}

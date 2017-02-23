/**
 * 
 */
package alg;

/**
 * @author ak
 *
 */
public class SearchLover {
	/**
	 * binary search assume that input array was sorted
	 * @param arr
	 * @param x
	 * @return
	 */
	public int binarySearch (int [] arr, int x)
	{
		int time = 0;//O(n)
		//start index
		int start = 0;
		//end index
		int end = arr.length - 1;
		//result index
		int result = -1;
		while (start <= end)
		{
			time ++;
			//always search between start and end
			int i = (start + end) / 2;
			if (x == arr [i])
			{
				result = i;
				break;
			}
			else if (x > arr [i])
			{
				start = i + 1;
			}
			else if (x < arr [i])
			{
				end = i - 1;
			}
		}
		Logger.log("result: {}, O(log n)={}: n={}", result, time, arr.length);
		return result;
	}
	public static void saveHumanity (String str, String key)
	{
		
	}
	public static void main (String args [])
	{
		SearchLover sl = new SearchLover ();
		sl.binarySearch(new int [] {1,4,7,9,18,19,35,39,42,47,49,58,59,77,79,85,88,89,93}, 89);
	}
}

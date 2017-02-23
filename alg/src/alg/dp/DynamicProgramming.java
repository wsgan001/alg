/**
 * 
 */
package alg.dp;

import alg.Logger;

/**
 * @author cvv
 *
 */
public class DynamicProgramming
{
	public static int [] [] longestCommonSequence (char [] a, char [] b)
	{
		int [] [] matrix = new int [a.length + 1] [b.length + 1];
		for (int i = 0; i < a.length; i ++)
		{
			for (int j = 0; j < b.length; j ++)
			{
				if (a [i] == b [j])
				{
					matrix [i+1] [j+1] = matrix [i] [j] + 1;
				}
				else
				{
					matrix [i+1] [j+1] = Math.max (
						matrix [i] [j+1], matrix [i+1][j]);
				}
			}
		}
		return matrix;
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
	 * @param args
	 */
	public static void main (String [] args)
	{
		Logger.log (longestCommonSequence(
			"abcdaf".toCharArray (), "acbcf".toCharArray ()));
		Logger.log(maxSubArray(new int [] {1, -1, -2, -9, 8, 3, -1, 2, 5}));
	}

}

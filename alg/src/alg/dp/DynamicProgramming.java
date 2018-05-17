/**
 * 
 */
package alg.dp;

import java.util.Arrays;

import alg.Logger;

/**
 * @author cvv
 *
 */
public class DynamicProgramming
{
	/**
	 * use least coins to add up to sum
	 * @param sum
	 * @return
	 */
	public static int leastCoin (int sum, int [] coins)
	{
		Arrays.sort(coins);
		int n = coins.length - 1;
		int total = 0;
		int count = 0;
		int cost = 0;
		while (n >= 0 && (total + coins [n]) != sum)
		{
			if (total + coins [n] > sum)
			{
				cost ++;
				n --;
			}
			else if (total + coins [n] <= sum)
			{
				cost ++;
				total += coins [n];
			}
			count ++;
		}
		System.out.printf("sum %d, count %d, cost %d", sum, count, cost);
		return count;
	}
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
	
	public static int longestPalindrome(String s) {
		int n = s.length();
		boolean[][] pal = new boolean[n][n];
		// pal[i][j] 表示s[i...j]是否是回文串
		int maxLen = 0;
		int time = 0;
		for (int i = 0; i < n; i++) {
			int j = i;
			while (j >= 0) {
				if (s.charAt(j) == s.charAt(i) && (i - j < 2 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					maxLen = Math.max(maxLen, i - j + 1);
				}
				j--;
				time ++;
			}
		}
		Logger.log("time: {}", time);
		return maxLen;
	}


	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		Logger.log (longestCommonSequence(
			"abcdaf".toCharArray (), "acbcf".toCharArray ()));
		Logger.log(maxSubArray(new int [] {1, -1, -2, -9, 8, 3, -1, 2, 5}));
		Logger.log(longestPalindrome ("abcdcdbadbabdab"));
		Logger.log(leastCoin (50, new int [] {1, 2, 5, 10, 50}));
	}
}

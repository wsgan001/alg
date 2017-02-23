/**
 * 
 */
package alg;

/**
 * @author cvv
 *
 */
public class SequenceLover
{
	//arithmetic sequence
	public static boolean isArithmetic (int [] array)
	{
		int diff = array [1] - array [0];
		for (int i = 1; i < array.length; i ++)
		{
			if (diff != (array [i] - array [i - 1]))
			{
				return false;
			}
		}
		return true;
	}
	//geometric sequence
	public static boolean isGeometric (int [] array)
	{
		int diff = array [1] / array [0];
		for (int i = 1; i < array.length; i ++)
		{
			if (diff != (array [i] / array [i - 1]))
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		Logger.log ("{}", isArithmetic (new int [] {1, 3, 53}));
		Logger.log ("{}", isGeometric (new int [] {0, 0, 49}));
	}

}

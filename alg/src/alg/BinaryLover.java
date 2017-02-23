/**
 * 
 */
package alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ak
 *
 */
public class BinaryLover {
	/**
	 * The gray code is a binary numeral system where two successive values differ in only one bit.
	 * Given a non-negative integer n representing the total number of bits in the code, print the sequence
	 * of gray code. A gray code sequence must begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 		00 - 0
	 * 		01 - 1
	 * 		11 - 3
	 * 		10 - 2
	 * 
	 * Note:
	 * For a given n, a gray code sequence is not uniquely defined.
	 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	 * 
	 * Tip:
	 * after studying the pattern of result sequence for ordered N, you can find out that:
	 * N = 1			N = 2			N = 3
	 * 0 0 - 0			0 0 - 0			0 00 - 0
	 * 0 1 - 1			0 1 - 1			0 01 - 1
	 * 					1 1 - 3			0 11 - 3
	 * 					1 0 - 2			0 10 - 2
	 * 									1 10 - 6
	 * 									1 11 - 7
	 * 									1 01 - 5
	 * 									1 00 - 4
	 * the lower bits without first bit could be ordered as mirrored by half
	 * @param n bits length
	 * @return
	 */
	public static List <Integer> greyCode (int n)
	{
		List <Integer> list = new ArrayList <> ();
		list.add(0);
		if (n == 0)
		{
			return list;
		}
		else
		{
			list.add(1);
			int size = 2;
			int mask = 1;
			while (-- n > 0)
			{
				mask = mask << 1;
				int i = size;
				size = size * 2;
				for (; i < size; i ++)
				{
					list.add(mask | list.get(size - i - 1));
				}
			}
			return list;
		}
	}
    public static boolean validateNextGreyCode (byte code, byte next) {
    	//use XOR to find different bits
        int diff = (int) (code ^ next);
        int count = 0;
        while (diff > 0 && count <= 1)
        {//iterate through different bits
        	if (diff >> 1 != diff / 10)
        	{
        		count ++;
        	}
        	diff = diff >> 1;
        }
        return count == 1;
    }
	public static void main (String [] args)
	{
		Logger.log(greyCode (3));
		byte a = 7;
		byte b = 100;
		Logger.log("result: {}", validateNextGreyCode (a, b));
	}
}

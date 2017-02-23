/**
 * 
 */
package alg;

/**
 * @author cvv
 *
 */
public class AlterSequence
{
	/*
	 * from	L1->L2->L3->R1->R2->R3
	 * to	L1->R1->L2->R2->L3->R3
	 */
	public static void alter (String [] array)
	{
		// 0 1 2 3 4 5 6
		// 0 3 1 4 2 5 6
		String tail = null;
		if (array.length % 2 > 0)
		{
			tail = array [array.length - 1];
		}
		int half = array.length / 2;
		for (int i = 0; i < half; i ++)
		{
			System.out.println (array [i]);
			System.out.println (array [i + half]);
		}
		if (tail != null)
		{
			System.out.println (tail);
		}
	}
	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		String input = "L1 L2 L3 R1 R2 R3 R4";
		alter (input.split (" "));
	}

}

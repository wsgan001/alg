/**
 * 
 */
package alg;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author ak
 *
 */
public class Logger {

	public static void log (String msg, Object ... args)
	{
		StringBuilder sb = new StringBuilder (msg.length());
		int idx = 0;
		int i = 0;
		int start = 0;
		while ((idx = msg.indexOf("{}", idx)) >= 0 && i < args.length)
		{
			sb.append(msg, start, idx);
			sb.append(args [i++].toString());
			start = idx + 2;
			idx ++;
		}
		if (start < msg.length())
		{
			sb.append(msg, start, msg.length());
		}
		System.out.println(sb);
	}
	public static void log (Object o)
	{
		if (o instanceof int [])
		{
			System.out.println(Arrays.toString((int [])o));
		}
		else if (o instanceof int [] [])
		{
			int [] [] m = (int [] []) o;
			for (int [] arr: m)
			{
				System.out.println(Arrays.toString(arr));
			}
		}
		else if (o instanceof Collection)
		{
			System.out.println ((Collection <?>) o);
		}
		else
		{
			System.out.println(o);
		}
	}
	public static void main (String args [])
	{
		log (new int []{1,2,34,234,5});
	}
}

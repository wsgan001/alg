/**
 * 
 */
package alg;

import java.util.Stack;

/**
 * @author cvv
 *
 */
public class BalancedBrackets
{
	private static char getPair (char bracket)
	{
		char pair = 0;
		switch (bracket)
		{
		case ']':
			pair = '[';
			break;
		case ')':
			pair = '(';
			break;
		default:
		}
		return pair;
	}
	public static boolean isBalanced (String input)
	{
		//use stack to ease the comparison of matched brackets pair
		Stack <Character> stack = new Stack <Character> ();
		for (int i = 0; i < input.length (); i ++)
		{
			char c = input.charAt (i);
			switch (c)
			{
			case '[':
			case '(':
				//if start of pair, push stack
				stack.add (c);
				break;
			case ']':
			case ')':
				if (stack.size () > 0 && stack.peek ().equals (getPair(c)))
				{//if end of pair, peek stack to find match, if match then pop
					stack.pop ();
				}
				else
				{//if not match, not balanced
					return false;
				}
				break;
			default:
				break;
			}
		}
		return stack.size () == 0;
	}
	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		String line = "[{[]()}]";
		System.out.println (isBalanced(line));
	}

}

/**
 * 
 */
package alg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ak
 *
 */
public class LinkedListLover {
	/**
	 * 1,2,3,4,5,6 -> 1,2,3,6,5,4
	 * @param ll
	 */
	public static void reverseSecondHalf (LinkedList <Integer> ll)
	{
		List <Integer> second = ll.subList(ll.size() / 2, ll.size());
		Collections.reverse(second);
		System.out.println(ll);
	}
	public static void reverseSecondHalf2 (LinkedList <Integer> ll)
	{
		LinkedList<Integer> first = new LinkedList <Integer> (ll.subList(0, ll.size() / 2));
		List <Integer> second = new LinkedList <Integer> (ll.subList(ll.size() / 2, ll.size()));
		System.out.println(first);
		for (int i = 0; i < second.size(); i ++)
		{
			second.get(i);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer> ();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		reverseSecondHalf2 (ll);
	}

}

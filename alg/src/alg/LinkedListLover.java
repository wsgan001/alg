/**
 * 
 */
package alg;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	 * O(M*N)
	 * @param l1
	 * @param l2
	 */
	public static String checkMerge1 (LinkNode <Integer> l1, LinkNode <Integer> l2)
	{
		int counter = 0;
		LinkNode<Integer> c1 = l1;
		while (c1 != null)
		{
			LinkNode<Integer> c2 = l2;
			while (c2 != null)
			{
				counter ++;
				if (c1 == c2)
				{
					System.out.println("count: " + counter);
					return "merge at " + c1.getVal().toString();
				}
				c2 = c2.next;
			}
			c1 = c1.next;
		}
		return null;
	}
	/**
	 * O(M+N) 
	 */
	public static String checkMerge2 (LinkNode <Integer> l1, LinkNode <Integer> l2)
	{
		int counter = 0;
		Map <LinkNode <Integer>, LinkNode <Integer>> map = new IdentityHashMap<>();
		LinkNode<Integer> c1 = l1;
		while (c1 != null)
		{
			counter ++;
			if (map.put(c1, c1) != null)
			{
				System.out.println("count: " + counter);
				return "merge at " + c1.getVal().toString();
			}
			c1 = c1.next;
		}

		LinkNode<Integer> c2 = l2;
		while (c2 != null)
		{
			counter ++;
			if (map.put(c2, c2) != null)
			{
				System.out.println("count: " + counter);
				return "merge at " + c2.getVal().toString();
			}
			c2 = c2.next;
		}
		return null;
	}
	public static void print (LinkNode <Integer> ln) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            sb.append(ln.getVal());
            if (ln.next == null)
            {
            	sb.append(']');
            	System.out.println(sb);
                return;
            }
            ln = ln.next;
            sb.append(',').append(' ');
        }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkNode <Integer> h1 = new LinkNode <> (7);
		LinkNode <Integer> h2 = new LinkNode <> (2);
		LinkNode<Integer> t1 = h1.add(new LinkNode <> (5));
		t1 = t1.add(new LinkNode <> (3));
		LinkNode<Integer> t2 = h2.add(new LinkNode <> (4));
		LinkNode <Integer> cross = new LinkNode <> (8);
		t1.add(cross);
		t2 = t2.add(cross);
		t2 = t2.add(new LinkNode <> (6));
		t2.add(new LinkNode <> (1));
		print(h1);
		print(h2);
		System.out.println(checkMerge1 (h1, h2));
		System.out.println(checkMerge2 (h1, h2));
	}

}

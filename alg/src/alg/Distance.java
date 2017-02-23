package alg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Distance
{
	class Point implements Comparable <Point> {
		int x;
		int y;
		@Override
		public String toString ()
		{
			return "(" + x + "," + y + ")";
		}
		@Override
		public int compareTo (Point o)
		{
			int odis = 0;
			if (o == null) {odis = 0;}
			else {odis = o.x * o.x + o.y * o.y;}
			return (this.x * this.x + this.y * this.y) - odis; 
		}
		
	}
	
	public static Point [] nearestK (List<Point> points, int k)
	{
		if (points == null || points.size() == 0 || k <= 0)
		{
			return null;
		}
		int i = points.size() < k? points.size(): k;
		SortedSet <Point> set = new TreeSet <Point> ();
		for (Point p: points)
		{
			set.add (p);
		}
		Point to = null;
		Iterator <Point> it = set.iterator ();
		for (int j = 0; j < i; j ++)
		{
			to = it.next ();
		}
		if (it.hasNext ()) to = it.next ();
		return set.headSet (to).toArray (new Point []{});
	}
	
	public static void main (String [] args)
	{
		Distance d = new Distance ();
		List <Point> points = new ArrayList<> ();
		for (int i = 0; i< 10; i ++)
		{
			Point p = d.new Point ();
			p.x = (int) (Math.random () * 1000);
			p.y = (int) (Math.random () * 1000);
			points.add (p);
		}
		System.out.println (points);
		Point [] array = Distance.nearestK (points, 1);
		if (array != null)
		{
			for (Point p: array)
			{
				System.out.println (p);
			}
		}
	}

}

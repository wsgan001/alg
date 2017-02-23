/**
 * 
 */
package alg.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import alg.Logger;

/**
 * @author cvv
 *
 */
class Vertex
{
	String name;
	List <Connection> edges = new ArrayList <Connection> ();
	Vertex (String name) {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
class Connection
{
	String node1;
	String node2;
	int cost;
	public Connection (String a, String b, int c)
	{
		node1 = a;
		node2 = b;
		cost = c;
	}
	@Override
	public String toString() {
		return "Connection [node1=" + node1 + ", node2=" + node2 + ", cost=" + cost + "]";
	}
}

public class CityConnection
{
	private static TreeSet<Connection> newSet ()
	{
		TreeSet<Connection> ts = new TreeSet <Connection> (new Comparator<Connection>() {
			@Override
			public int compare(Connection o1, Connection o2) {
				int c1 = o1 != null? o1.cost: 0;
				int c2 = o2 != null? o2.cost: 0;
				return c1 - c2;
			}
		});
		return ts;
	}
	private static boolean hasEdge (Map <String, TreeSet <Connection>> map, String node)
	{
		return map.containsKey(node);
	}
	public static Map <String, TreeSet <Connection>> getVertices (List<Connection> connections)
	{
		//Map <node name, edges>
		Map <String, TreeSet <Connection>> vertices = new HashMap <String, TreeSet <Connection>> ();
		for (Connection con: connections)
		{
			if (!hasEdge (vertices, con.node1))
			{
				vertices.put (con.node1, newSet ());
			}
			if (!hasEdge (vertices, con.node2))
			{
				vertices.put (con.node2, newSet ());
			}
			vertices.get(con.node1).add(con);
			vertices.get(con.node2).add(con);
		}
		return vertices;
	}
	public static void grow (Set <Connection> connections,
		Map <String, TreeSet <Connection>> vertices)
	{
		Connection min = null;
		for (Connection c: connections)
		{
			Connection c1 = vertices.get (c.node1).first ();
			Connection c2 = vertices.get (c.node2).first ();
			if (connections.contains (c1) || connections.contains (c2))
			{
				continue;
			}
			if (min == null || min.cost > c1.cost)
			{
				min = c1;
			}
			if (min.cost > c2.cost)
			{
				min = c2;
			}
		}
		connections.add (min);
	}
	public static Set <Connection> minWeightEdges (List<Connection> connections)
	{
		//Map <node name, edges>
		Map <String, TreeSet <Connection>> vertices = getVertices (connections);
		List <Set <Connection>> forest = new ArrayList <Set<Connection>> ();
		int i = vertices.size ();
		for (TreeSet <Connection> v: vertices.values ())
		{
			Set <Connection> set = new HashSet <Connection> ();
			set.add (v.first ());
			grow (set, vertices);
			forest.add (set);
		}
		while (--i > 0)
		{
			for (Set <Connection> set: forest)
			{
				grow (set, vertices);
			}
		}
		for (Set <Connection> set: forest)
		{
			if (set.size () == vertices.size () - 1)
			{
				return set;
			}
		}
		return null;
	}
	/**
	 * MST
	 * @param connections
	 * @return
	 */
	public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
		return null;
	}
	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		Connection c1 = new Connection ("a", "b", 3);
		Connection c2 = new Connection ("a", "c", 7);
		Connection c3 = new Connection ("b", "c", 5);
		Connection c4 = new Connection ("a", "x", 3);
		Connection c5 = new Connection ("a", "z", 7);
		Connection c6 = new Connection ("x", "z", 9);
		List <Connection> list = new ArrayList <Connection> ();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		list.add(c6);
		Logger.log(minWeightEdges (list));
	}

}

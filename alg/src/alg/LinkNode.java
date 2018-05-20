package alg;

public class LinkNode <E> {
	private E value;
	LinkNode <E> next;
	public LinkNode (E val)
	{
		value = val;
	}
	public LinkNode <E> add (LinkNode <E> node)
	{
		this.next = node;
		return this.next;
	}
	public E getVal () {return value;}
}

/**
 * 
 */
package alg;

/**
 * @author cvv
 *
 */
class Node {
	public Node(int i) {
		value = i;
	}
	int value;
	Node left;
	Node right;
	public void traverseInOrder (Node root)
	{
		if (root.left != null) traverseInOrder (root.left);
		Logger.log(root);
		if (root.right != null) traverseInOrder (root.right);
	}

	public void traversePreOrder (Node root)
	{
		Logger.log(root);
		if (root.left != null) traversePreOrder (root.left);
		if (root.right != null) traversePreOrder (root.right);
	}

	public void traversePostOrder (Node root)
	{
		if (root.left != null) traversePostOrder (root.left);
		if (root.right != null) traversePostOrder (root.right);
		Logger.log(root);
	}
	/**
	 * make the binary tree threaded while traversing
	 * @param root
	 */
	public void traverseMorrisInOrder (Node root)
	{
		Node cur = root;
		while (cur != null)
		{
			if (cur.left == null)
			{//no left subtree
				Logger.log(cur);
				cur = cur.right;
			}
			else
			{//find the predecessor of current node (rightmost leaf of left subtree)
				Node p = cur.left;
				//if the right child of predecessor node pointed to current node, it's been traversed
				while (p.right != null && p.right != cur)
				{//stop at leaf or thread
					p = p.right;
				}
				if (p.right == null)
				{//real leaf, create exit thread to current node before traverse
					p.right = cur;
					cur = cur.left;
				}
				else
				{//exit thread, done traversing left subtree, clean thread
					p.right = null;
					Logger.log(cur);
					cur = cur.right;
				}
			}
		}
	}
	public void traverseMorrisPreOrder (Node root)
	{
		Node cur = root;
		while (cur != null)
		{
			if (cur.left == null)
			{//no left subtree
				Logger.log(cur);
				cur = cur.right;
			}
			else
			{//find the predecessor of current node (rightmost leaf of left subtree)
				Node p = cur.left;
				//if the right child of predecessor node pointed to current node, it's been traversed
				while (p.right != null && p.right != cur)
				{//stop at leaf or thread
					p = p.right;
				}
				if (p.right == null)
				{//real leaf, create exit thread to current node before traverse
					p.right = cur;
					cur = cur.left;
				}
				else
				{//exit thread, done traversing left subtree, clean thread
					p.right = null;
					Logger.log(cur);
					cur = cur.right;
				}
			}
		}
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
}
public class Tree
{
	/**
	 * 					10
	 * 				 /	     \
	 * 			   3		  18
	 *      	/	\		/    \
	 *    	  2		 4	   13      21
	 *    			  \
	 *    				9
	 *    			 /	  \
	 *    		   8	   9
	 * @param args
	 */
	public static void main (String [] args)
	{
		Node root = new Node (10);
		Node n1 = new Node (3);
		Node n2 = new Node (18);
		root.left = n1;
		root.right = n2;
		Node n3 = new Node (2);
		Node n4 = new Node (4);
		n1.left = n3;
		n1.right = n4;
		Node n5 = new Node (9);
		n4.right = n5;
		Node n6 = new Node (8);
		Node n7 = new Node (9);
		n5.left = n6;
		n5.right = n7;
		Node n8 = new Node (13);
		Node n9 = new Node (21);
		n2.left = n8;
		n2.right = n9;

		Logger.log("pre-order");
		root.traversePreOrder(root);
		/*Logger.log("in-order");
		root.traverseInOrder(root);
		Logger.log("post-order");
		root.traversePostOrder(root);*/
		Logger.log("morris");
		root.traverseMorrisInOrder(root);
	}

}

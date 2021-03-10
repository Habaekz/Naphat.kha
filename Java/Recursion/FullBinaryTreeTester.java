import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class FullBinaryTreeTester {
	static boolean topmost = true;
	static List<Node> nodeList;
	public static void inOrderTraverse(Node root)
	{
		if(root != null) {
			inOrderTraverse(root.left);
			System.out.print(root.id + " ");
			inOrderTraverse(root.right);
		}
	}
	
	public static boolean isFullBinTree(Node root)
	{	//YOUR CODE GOES HERE
		//Check root = null --> is leaf --> is origin of leaf --> is origin of origin of leaf then travel left and right
		if(root == null) return true;
		else if(root.left == null && root.right == null) return true;
		else if(root.left == null || root.right == null) return false;
		else {
			boolean dive_Left = isFullBinTree(root.left);
			boolean dive_Right = isFullBinTree(root.right);
			return (dive_Left && dive_Right);
		}
	}
	
	public static void normalTester()
	{
		Node[] ts = new Node[7];
		int count = 0;
		ts[count++] = null;
		ts[count++] = new Node(16, null, null);
		
		ts[count++] = new Node(16, new Node(14, null, null), null);
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, null, null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				null);
		
		for(int i = 0; i < ts.length; i++)
		{
			System.out.print("[T"+i+"] in-order: ");
			inOrderTraverse(ts[i]);
			System.out.println("\n[T"+i+"] is"+(isFullBinTree(ts[i])?" ":" NOT ")+"a full binary tree.\n");
		}
		
	}
	
	
	/**************BONUS STARTS***************/
	public static void printBinTree(Node root)
	{	//YOUR BONUS CODE GOES HERE
		
		if(root!= null) {
			if(root.left != null && root.right != null) {
				System.out.println("  " + root.id);
				if(root.left!=null) System.out.print(" /");
				if(root.right!=null) System.out.print(" \\");
				System.out.println();
				if(root.left!=null) System.out.print(root.left.id);
				else System.out.print(" ");
				System.out.print("   ");
				if(root.right!=null) System.out.print(root.right.id);
				else System.out.print(" ");
				System.out.println("\n");
				printBinTree(root.left);
				printBinTree(root.right);
			}
			
		}
		
		
		
		
	}
	
	public static void getNodeQueue(Node root){
		
		if(topmost) {
			nodeList.add(root);
		}
		topmost = false;
		if(root.left != null) {
			nodeList.add(root.left);
		}
		if(root.right != null) {
			nodeList.add(root.right);
		}
		if(root.left != null) getNodeQueue(root.left);
		if(root.right != null) getNodeQueue(root.right);
	}
		
	public static Node getBinSearchTree(List<Node> a)
	{	//YOUR BONUS CODE GOES HERE

		if(a!= null || a.isEmpty()) {
			if(a.size() > 3) {
				List<Node> lower = new ArrayList<Node>();
				List<Node> upper = new ArrayList<Node>();
				int key = a.size()/2;
				for(int i=0;i<a.size();i++) {
					if(i==key) continue;
					else if(a.get(i).id<a.get(key).id) lower.add(a.get(i));
					else if(a.get(i).id>a.get(key).id) upper.add(a.get(i));
				}
				return new Node(a.get(key).id,getBinSearchTree(lower),getBinSearchTree(upper));
			}
			else {
				if(a.size() == 3) return new Node(a.get(1).id,new Node (a.get(0).id,null,null),new Node (a.get(2).id,null,null));
				else if (a.size() == 2) return new Node(a.get(1).id,new Node (a.get(0).id,null,null),null);
				else return new Node(a.get(0).id,null,null);
			}
		}
		return null;
		
		
	}

	public static void bonusTester()
	{
		Node t = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		System.out.println("Before Transforming: ");
		printBinTree(t);
		System.out.println("After Transforming: ");
		nodeList = new LinkedList<Node>();
		getNodeQueue(t);
		printBinTree(getBinSearchTree(nodeList));
		
	}
	
	//find tree level
	public static int treelevel(Node root, int level) {
		if(root == null) return level;
		else {
			int left = 0,right = 0;
			if(root.left == null && root.right == null) return level;
			if(root.left != null) {
				left =  treelevel(root.left, level+1);
			}
			if(root.right != null) { 
				right = treelevel(root.right, level+1);
			}
			return Math.max(left, right);
		}
	}
	
	
	
	/**************BONUS ENDS***************/
		
	public static void main(String[] args)
	{
		normalTester();
		
		//Uncomment for bonus
		bonusTester();
	}
	
	public static void wait(int duration) {
		try {
			for(int i=0;i<duration;i++) {
				TimeUnit.SECONDS.sleep(1);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class NodeComp implements Comparator<Node>{
	public int compare(Node a,Node b) {
		return a.id-b.id;
	}
}

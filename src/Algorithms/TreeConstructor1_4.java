/**
 * 
 */
package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zolfa
 *
 */
public class TreeConstructor1_4 {

	/**
	 * @param args
	 */
	public static boolean constructTree(String[] strArr) {
		
		List<Pair> pairs = new ArrayList<Pair>();

		for (String p: strArr) {
			String[] pairString = p.substring(1, p.length()-1).split(",");   
			int child = Integer.parseInt(pairString[0]);
			int parent = Integer.parseInt(pairString[1]);
			pairs.add(new Pair(child, parent));
			
		}
		for (int i=0; i<pairs.size(); i++) {
			int countChild = 0, countIntiger = 0;
			for (int j=0; j<pairs.size(); j++) {
				if ( pairs.get(i).getParent() ==  pairs.get(j).getParent())
					countChild++;              // count the number of children
				if ( pairs.get(i).getChild() ==  pairs.get(j).getChild())
					countIntiger++;           // count the number of node in the tree with the given integer
			}
			if (countChild > 2 || countIntiger > 1)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input1 = {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
		System.out.println(constructTree(input1));
		String[] input2 = {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
		System.out.println(constructTree(input2));
	}
	public static class Pair {
		private int child;
		private int parent;
		
		public Pair(int child, int parent) {
			this.child = child;
			this.parent = parent;
		}
		public int getChild() {
			return this.child;
		}
		public void setChild(int child) {
			this.child = child;
		}
		public int getParent() {
			return this.parent;
		}
		public void setParent(int parent) {
			this.parent = parent;
		}
		
	}
}


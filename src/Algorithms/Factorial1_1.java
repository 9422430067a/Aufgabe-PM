/**
 * 
 */
package Algorithms;

/**
 * @author zolfa
 *
 */
public class Factorial1_1 {

	/**
	 * @param args
	 */
	public static long recursiveFactorial(int n) {
		if ( n == 0)
			return 1;
		else
			return n * recursiveFactorial(n - 1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long factorial = recursiveFactorial(18);
		System.out.println(factorial);

	}

}

/**
 * 
 */
package Algorithms;

/**
 * @author zolfa
 *
 */
public class PrimeNumbers1_3 {

	/**
	 * @param args
	 */
	
	public static String getPrimeNumbersTo(int number) {
		String primeNumbers = "";
		for (int i=2 ; i <= number ; i++) 
			if ( isPrimeNumber(i) ) 
				primeNumbers += i +", ";
		return primeNumbers;
	}
	
	public static boolean isPrimeNumber(int number) {
		if ( number <= 1)
			return false;
		else if ( number == 2)
			return true;
		else {
			int flag = 1;
			for ( int i=2 ; i<=number ; i++) 
				if ( number % i == 0 )
					flag++;
			if ( flag >2 )
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("input : 6 , is prime : " + isPrimeNumber(6));
		System.out.println("input : 23 , is prime : " + isPrimeNumber(23));
		
		System.out.println("input : 6 , output : " + getPrimeNumbersTo(6));
		System.out.println("input : 17 , output : " + getPrimeNumbersTo(17));
		System.out.println("input : 25 , output : " + getPrimeNumbersTo(25));
	}

}

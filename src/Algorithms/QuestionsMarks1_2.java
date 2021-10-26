/**
 * 
 */
package Algorithms;

/**
 * @author zolfa
 *
 */
public class QuestionsMarks1_2 {

	/**
	 * @param args
	 */
	public static boolean questionsMarks(String str) {
		char[] input = str.toCharArray();
		int i = 0;
		int digit1 = 0, digit2 = 0, index1 = 0, index2 = 0, flag = 0;
		while (i < input.length) {
			if (Character.isDigit(input[i])) {
				digit1 = Character.getNumericValue(input[i]);
				index1 = i;
				int j = i+1;
				while (j < input.length) {
					if( Character.isDigit(input[j]) ) {
						digit2 = Character.getNumericValue(input[j]);
						index2 = j;
						if ( index2-index1 < 4 )
							i = j;
						else if( digit1 + digit2 == 10 ) {
							int counter = 0;
							for( int x= index1 ; x<=index2 ; x++) {
								if( input[x] == '?')
									counter++;
							}
							if ( counter <=3 )
								flag = 1;
							else if( counter > 3) 
								return false;
							else if( j == input.length-1)
								return true;
						}
						i = j;
						break;
					}
					j++;
				}       // end while (j < input.length)
			}
			i++;
		}              // end while (i < input.length)
		if (flag ==1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(questionsMarks("aa6?9"));                    // false
		System.out.println(questionsMarks("aa6?4??hgfrty6"));           // false 
		System.out.println(questionsMarks("acc?7??sss?3rr1??????5"));   // true
		System.out.println(questionsMarks("acc?7??sss?4rr1??????5"));   // false  
		System.out.println(questionsMarks("arrb6???4xxbl5???eee5"));    // true
		System.out.println(questionsMarks("arrb6???4xxbl5????ee5"));    // false
	}

}

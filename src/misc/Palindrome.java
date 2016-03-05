package misc;

public class Palindrome {

	public static boolean isPalindrome(String s) {
		if (s == null || s.equals(""))
			return false;

		int lastIndex = s.length()-1;
		
		for(int i=0; i <=lastIndex/2;i++)
		{
			if(s.charAt(i) != s.charAt(lastIndex-i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(isPalindrome("AD"));
		System.out.println(isPalindrome("ABCCBA"));
	}

}

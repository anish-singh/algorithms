package misc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static List<String> getPermutations(String str)
	{
		if(isEmpty(str)) return null;
		
		List<String> perms = new ArrayList<String>();
		
		perms.add(str.substring(0,1));
		
		for(int i=1;i<str.length();i++)
		{
			char c = str.charAt(i);
			List<String> newPerms = new ArrayList<String>();

			for(String s: perms)
			{
				for(int j=0; j<= s.length();j++)
				{
					newPerms.add(addChar(s,j,c));
				}
			}
			perms = newPerms;
		}
		return perms;
	}

	private static String addChar(String s, int pos, char c) {
	
		if(pos == 0) return c + s;
		if(pos == s.length()) return s+c;
		
		String s1 = s.substring(0,pos);
		String s2 = s.substring(pos, s.length());
		
		return s1 + c + s2;
	}

	private static boolean isEmpty(String str) {
		return (str == null || str.length() == 0) ? true : false;
	}
	
	public static void main(String[] args) {
		
		List<String> ps = getPermutations("ABC");
		System.out.println(ps);
	}

}

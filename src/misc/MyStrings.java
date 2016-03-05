package misc;

public class MyStrings {
	
    public static String fillString(String s, int trueLength)
    {
    	//TODO basic null check. true length is OK.
    	
    	int currEnd = trueLength;
    	
    	char [] c = s.toCharArray();
    	
    	int i=0;
    	while(i < currEnd)
    	{
    		if(c[i] == ' ')
    		{
    			shiftUp(c, i+1, currEnd, 2);
    			c[i++]= '%'; c[i++] = '2'; c[i++]='0';
    			currEnd+=2;
    		}
    		else
    			i++;
    	}
    	
    	return new String(c);
    }
    
    private static void shiftUp(char [] c, int s, int e, int amt)
    {
        for(int i=(e -1); i>=s;i--)
        {
        	c[i+amt] = c[i];
        }
    }
    
    
	public static String basicCompression(String s)
	{
	   //TODO basic NULL check
	   
	   int len = s.length();
	   StringBuffer out = new StringBuffer();
	   
	   int i=0;
	   while( i < len)
	   {
	      char c = s.charAt(i);
	      int numRepeats = getRepeatCount(s, c, i);
	      i+=numRepeats;
	      out.append(c);
	      out.append(numRepeats);
	   }
	   
	   String o = out.toString();
	   
	   return (o.length() >= s.length()) ? s : o;
	}
	
	private static int getRepeatCount(String s, char c, int start)
	{
		int count=1;
		
		for(int i=start+1; i< s.length(); i++)
		{
		   if(s.charAt(i) != c)  return count;
		   count++;
		}
		return count;
	}

	public static void main(String[] args) {

//		System.out.println(fillString("abc", 3));
		System.out.println(basicCompression("aaaaabcc"));

	}

}

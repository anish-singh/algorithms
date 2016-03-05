package misc;

public class CountSteps {

	static int numSteps (int n)
	{
		if(n == 0) return 0;
		if (n == 1) return 1;
		return numSteps(n-1) + n-1;
	}
	
	static int countWays(int n)
	{
		if(n<0) return 0;
		if (n==0) return 1;
		return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	public static void main(String[] args) {

		for(int i=10; i >0;i--)
		{
			System.out.println(i + ":" + countWays(i));
			System.out.println(i + ":" + numSteps(i));
		}
	}

}

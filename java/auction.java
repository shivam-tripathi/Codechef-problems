import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
class Auction
{
	public static void main(String args[])throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		while(t>0)
		{
			int n;
			long m,o;
			n = sc.nextInt();
			m = sc.nextLong();
			o = sc.nextLong();
			long [] a = new long [n];
			for(int i = 0; i < n; i++)
			{
				a[i] = sc.nextLong();
			}
			if(a[0] < o)
			{
				System.out.println(-1);
			}
			else
			{
				Arrays.sort(a);
				int i;
				for(i = 0; i < n; i++ )
					if (a[i] >= o)
						break;

				int ans = n-i;

				if( ans > m)
					System.out.println(-1);
				else
					System.out.println(ans);
			}
			t--;
		}

	}
}
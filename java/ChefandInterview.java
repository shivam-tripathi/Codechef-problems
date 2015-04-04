// http://www.codechef.com/APRIL15/problems/CHEFLCM

import java.io.*;
import java.util.*;

class ChefAndInterview
{
	public static void main(String[] args)throws IOException
	{
		
		Scanner sc=new Scanner(System.in);

		int test;
		test = sc.nextInt();
		for(int t=0; t<test; t++)
		{
			long n;
			long sum;
			n = sc.nextLong();
			if(n != 1)
			{
				sum=n+1;
				long endloop;
				double limit = Math.sqrt(n);
				if(limit%1 == 0)
				{	
					sum += (long)limit;
					endloop = (long)(limit-1);
				}
				else
					endloop=(long)limit;

				for(long i=2; i<=endloop; i++)
				{
					if(n%i == 0)
					{
						long temp = n/i;
						sum += (temp + (long)(n/temp));
					}
				}
			}
			else
				sum=1;
			System.out.println(sum);
		}
	}
}


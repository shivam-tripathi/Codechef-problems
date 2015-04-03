// http://www.codechef.com/APRIL15/problems/BROKPHON

import java.io.*;
import java.util.*;
class BrokenTelephone
{
	public static void main(String args[])throws IOException
	{
		
		InputStream inputstream = System.in;
		InputReader in = new InputReader(inputstream);
		
		int test;
		test = in.readInt();
		for(int t=0; t< test; t++)
		{
			int n;
			n = in.readInt();
			int [] a =new int [n];
			for(int i=0; i<n; i++)
			{
				a[i] = in.readInt();
			}
			int c=0,k=1;
			if (a[0] != a[1])
			{
				c += 2;
				k = 2;
			}
			int i;
			for(i=k; i<(n-1); i++)
			{
				int f = 0;
				if(a[i] != a[i-1])
				{	
					f = 1;
				}

				if (a[i] != a[i+1])
				{
					f = 2;
					i += 1;
				}
				if (f == 1)
					c++;
				else if( f==2 )
					c += 2;
			}
			if(i!=(n) && a[n-1] != a[n-2])
			{	
				c++;
			}

			System.out.println(c);
		}
	}
}

// Credit to n1n1_4 for the class below.
class InputReader
{
 
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	 
	public InputReader(InputStream stream)
	{
		this.stream = stream;
	}
	 
	public int read() 
	{
		if (numChars == -1) 
		{
			throw new InputMismatchException();
		}
	
		if (curChar >= numChars) 
		{
			curChar = 0;
			try
			{
				numChars = stream.read(buf);
			}	 
			catch (IOException e)
			{
				throw new InputMismatchException();
			}
			if (numChars <= 0)
			{
				return -1;
			}
		}
		return buf[curChar++];
	}
	 
	public int readInt()
	{
		int c = read();
		while (isSpaceChar(c))
		{
			c = read();
		}
		int sgn = 1;
		if (c == '-')
		{
			sgn = -1;
			c = read();
		}
		int res = 0;
		do
		{
			if (c < '0' || c > '9') {
			throw new InputMismatchException();
		}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
	
		return res * sgn;
	}
	 
	public String readString()
	{
		int c = read();
		while (isSpaceChar(c))
		{
		c = read();
		}
		StringBuffer res = new StringBuffer();
	
		do
		{
			res.appendCodePoint(c);
		c = read();
		} while (!isSpaceChar(c));
		
		return res.toString();
	}
	 
	public long readLong()
	{
		return Long.parseLong(readString());
	}
	 
	public double readDouble()
	{
		return Double.parseDouble(readString());
	}
	 
	public float readFloat()
	{
		return Float.parseFloat(readString());
	}
	 
	public static boolean isSpaceChar(int c)
	{
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
}

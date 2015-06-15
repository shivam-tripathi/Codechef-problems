
import java.io.*;
import java.util.*;

class SteadyTables
{

    private static int mod = 1000000000;//Modulo value

    public static void main(String [] args)throws IOException
    {

        InputStream inputstream = System.in;
        //OutputStream outputstream = System.out;
        Inp_reader sc = new Inp_reader(inputstream);
        //PrintWriter out = new PrintWriter(outputstream);

    //------Input test cases
        int test;
        test = sc.readInt();
        //@shivamflash

    //------Start the test cases
        for(int t = 0; t < test; t++)
        {

        //------Input rows and columns
            int rows, columns;
            rows = sc.readInt();
            columns = sc.readInt();

            int upper_index[] = new int[columns+1];
            int  lower_index = columns-1;

        //------Finding array of upper indexes in nCr.
            for(int i = 0; i <= columns; i++)
            {
                upper_index[i] = i+lower_index;
            }

            long [] possible = nCr(upper_index, lower_index);


        //------Calculation part.

            //Create a shallow copy of the possible array
            long [] copy_possible = new long[columns+1];

            //System.arraycopy(possible,0,copy_possible,0,columns+1);

            copy_possible = possible.clone();

            for(int row = 0; row < rows-1; row++)
            {

                long temp = copy_possible[0];
                //Add all the possibilities
                for(int index = 1; index <= columns; index++)
                {
                    copy_possible[index]  = (copy_possible[index]%mod) + (copy_possible[index-1]%mod);
                    copy_possible[index-1] = temp;
                    temp = (copy_possible[index]%mod) * (possible[index]%mod);
                }

                copy_possible[columns] = temp;
                //Multiply all the possibilities with the end index
                //for( int index = 1; index <= columns; index++)
                //{
                //   copy_possible[index] = (possible[index]%mod) * (copy_possible[index]%mod);
                //}
            }

        //------Calculate the sum.
            long sum=0;
            for(long i : copy_possible)
            {
                sum = (sum%mod)+(i%mod);
            }

        //------Output
            System.out.println(sum%mod);
        }
    }



    public static long[] nCr(int arr [], int r)
    {
        long combi [] = new long[r+2];
        int c = 0;
        long row[] = new long[arr[l-1]+1];
        row[0] = 1;

        for(int i = 0; i <= arr[l-1]; i++)
        {
            for(int j = i; j > 0; j--)
            {
                row[j] = (row[j]%mod) + ((row[j - 1])%mod);
            }

            if(i == arr[c])
            {
                combi[c++] = row[r]%mod;
            }
        }
        return combi;
    }

}

/*
A table is steady when:
  Sum of ith row is less than or equal to (i-1)th row
  Sum of the last row is less than or equal to number of columns.
@shivamflash
    We need to find the possible steady tables for a given r,c
values. The sum of the last row can be anything between c to 0.
If it is c, then one after it may have sum {c-1 .. 0}
For sum of last row equal to (c-1), others = {c-2 .. 0}
@shivamflash
  To find the sum of any row, we need weak compositions of the
number n into c parts. This will give us all possible combinations
to attain this sum in the row.
It is given by formula (n+c-1, c-1).

*/

class Inp_reader
{

    private InputStream stream;
    private int cChar;
    private byte[] buf = new byte[1024];
    private int numChars;

    public Inp_reader(InputStream stream)
    {
        this.stream = stream;
    }

    public int read()
    {
        if (numChars == -1)
        {
            throw new InputMismatchException();
        }

        if (cChar >= numChars)
        {
            cChar = 0;
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
        return buf[cChar++];
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

    public static boolean isSpaceChar(int c)
    {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public double readDouble()
    {
        return Double.parseDouble(readString());
    }

    public long readLong()
    {
        return Long.parseLong(readString());
    }

    public float readFloat()
    {
        return Float.parseFloat(readString());
    }
}

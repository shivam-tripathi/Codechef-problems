import java.io.*;
import java.util.*;

class MathBond
{
    public static void main(String [] args)throws IOException
    {
        int test;
        Scanner sc = new Scanner(System.in);

        test = sc.nextInt();
        for(int t=0; t<test; t++)
        {
            long n = sc.nextLong();
            long ans = 0;
            for(long i=1; i<=(long)(n/2); i++)
            {
                ans += (i*(long)(n/i)) % 1000000007;
            }

            long left = (long)(((n-(n/2))*(n+(n/2)+1))/2.0);
            ans += left%1000000007;
            ans = ans%1000000007;
            System.out.println(ans);
        }
    }
}
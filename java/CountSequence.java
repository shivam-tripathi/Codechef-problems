import java.io.*;
import java.util.*;

class CountSequence
{
    public static void main(String [] args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        long test;
        test=sc.nextLong();
        for(int t=0;t<test;t++)
        {
            long n,l,r;
            n=sc.nextLong();
            l=sc.nextLong();
            r=sc.nextLong();
            long [] a=new long[(int)(r-l+1)];
            for(int i=0; i<r-l+1;i++)
                a[i] = 1;
            long temp;
            long sum = 0;
            for(int i=0;i<n;i++)
            {
                sum += 1;
                for(int j=1;j<=r-l;j++)
                {
                    sum += a[j];
                    a[j] = (a[j] + a[j-1])%1000003;
                }
            }
            System.out.println(sum%1000003);
        }

    }
}
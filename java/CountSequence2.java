import java.io.*;
import java.util.*;

class CountSequence2
{
    public static int mod =1000003;
    public static void main(String[] args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int test;
        test = sc.nextInt();
        for(int t=0; t<test; t++)
        {
            int n,l,r;
            n = sc.nextInt();
            l = sc.nextInt();
            r = sc.nextInt();
            int k = r-l+1;
            long ans = (fact(k+n)*(invert_mod(fact(n))*(invert_mod(fact(k))))%mod);
            System.out.println(((ans%mod)+1000002)%mod);
        }
    }

    public static long invert_mod(long a) 
    {
        long p = mod;
        long ex = p-2, result = 1;
        while (ex > 0) 
        {
            if (ex % 2 == 1)
            {
                result = (result*a) % p;
            }
            a = (a*a) % p;
            ex /= 2;
        }
        return result;
    }
    public static long fact(long a)
    {
        long fact =1;
        for(int i=1;i<=a;i++)
        {
            fact = (fact%mod)*(i%mod);
        }
        return (fact%mod);
    }
}
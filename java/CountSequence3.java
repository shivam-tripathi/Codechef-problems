import java.io.*;
import java.util.*;

class CountSequence3
{
    public static int mod =1000003;
    public static void main(String[] args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int test;
        test = sc.nextInt();
        long[] fac=new long[mod];
        fac[0]=1;
        //Storing all factoials upto (mod-1).
        for(int i=1; i<mod; i++)
        {
            fac[i] = (i*(fac[i-1]%mod))%mod;
        }
        for(int t=0; t<test; t++)
        {
            long n,l,r;
            n = sc.nextLong();
            l = sc.nextLong();
            r = sc.nextLong();
            long k = r-l+1;
            long upperindex = k+n;
            long lowerindex = n;
            long ans=1;

            // We need to calculate C(k+n,n)
            // We will use Lucas theorem and inverse modular function to calculate modulus of C(k+n,n)%mod.
            while(upperindex >0)
            {
                int ui=(int)upperindex%mod;
                int li=(int)lowerindex%mod;
                if(ui<li)
                {
                    ans =0;
                    break;
                }
                long temp = (long)(fac[ui]*invert_mod(fac[li])*invert_mod(fac[ui-li]));
                upperindex /= mod;
                lowerindex /= mod;
                ans = (ans%mod)*(temp%mod);
            }

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
}
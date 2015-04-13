import java.io.*;
import java.util.*;

class SegTree
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        long sum =0;
        int n = sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }

        int m = sc.nextInt();
        int x;
        int y;
        
        SegmentTree ob = SegmentTree.create(a,0,n-1);            
        x=sc.nextInt();
        y=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int maxq, minq;
            maxq = x>y?x:y;
            minq = x>y?y:x;
            sum += ob.query(minq,maxq);
            x = (x+7)%(n-1);
            y = (y+11)%n;
        }
        System.out.println(sum);
    }
}
class Node
{
    int val,maxindex;
    int li,ri;
    public Node(int a, int b, int c, int d)
    {
        this.val = a;
        this.maxindex = b;
        this.li = c;
        this.ri = d;
    }
}

class SegmentTree
{
    Node node;
    SegmentTree left,right;
    public SegmentTree()
    {
        this.left = null;
        this.right = null;
        this.node = null;
    }
    public static SegmentTree create(int values[], int l, int r)
    {
        SegmentTree subtree = new SegmentTree();
        if(l==r)
        {
            subtree.node = new Node(values[l],l,l,l);
            return subtree;
        }
        else
        {
            subtree.left=( create(values,l,(l+r)/2) );
            subtree.right=( create(values,(l+r)/2+1,r));
        }
        if (subtree.right.node.val > subtree.left.node.val)
         {
            subtree.node = new Node(subtree.right.node.val,subtree.right.node.maxindex,l,r);
         }
        else
        {
            subtree.node = new Node(subtree.left.node.val,subtree.left.node.maxindex,l,r);
        }
        return subtree;
    }
    int query(int l, int r)
    {
        return helper(this,l,r);
    }
    int helper(SegmentTree subtree, int l, int r)
    {
        int lv,rv;
        int x = subtree.node.li;
        int y = subtree.node.ri;
        if( r<x || y<l )
            return Integer.MIN_VALUE;
        if( l<=x && x<=y && y<=r && l<=r )
            return subtree.node.val;
        else
        {
            lv = helper(subtree.left,l,r);
            rv = helper(subtree.right,l,r);
        }
        return (lv>rv)?lv:rv;
    }
}


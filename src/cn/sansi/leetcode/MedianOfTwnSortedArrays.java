package cn.sansi.leetcode;

import cn.sansi.utils.JsonUtils;

public class MedianOfTwnSortedArrays {
	public static void main(String[] args){
		MedianOfTwnSortedArrays sln=new MedianOfTwnSortedArrays();
		int[] input={2,3,4};
		int[] input2={1,1,1,1,1,1,5,6};
		long s=System.currentTimeMillis();
		Object output=sln.findMedianSortedArrays(input, input2);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}

    public double findKth(int k, int a[], int as, int ae, int b[], int bs, int be){
        int al=ae-as+1;
        int bl=be-bs+1;
        if(al>bl){
            return findKth(k,b,bs,be,a,as,ae);
        }

        if(al==0){
            return b[bs+k-1];
        }

        if(k==1){
            return Math.min(a[as], b[bs]);
        }

        int pa=Math.min(al, k / 2);
        int pb=k-pa;
        if(a[as+pa-1]<b[bs+pb-1]){
            return findKth(k-pa,a,as+pa,ae,b,bs,be);
        }else if(a[as+pa-1]>b[bs+pb-1]){
            return findKth(k - pb, a, as, ae, b, bs + pb, be);
        }else{
            return a[as+pa-1];
        }
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int len=A.length+B.length;
        if(len%2==0){
            double m=findKth(len/2,A,0,A.length-1,B,0,B.length-1);
            double n=findKth(len/2+1,A,0,A.length-1,B,0,B.length-1);
            return (m+n)/2;
        }else{
            return findKth(len/2+1,A,0,A.length-1,B,0,B.length-1);
        }
    }
}


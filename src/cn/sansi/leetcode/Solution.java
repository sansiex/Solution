package cn.sansi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import utils.JsonUtils;

public class Solution {
	public static void main(String[] args){
		Solution sln=new Solution();
		int[] input={2,3};
		int[] input2={1};
		long s=System.currentTimeMillis();
		Object output=sln.findMedianSortedArrays(input, input2);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}

    public double median(int[] arr, int s, int e){
        int m=(s+e)/2;
        if((s+e)%2==0){
            return arr[m];
        }else{
            return ((double)arr[m]+(double)arr[m+1])/(double)2;
        }
    }

    public double recursive(int A[], int sa, int ea, int B[], int sb, int eb) {
        if(ea==sa && eb==sb){
            return (A[sa]+B[sb])/(double)2;
        }

        if(ea<sa){
            return median(B,sb,eb);

        }else if(eb<sb){
            return median(A,sa,ea);
        }

        double ma=median(A,sa,ea);
        double mb=median(B,sb,eb);
        if(ma==mb){
            return ma;
        }else if(ma<mb){
            return recursive(A,(sa+ea)/2+1,ea,B,sb,(sb+eb)/2-1);
        }else{
            return recursive(A,sa,(sa+ea)/2-1,B,(sb+eb)/2+1,eb);
        }
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        return recursive(A,0,A.length-1,B,0,B.length-1);
    }
}


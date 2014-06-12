package cn.sansi.leetcode;

import cn.sansi.utils.JsonUtils;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters sln=new LongestSubstringWithoutRepeatingCharacters();
		String input="abcabcbb";
		//int[] input2={1,1,1,1,1,1,5,6};
		long s=System.currentTimeMillis();
		Object output=sln.lengthOfLongestSubstring(input);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int len=0;
        int max=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            Integer ci=map.get(c);
            len++;
            if(ci==null){
                map.put(c,i);
                if(len>max){
                    max=len;
                }
            }else{
                len-=ci-start+1;
                for (int j = start; j <= ci; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(c,i);
                start=ci+1;
            }
        }
        return max;
    }
}


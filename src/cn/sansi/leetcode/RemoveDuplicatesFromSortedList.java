package cn.sansi.leetcode;

import cn.sansi.utils.JsonUtils;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args){
		RemoveDuplicatesFromSortedList sln=new RemoveDuplicatesFromSortedList();
		ListNode input=InitUtils.getSinglyList("1,1,2,3,3,4,4,5,5,5");
		int input2=3;
		long s=System.currentTimeMillis();
		Object output=sln.deleteDuplicates(input);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fwd=head;

        while(fwd.next!=null){
            if(fwd.next.val==fwd.val){
                fwd.next=fwd.next.next;
            }else{
                fwd=fwd.next;
            }
        }

        return head;
    }
}


package cn.sansi.leetcode;

import utils.JsonUtils;

public class RemoveDuplicatesFromSortedList2 {
	public static void main(String[] args){
		RemoveDuplicatesFromSortedList2 sln=new RemoveDuplicatesFromSortedList2();
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
        ListNode pre=new ListNode(0);
        ListNode fwd=head;
        pre.next=fwd;

        while(fwd!=null && fwd.next!=null){
            if(fwd.next.val==fwd.val){
                while(fwd.next!=null && fwd.next.val==fwd.val){
                    fwd=fwd.next;
                }
                if(pre.next==head){
                    head=fwd.next;
                }
                pre.next=fwd.next;
                fwd=fwd.next;
            }else{
                pre=fwd;
                fwd=fwd.next;
            }
        }

        return head;
    }
}


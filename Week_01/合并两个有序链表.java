import java.util.Arrays;

/**
 * Created by Administrator on 2020/6/26.
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

        //两个有序链表 有序 类似快慢指针
//        ListNode res=new ListNode();
//        ListNode p=res;
//        while (l1 !=null && l2!=null){
//            p.val=Math.min(l1.val,l2.val);
//            ListNode tmp=new ListNode();
//            p.next=tmp;
//            p=tmp;
//            if(l1.val<=l2.val){
//                l1=l1.next;
//            }else {
//                l2=l2.next;
//            }
//        }
//        if(l1 == null) {
//            p.val=l2.val;
//            p.next= l2.next;
//        }
//        if(l2 == null) {
//            p.val=l1.val;
//            p.next= l1.next;
//        }
//
//        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public static void main(String[] args) {
//        ListNode l1=new ListNode(1);
//        l1.next=new ListNode(2,new ListNode(4));
//        ListNode l2=new ListNode(1);
//        l2.next=new ListNode(3,new ListNode(4));
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(1);

        ListNode res=mergeTwoLists(l1,l2);
        while (res!=null){
            System.out.print(res.val);
            System.out.print("->");
            res=res.next;
        }


    }

}

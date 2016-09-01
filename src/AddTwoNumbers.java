import java.util.List;

/**
 * Created by tanyi on 16/8/26.
 */
public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode head = null;
        ListNode cur = null;
        ListNode last = null;
        int val1 = 0;
        int val2 = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }else {
                val1 = 0;
            }
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }else {
                val2 = 0;
            }
            int sum = val1 + val2 + tmp;
            int val = sum % 10;
            tmp = sum / 10;
            cur = new ListNode(val);
            if(head == null) {
                head = cur;
                last = cur;
            }
            else {
                last.next = cur;
                last = cur;
            }
        }
        if(tmp > 0) {
            last.next = new ListNode(tmp);
        }

        return head;
    }

    public  static ListNode genListNode(ListNode l, int [] nums) {
        ListNode  cur = null;
        ListNode last = null;
        for(int i = 0; i < nums.length; i++) {
            cur = new ListNode(nums[i]);
            if(l == null) {
                l = cur;
                last = cur;
            }else {
                last.next = cur;
                last = cur;
            }
        }
        return l;
    }

    public static void dump(ListNode res) {
        while(res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }
        System.out.println("!");
    }

    public  static void main(String[] args) {
        AddTwoNumbers addTwoNumbersObj = new AddTwoNumbers();
        int[] la = {9};
        int[] lb = {1};
        ListNode l1 = null, l2 = null;
        l1 = genListNode(null, la);
        l2 = genListNode(null, lb);
        dump(l1);
        dump(l2);
        ListNode res = addTwoNumbersObj.addTwoNumbers(l1, l2);
        dump(res);
    }
}

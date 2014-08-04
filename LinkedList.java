class LinkedList {
    public class ListNode{
        public ListNode next = null;
        public int val = -1;
        public ListNode(int i){
            val = i;
        }
    }

    public boolean hasCycle(ListNode node){
        if (node == null){
            return false;
        }
        ListNode h  = new ListNode(-1);
        h.next = node;
        ListNode ptr1 = h;
        ListNode ptr2 = h;
        while (ptr1 != null && ptr2 != null && ptr2.next != null){
            if (ptr1 != h && ptr1 == ptr2){
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        if (ptr2 == null || (ptr2 != null && ptr2.next == null)){
            return false;
        }else {
            return true;
        }
    }

    public ListNode nodeCycle(ListNode node){
        if(node == null){
            return null;
        }
        ListNode h = new ListNode(-1);
        h.next = node;

        ListNode ptr1 = h;
        ListNode ptr2 = h;

        while (ptr1 != null && ptr2 != null && ptr2.next != null){
            if (ptr1 != h && ptr1 == ptr2){
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        if (ptr2 == null || (ptr2 != null && ptr2.next == null)){
            return null;
        }else {
            int count = 1;
            ptr2 = ptr1.next;
            while (ptr2 != ptr1){
                ptr2 = ptr2.next;
                count++;
            }

            ptr1 = h;
            ptr2 = h;
            while (count>=0){
                ptr2 = ptr2.next;
                count--;
            }

            while (ptr1 != ptr2){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            return ptr1;
        }

    }
}
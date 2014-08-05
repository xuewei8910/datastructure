
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

    public ListNode search(ListNode node, int target){
        ListNode h = new ListNode(-1);
        h.next = node;
        ListNode ptr = h;
        while (ptr != null){
            if (ptr.val == target){
                return ptr;
            }
        }
        return null;
    }

    public boolean remove(ListNode node, ListNode pre, int target){
        if (node == null){
            return null;
        }else {
            if (node.val == target){
                pre.next = node.next;
                return true;
            }
            return remove(node.next,node,target);
        }
    }

    public boolean insert(ListNode node, ListNode n, int target){
        while (node != null && target != node.val){
            node = node.next;
        }

        if (node == null){
            return false;
        }else {
            n.next = node.next;
            node.next = n;
            return true;
        }
    }

    public ListNode reverse(ListNode node, ListNode pre){
        if (node != null){
            ListNode tmp = node.next;
            node.next = pre;
            return reverse(tmp, node);
        }else {
            return pre;
        }
    }

    public ListNode append(ListNode ptr1, ListNode ptr2){
        if (ptr1 == null){
            return ptr2;
        }else {
            ptr1.next = append(ptr1.next,ptr2);
            return ptr1;
        }
    }

    public ListNode merge(ListNode ptr1, ListNode ptr2){
        if (ptr1 == null){
            return ptr2;
        }else if (ptr2 == null){
            return ptr1;
        }else if (ptr1.val < ptr2.val){
            ptr1.next = merge(ptr1.next, ptr2);
            return ptr1;
        }else {
            ptr2.next = merge(ptr1,ptr2.next);
            return ptr2;
        }
    }

}
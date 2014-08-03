import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;
import java.util.Stack;

class BST{
    private class TreeNode{
        public TreeNode left = null;
        public TreeNode right = null;
        public int val = 0;
        public TreeNode(){}
        public TreeNode(int init){
            val = init;
        }
    }

    private TreeNode root = null;

    public BST(){
        root = new TreeNode();
    }

    public void preorder(TreeNode node, ArrayList<Integer> result){
        if (node != null){
            System.out.printf("%d ",node.val);
            result.add(node.val);
            preorder(node.left,result);
            preorder(node.right,result);
        }
    }

    public void inorder(TreeNode node, ArrayList<Integer> result){
        if (node != null){
            inorder(node.left,result);
            System.out.printf("%d ", node.val);
            result.add(node.val);
            inorder(node.right,result);
        }

    }

    public void postorder(TreeNode node, ArrayList<Integer> result){
        if (node != null){
            postorder(node.left,result);
            postorder(node.right, result);
            System.out.printf("%d ", node.val);
            result.add(node.val);
        }
    }

    public TreeNode search(TreeNode node, int val){
        if(node != null){
            if(val == node.val){
                return node;
            }else if (val<node.val){
                return search(node.left, val);
            }else {
                return search(node.right, val);
            }
        }
        return null;
    }

    public TreeNode searchI(TreeNode node, int val){
        TreeNode ptr = node;
        while (ptr != null){
            if (val == ptr.val){
                return ptr;
            }else if (val < ptr.val){
                ptr = ptr.left;
            }else {
                ptr = ptr.right;
            }
        }
        return null;
    }

    public void insert(TreeNode node, int val){
        if (node == null){
            node = new TreeNode(val);
        }else if(val < node.val){
            insert(node.left,val);
        }else {
            insert(node.right, val);
        }
    }

    public boolean delete(TreeNode node, TreeNode par, int val){
        if (node == null){
            return false;
        }
        if (par == null){
            par = new TreeNode();
            par.left = node;
        }

        TreeNode parent = par;
        TreeNode ptr = node;
        while (ptr != null && ptr.val != val){
            if (val < ptr.val){
                parent = ptr;
                ptr = ptr.left;
            }else {
                parent = ptr;
                ptr = ptr.right;
            }
        }

        if (ptr == null){
            return false;
        }else {
            if (ptr.left == ptr.right && ptr.left == null){
                if (parent.left == ptr){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
            }else if(ptr.left == null){
                if (parent.left == ptr){
                    parent.left = ptr.right;
                }else {
                    parent.right = ptr.right;
                }
            }else if (ptr.right == null){
                if (parent.left == ptr){
                    parent.left = ptr.left;
                }else {
                    parent.right = ptr.left;
                }
            }else {
                if (parent.left == ptr){
                    TreeNode p = ptr;
                    while (p.right != null){
                        p = p.right;
                    }
                    ptr.val = p.val;
                    return delete(ptr.right,ptr,p.val);
                }else {
                    TreeNode p = ptr;
                    while (p.left != null){
                        p = p.left;
                    }
                    ptr.val = p.val;
                    return delete(ptr.left,ptr,p.val);
                }
            }
            return true;
        }
    }

    public ArrayList<Integer> preorderI(TreeNode node){
        Stack<TreeNode> st = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (node == null){
            return result;
        }
        st.push(node);
        TreeNode ptr = node;
        while (!st.isEmpty()){
            result.add(ptr.val);
            if (ptr.left != null){
                st.push(ptr.left);
                ptr = ptr.left;
            }else {
                ptr = st.pop();
                st.push(ptr.right);
                ptr = ptr.right;
            }
        }
        return result;
    }

    public ArrayList<Integer> inorderI(TreeNode node){
        Stack<TreeNode> st = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (node == null){
            return result;
        }

        st.push(node);
        TreeNode ptr = node;
        while (!st.isEmpty()){
            if (ptr.left != null){
                st.push(ptr.left);
                ptr = ptr.left;
            }else {
                ptr = st.pop();
                result.add(ptr.val);
                st.push(ptr.right);
                ptr = ptr.right;
            }
        }

        return  result;
    }

    public ArrayList<Integer> postorderI(TreeNode node){
        Stack<TreeNode> st = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (node == null){
            return result;
        }

        st.push(node);
        TreeNode pre = null;
        while (!st.isEmpty()){
            TreeNode ptr = st.peek();
            if (pre == null || pre.left == ptr || pre.right == ptr){
                if (ptr.left != null){
                    st.push(ptr.left);
                }else {
                    st.push(ptr.right);
                }
            }else if (ptr.left == pre){
                if (ptr.right != null){
                    st.push(ptr.right);
                }
            }else {
                result.add(ptr.val);
                st.pop();
            }
            pre = ptr;
        }

        return result;
    }
}
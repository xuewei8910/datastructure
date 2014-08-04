import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.print.attribute.HashPrintRequestAttributeSet;
import java.lang.Boolean;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph{
    public class GraphNode{
        int id = -1;
        ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
        public GraphNode(int i){
            id = i;
        }
    }

    public GraphNode dfs(GraphNode root, HashMap<GraphNode,Boolean> map, int target){
        if (root.id == target){
            return root;
        }else {
            for (GraphNode node : root.neighbors){
                if (!map.containsKey(node)){
                    map.put(node,true);
                    return dfs(node,map,target);
                }
            }
            return null;
        }
    }

    public GraphNode bfs(ArrayList<GraphNode> current,HashMap<GraphNode, Boolean> map, int target){
        ArrayList<GraphNode> next = new ArrayList<GraphNode>();
        for (GraphNode node : current){
            if (node.id == target){
                return node;
            }else {
                map.put(node,true);
                for (GraphNode neighbor : node.neighbors){
                    if (!map.containsKey(neighbor)){
                        next.add(neighbor);
                    }
                }
            }
        }
        return bfs(next,map,target);
    }

    public GraphNode dfsI(GraphNode root, int target){
        HashMap<GraphNode, Boolean> map = new HashMap<GraphNode, Boolean>();
        Stack<GraphNode> st = new Stack<GraphNode>();
        st.push(root);
        while (!st.isEmpty()){
            GraphNode ptr = st.pop();
            map.put(ptr,true);
            if (ptr.id == target){
                return ptr;
            }else {
                for (GraphNode node : ptr.neighbors){
                    if (!map.containsKey(node)){
                        st.push(node);
                    }
                }
            }
        }
        return null;
    }

    public GraphNode bfsI(GraphNode root, int target){
        HashMap<GraphNode,Boolean> map = new HashMap<GraphNode, Boolean>();
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(root);
        while (!q.isEmpty()){
            GraphNode ptr = q.poll();
            map.put(ptr,true);
            if (ptr.id == target){
                return ptr;
            }else {
                for (GraphNode node : ptr.neighbors){
                    if (!map.containsKey(node)){
                        q.add(node);
                    }
                }
            }
        }
        return null;
    }
}
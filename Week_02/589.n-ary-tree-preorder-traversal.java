import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// 589
// https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/java-ncha-shu-qian-xu-bian-li-di-gui-die-dai-by-st/
// *************************************************************************
// recursion 
// class Solution {
//     public List<Integer> preorder(Node root) {
//         List<Integer> res = new ArrayList<>();
//         preOrder(root, res);
//         return res;
//     }

//     private void preOrder(Node root, List<Integer> res)
//     {
//         if(root == null)
//             return;
        
//         res.add(root.val);
//         for(int i=0; i<root.children.size(); i++) {
//             preOrder(root.children.get(i), res);
//         }
//     }

// }

// *************************************************************************
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
    
        Stack<Node>stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            res.add(pop.val);
            for(int i=pop.children.size()-1; i>=0; i--)
                stack.push(pop.children.get(i));
        }
        return res;
    }

}


// 20%

// @lc code=end


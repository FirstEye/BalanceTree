package operate;

import java.util.*;
public class BalanceTree {
	
	public class TreeNode{
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x){
			   val = x;
		   }
	}

	//二叉树的节点个数
	public static int getNodeNumber(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return getNodeNumber(root.left) + getNodeNumber(root.right) + 1;
	}
	
	//二叉树的最大层数(最大深度)
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	}
	
	//二叉树最小深度
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
	
	//先序遍历/前序遍历
	public List<Integer> preOrderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val, null);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}
	
	//中序遍历
	public List<Integer> inOrderTraveral(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur != null) {
			if(cur != null ) {
				stack.push(cur);
				cur = cur.left;
			}else {
				cur = stack.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}
		return res;
	}
	
	//postOrderTraversal
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode visited = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.peek();
                if(cur.right != null && cur.right != visited){
                    cur = cur.right;
                }else{
                    res.add(cur.val);
                    visited = cur;
                    stack.pop();
                    cur = null;
                }
            }
        }
        return res;
	}
	
	//levelOrder
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur = null;
        queue.add(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int l = queue.size();
            for(int i=0; i<l;i++){
                cur = queue.poll();
                level.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}

import com.sun.corba.se.impl.interceptors.InterceptorList;

import java.util.ArrayList;
import java.util.List;

import static sun.swing.MenuItemLayoutHelper.max;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
        }
        if (root.left != null) {
            list.addAll(new Solution().preorderTraversal(root.left));
        }
        if (root.right != null) {
            list.addAll(new Solution().preorderTraversal(root.right));
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                list.addAll(new Solution().inorderTraversal(root.left));
            }
            list.add(root.val);
            if (root.right != null) {
                list.addAll(new Solution().inorderTraversal(root.right));
            }
        }

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                list.addAll(new Solution().postorderTraversal(root.left));
            }

            if (root.right != null) {
                list.addAll(new Solution().postorderTraversal(root.right));
            }

            list.add(root.val);
        }

        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root != null) {
            List<Integer> listTmps = new ArrayList<>();
            List<TreeNode> listNode = new ArrayList<>();
            List<TreeNode> listNodeTmp = new ArrayList<>();
            boolean listWhile = true;
            listTmps.add(root.val);
            listNode.add(root);
            while (listWhile) {
                listWhile = false;
                list.add(new ArrayList<>(listTmps));
                listTmps.clear();
                for (int i = 0; i < listNode.size(); i++) {

                    if (listNode.get(i) != null && listNode.get(i).left != null) {
                        listNodeTmp.add(listNode.get(i).left);
                        listTmps.add(listNode.get(i).left.val);
                        listWhile = true;
                    }
                    if (listNode.get(i) != null && listNode.get(i).right != null) {
                        listNodeTmp.add(listNode.get(i).right);
                        listTmps.add(listNode.get(i).right.val);
                        listWhile = true;
                    }

                }
                listNode.clear();
                listNode.addAll(new ArrayList<>(listNodeTmp));
                listNodeTmp.clear();
            }
        }
        return list;
    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        int depthRight = 0;
        int depthLeft = 0;
        if (root != null) {
            depth = 1;
            if (root.right != null) {
                depthRight = maxDepth(root.right);
            }

            if (root.left != null) {
                depthLeft = maxDepth(root.left);
            }
            if (depthLeft > depthRight) {
                depth += depthLeft;
            } else {
                depth += depthRight;
            }
            //depth += max(depthLeft,depthRight);
        }
        return depth;
    }

}

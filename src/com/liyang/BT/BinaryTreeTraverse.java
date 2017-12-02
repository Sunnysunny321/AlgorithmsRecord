package com.liyang.BT;

/*
 *
 *     遍历二叉树的递归和非递归的几种方法
 *     先序遍历（记忆两种方式，一种和中序相关，一种和后序相关）
 *     中序遍历
 *     后序遍历
 *     层次遍历（按层打印，带层号打印，之子形打印）
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.System.*;

class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode(T val) {
        this.val = val;
    }
}

class BinaryTreeTraverse<T> {
    void preOrderRecursion(TreeNode<T> root) {
        if (root == null) return;
        out.print(root.val + " ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }
    void preOrderNonRecursion(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                out.print(root.val + " ");
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    void preOrderNonRecursion2(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            out.print(root.val + " ");
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
    }

    void inOrderRecursion(TreeNode<T> root) {
        if (root == null) return;
        inOrderRecursion(root.left);
        out.print(root.val + " ");
        inOrderRecursion(root.right);
    }

    void inOrderNonRecursion(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    void postOrderRecursion(TreeNode<T> root) {
        if (root == null) return;
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        out.print(root.val + " ");
    }

    void postOrderNonRecursion(TreeNode<T> root) {
        //将此方法与前序遍历的方式结合起来记忆
        if (root == null) return;
        Stack<TreeNode<T>> s1 = new Stack<>();
        Stack<TreeNode<T>> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) s1.push(root.left);
            if (root.right != null) s1.push(root.right);
        }
        while (!s2.isEmpty())
            out.print(s2.pop().val + " ");
    }

    void postOrderNonRecursion2(TreeNode<T> root) {
        /*
        注：理解此方法，平时尽量用两个栈实现的方法
        root: 最近打印的元素
        top: 栈顶元素
        如果最近打印的元素既不是栈顶元素的左孩子也不是其右孩子，那么将左孩子压入栈，
        如果最近打印的元素不是栈顶元素的右孩子，那么将右孩子压入栈，
        否则将栈顶元素弹出并打印，并令其为最近打印的元素
        注意初始值：root为最近打印的元素的初始值
         */
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        TreeNode<T> top;
        while (!stack.isEmpty()) {
            top = stack.peek();
            if (top.left != null && root != top.left && root != top.right)
                stack.push(top.left);
            else if (top.right != null && root != top.right)
                stack.push(top.right);
            else {
                out.print(stack.pop().val + " ");
                root = top;
            }
        }
    }

    void printByFloor(TreeNode<T> root) {
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            out.print(root.val + " ");
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }
    }

    void printByFloor2(TreeNode<T> root) {
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        int floor = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            out.format("第%d层: ", floor++);
            while (size-- > 0) {
                root = queue.poll();
                out.print(root.val + " ");
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            out.println();
        }
    }

    void printByFloor3(TreeNode<T> root) {
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode<T> last = root;
        TreeNode<T> nlast = null;
        int level = 1;
        out.printf("level %d: ", level++);
        while (!queue.isEmpty()) {
            root = queue.poll();
            out.print(root.val + " ");
            if (root.left != null) {
                queue.offer(root.left);
                nlast = root.left;
            }
            if (root.right != null) {
                queue.offer(root.right);
                nlast = root.right;
            }
            if (root == last && !queue.isEmpty()) {
                last = nlast;
                out.printf("\nlevel %d: ", level++);
            }
        }
    }

    void printByFloor4(TreeNode<T> root) {
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        Stack<T> stack = new Stack<>();
        queue.offer(root);
        int floor = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            out.format("第%d层: ", ++floor);
            while (size-- > 0) {
                root = queue.poll();
                if (floor % 2 == 1)
                    out.print(root.val + " ");
                else
                    stack.push(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            while (!stack.isEmpty())
                out.print(stack.pop() + " ");
            out.println();
        }
    }



}

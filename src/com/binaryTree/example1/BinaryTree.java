package com.binaryTree.example1;

import java.util.*;

class BinaryTree<T> {
    /*
     * 先序创建二叉树
     * 返回：根节点
     */
    TreeNode<T> createBinaryPre(LinkedList<T> treeData) {
        TreeNode<T> root = null;
        T data = treeData.removeFirst();
        if (data != null) {
            //根左右：采用先序创建二叉树
            root = new TreeNode<>(data, null, null);
            root.left = createBinaryPre(treeData);
            root.right = createBinaryPre(treeData);
        }
        return root;
    }

    /*
     * 先序遍历二叉树（递归）
     */
    void PrintBinaryTreePreRecur(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.data);
            PrintBinaryTreePreRecur(root.left);
            PrintBinaryTreePreRecur(root.right);
        }
    }

    /*
     * 中序遍历二叉树（递归）
     */
    void PrintBinaryTreeMidRecur(TreeNode<T> root) {
        if (root != null) {
            PrintBinaryTreeMidRecur(root.left);
            System.out.print(root.data);
            PrintBinaryTreeMidRecur(root.right);
        }
    }

    /*
     * 后序遍历二叉树（递归）
     */
    void PrintBinaryTreeBacRecur(TreeNode<T> root) {
        if (root != null) {
            PrintBinaryTreeBacRecur(root.left);
            PrintBinaryTreeBacRecur(root.right);
            System.out.print(root.data);
        }
    }

    /*
     * 先序遍历二叉树（非递归）
     * 思路：对于任意节点T，访问这个节点并压入栈中，然后访问节点的左子树，
     *      遍历完左子树后，取出栈顶的节点T，再先序遍历T的右子树
     */
    void PrintBinaryTreePreNonrecursion(TreeNode<T> root) {
        TreeNode<T> p = root;//p为当前节点
        Stack<TreeNode<T>> stack = new Stack<>();
        //栈不为空时，或者p不为空时循环
        while (p != null || !stack.isEmpty()) {
            //当前节点不为空。访问并压入栈中。并将当前节点赋值为左儿子
            if (p != null) {
                stack.push(p);
                System.out.print(p.data);
                p = p.left;
            }
            //当前节点为空：
            //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
            //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
            //取出栈顶元素，赋值为right
            else {
                p = stack.pop();
                p = p.right;
            }
        }
    }


    /*
     *先序遍历
     *
     */
    void MyPrintBinaryTreePreNonRecursion(TreeNode<T> root) {
        TreeNode<T> current = root;
        if (current == null)
            return;
        Stack<TreeNode<T>> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.print(current.data);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
        System.out.println();
    }

    /*
     * 先序遍历：使用堆栈的最优解 -- 左神 sunny
     * 堆栈：先放右节点，再放左节点；然后弹出一个元素，并打印；然后继续先放右节点，再放左节点
     */
    /*void MyPrintBinaryTreeNonRecursion(TreeNode<T> root) {
        TreeNode<T> head = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        if (head != null)
            stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.data);
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
        System.out.println();
    }*/



    /*
     * 中序遍历二叉树（非递归）
     *
     * 思路：先将T入栈，遍历左子树；遍历完左子树返回时，栈顶元素应为T，
     *       出栈，访问T->data，再中序遍历T的右子树。
     */
    void PrintBinaryTreeMidNonrecursion(TreeNode<T> root) {
        TreeNode<T> p = root;//p为当前节点
        Stack<TreeNode<T>> stack = new Stack<>();

        //栈不为空时，或者p不为空时循环
        while (p != null || !stack.isEmpty()) {
            //当前节点不为空。压入栈中。并将当前节点赋值为左儿子
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            //当前节点为空：
            //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
            //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
            //取出并访问栈顶元素，赋值为right
            else {
                p = stack.pop();
                System.out.print(p.data);
                p = p.right;
            }
        }
    }

    /*
     * 中序遍历：从root节点开始，依次将左节点压入栈中；若遇到左节点为空，那么从栈中弹出元素，并打印，并遍历右节点
     */

    void MyPrintBinaryTreeInNonrecursion(TreeNode<T> root) {
        TreeNode<T> head = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.data);
                head = head.right;
            }
        }
        System.out.println();
    }

    /*
     * 后续遍历: 使用一个堆栈进行后续遍历
     * current: 始终指着stack的栈顶元素
     * old: 代表最近从堆栈中弹出的元素
     */

    void MyPrintBinaryTreePostNonRecursion2(TreeNode<T> root) {
        if (root == null)
            return;
        TreeNode<T> current = root;
        TreeNode<T> old = null;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (current.left != null && current.left != old && current.right != old) { //有些疑惑
                stack.push(current.left);
            } else if (current.right != null && current.right != old) {
                stack.push(current.right);
            } else {
                System.out.print(stack.pop().data);
                old = current;
            }
        }
        System.out.println();
    }


    /*
     * 后序遍历: 使用两个堆栈进行后序遍历
     * stack1:每次弹出一个元素，然后弹出元素的左节点和右节点依次加入stack1
     * stack2:将stack1弹出的元素加入stack2
     * 结果: 依次弹出stack2中的元素
     */
    /*void MyPrintBinaryTreePostNonRecursion1(TreeNode<T> root) {
        TreeNode<T> current = root;
        if (current == null)
            return;
        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        stack1.push(current);
        while (!stack1.isEmpty()) {
            current = stack1.pop();
            stack2.push(current);
            if (current.left != null)
                stack1.push(current.left);
            if (current.right != null)
                stack1.push(current.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data);
        }
        System.out.println();
    }
*/

    /*
     * 后序遍历二叉树（非递归）
     *
     */
/*    void PrintBinaryTreeBacNonrecursion(TreeNode<T> root) {
        class NodeFlag<T> {
            private TreeNode<T> node;
            private char tag;

            private NodeFlag(TreeNode<T> node, char tag) {
                super();
                this.node = node;
                this.tag = tag;
            }
        }
        LinkedList<NodeFlag<T>> stack = new LinkedList<>();
        TreeNode<T> p = root;
        NodeFlag<T> bt;
        //栈不空或者p不空时循环
        while (p != null || !stack.isEmpty()) {
            //遍历左子树
            while (p != null) {
                bt = new NodeFlag<>(p, 'L');
                stack.push(bt);
                p = p.left;
            }
            //左右子树访问完毕访问根节点
            while (!stack.isEmpty() && stack.getFirst().tag == 'R') {
                bt = stack.pop();
                System.out.print(bt.node.data);
            }
            //遍历右子树
            if (!stack.isEmpty()) {
                bt = stack.peek();
                bt.tag = 'R';
                p = bt.node;
                p = p.right;
            }
        }
    }*/

    /*
     * 层次遍历二叉数: 使用宽度优先遍历,queue
     */
    void MyPrintBinaryTreeLayerNonRecursion(TreeNode<T> root) {
        if (root == null)
            return;
        TreeNode<T> current = root;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.data);
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
        System.out.println();
    }

    /*
     * 层次遍历二叉树（非递归）
     */
    /*void PrintBinaryTreeLayerNonrecursion(TreeNode<T> root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode<T> p;
        queue.push(root);
        while (!queue.isEmpty()) {
            p = queue.removeFirst();
            System.out.print(p.data);
            if (p.left != null)
                queue.addLast(p.left);
            if (p.right != null)
                queue.addLast(p.right);
        }
    }*/
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


}
package com.binaryTree.example1;

import java.util.LinkedList;
/*
 * 测试二叉树的  创建、遍历
 * 二叉树结构如下
 *            A
 *       B         C
 *    D     E   F     G
 *  H   I        J
 */
public class TestBinaryTree
{
    public static void main(String[] args)
    {
        BinaryTree<Character> binaryTree=new BinaryTree<>();

        //输入ABDH##I##E##CF#J##G##（#用null代替）
        LinkedList<Character> tree=new LinkedList<>();
        tree.add('A');tree.add('B');tree.add('D');
        tree.add('H');tree.add(null);tree.add(null);
        tree.add('I');tree.add(null);tree.add(null);
        tree.add('E');tree.add(null);tree.add(null);
        tree.add('C');tree.add('F');tree.add(null);
        tree.add('J');tree.add(null);tree.add(null);
        tree.add('G');tree.add(null);tree.add(null);

        TreeNode<Character> root=binaryTree.createBinaryPre(tree); //使用先序创建二叉树


        System.out.println("递归实现(依次为前、中、后遍历): ");
        //先序遍历（递归）
        binaryTree.PrintBinaryTreePreRecur(root);System.out.println();
        //中序遍历（递归）
        binaryTree.PrintBinaryTreeMidRecur(root);System.out.println();
        //后序遍历（递归）
        binaryTree.PrintBinaryTreeBacRecur(root);System.out.println();

        System.out.println("非递归实现(依次为前、中、后、层遍历): ");
        //先序遍历（非递归）
        //binaryTree.PrintBinaryTreePreNonrecursion(root);System.out.println();
        binaryTree.MyPrintBinaryTreePreNonRecursion(root);
        //中序遍历（非递归）
        //binaryTree.PrintBinaryTreeMidNonrecursion(root);System.out.println();
        binaryTree.MyPrintBinaryTreeInNonrecursion(root);
        //后序遍历（非递归）
        //binaryTree.PrintBinaryTreeBacNonrecursion(root);System.out.println();
        //binaryTree.MyPrintBinaryTreePostNonRecursion1(root);
        binaryTree.MyPrintBinaryTreePostNonRecursion2(root);
        //层次遍历（非递归）
        //binaryTree.PrintBinaryTreeLayerNonrecursion(root);System.out.println();
        binaryTree.MyPrintBinaryTreeLayerNonRecursion(root);


    }
}
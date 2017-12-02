package com.liyang.BT;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class TestBT {

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        File file = new File("D:\\java\\java_Github\\src\\com\\liyang\\BT\\preOrderSerialization.txt");
        if (!file.exists()) {
            out.println("文件未找到...");
            System.exit(0);
        }
        Scanner sc = new Scanner(file);
        List<String> listStr = new LinkedList<>();
        while (sc.hasNext())
            listStr.add(sc.next());

        for (String str: listStr) {
            if (str.charAt(0) != '#')
                list.add(Integer.parseInt(str));
            else
                list.add(null);
        }


        CreateBT<Integer> BT = new CreateBT<>();
        TreeNode<Integer> root = BT.createByPreOrder(list);
        BinaryTreeTraverse<Integer> BTT = new BinaryTreeTraverse<>();
        out.println("PreOrder: ");
        BTT.preOrderRecursion(root); out.println();
        BTT.preOrderNonRecursion(root); out.println();
        BTT.preOrderNonRecursion2(root); out.println();
        out.println("InOrder: ");
        BTT.inOrderRecursion(root); out.println();
        BTT.inOrderNonRecursion(root); out.println();
        out.println("PostOrder: ");
        BTT.postOrderRecursion(root); out.println();
        BTT.postOrderNonRecursion(root); out.println();
        BTT.postOrderNonRecursion2(root); out.println();
        out.println("FloorOrder");
        BTT.printByFloor(root); out.println();
        BTT.printByFloor2(root); out.println();
        BTT.printByFloor3(root); out.println();
        BTT.printByFloor4(root); out.println();
    }
}

class CreateBT<T> {
    TreeNode<T> createByPreOrder(LinkedList<T> list) {
        TreeNode<T> root = null;
        T val = list.removeFirst();
        if (val != null) {
            root = new TreeNode<>(val);
            root.left = createByPreOrder(list);
            root.right = createByPreOrder(list);
        }
        return root;
    }
}



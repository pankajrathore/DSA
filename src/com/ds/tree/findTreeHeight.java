package com.ds.tree;

import sun.lwawt.macosx.CSystemTray;

public class findTreeHeight {

    public static int findHeight(Node root)
    {

        if(root==null) return 0;
        return 1+Math.max(findHeight(root.left),findHeight(root.right));
    }

    public static void main(String[] args)
    {

        Node root=new Node(1);
        System.out.println(findHeight(root));

        root.left=new Node(2);
        root.right=new Node(3);
        System.out.println(findHeight(root));

        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println(findHeight(root));

        root.right.right.right=new Node(9);
        System.out.println(findHeight(root));

        root.right.right.right.left=new Node(10);
        System.out.println(findHeight(root));

        root.right.right.right.left.left=new Node(11);
        root.right.right.right.left.right=new Node(12);

         /*
             1
           2   3
          4 5 6 7
                  9
                10
               11 12
        */
        System.out.println(findHeight(root));
    }
}

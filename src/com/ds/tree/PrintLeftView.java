package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left, right;
    public Node(int i)
    {
        this.data=i;
        this.left=this.right=null;
    }
}


public class PrintLeftView {

    public static void main(String[] args)
    {
        Node root=new Node(1);

        root.left=new Node(2);
        root.right=new Node(3);

        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.left=new Node(6);
        root.right.right=new Node(7);
       //printLeftView(root);

        /*
             1
           2   3
          4 5 6 7
        */
        Node root1=new Node(1);
        root1.left=new Node(2);
        root1.right=new Node(3);
        root1.right.right=new Node(7);

        printLeftView(root1);

        /*
        *               1
        *              2  3
        *                  7
        *
        * */
        printRightView(root1);


    }

    private static void printLeftView(Node root) {
        /*
        * print root
        * check left tree at this level,
        *     if null then check right tree...
        *         print node go to next level
        * check
        *
        * */

        if(root==null)
            return;
        Queue<Node> queue=new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {

            int n=queue.size();
            for(int i=1;i<=n;i++)
            {
                Node temp=queue.poll();

                if(temp!=null) {

                    if(i==1)
                    System.out.println(temp.data);
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }
            }
        }


    }

    private static void printRightView(Node root) {
        /*
         * print root
         * check left tree at this level,
         *     if null then check right tree...
         *         print node go to next level
         * check
         *
         * */

        if(root==null)
            return;
        Queue<Node> queue=new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {

            int n=queue.size();
            for(int i=1;i<=n;i++)
            {
                Node temp=queue.poll();

                if(temp!=null) {

                    if(i==1)
                        System.out.println(temp.data);
                    if (temp.right != null)
                        queue.add(temp.right);
                    if (temp.left != null)
                        queue.add(temp.left);
                }
            }
        }


    }
}

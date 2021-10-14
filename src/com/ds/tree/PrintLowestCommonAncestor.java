package com.ds.tree;

public class PrintLowestCommonAncestor {
    public static Node lca(Node root, Node n1, Node n2)
    {
        if(root==null)
            return null;
        if(root.data ==n1.data || root.data ==n2.data)
            return root;
        Node left=lca(root.left,n1,n2);
        Node right=lca(root.right,n1,n2);
        if(left!=null && right!=null)
            return root;
        if(left==null && right==null)
            return null;
        return left!=null? left:right;
    }
    public static void main(String[] args)
    {
        /*                    3
        *              6             8
        *            2   11               13
        *               9  5            7
        * */

        Node root=new Node(3);

        root.left=new Node(6);

        root.left.left=new Node(2);
        root.left.right=new Node(11);

        root.left.right.left=new Node(9);
        root.left.right.right=new Node(5);

        root.right=new Node(8);
        root.right.right=new Node(13);
        root.right.right.left=new Node(7);

        Node lcaNode=lca(root,new Node(2), new Node(5));
        System.out.println("LCA of 2, 5 is "+lcaNode.data);

        Node lcaNode1=lca(root,new Node(8), new Node(11));
        System.out.println("LCA of 8, 11 is "+lcaNode1.data);

        Node lcaNode2=lca(root,new Node(8), new Node(7));
        System.out.println("LCA of 8, 7 is "+lcaNode2.data);

    }
}

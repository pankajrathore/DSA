package com.ds;


import java.util.Date;
import java.util.Stack;


public class CustomLinkedList {
    public static void main(String[] args) {
        System.out.println("Pankaj"+new Date());
        CustomLinkedList list=new CustomLinkedList();
        list.insert(list,1);

        list.insert(list,11);
       list.insert(list,21);
        list.insert(list,31);
        list.insert(list,41);
        list.insert(list,51);
        list.insert(list,61);

       // list=null;
        printList(list);
        //System.out.println(countNodes(list));

        CustomLinkedList revList=reverseList(list);
        printList(revList);

    }

    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data=d;
        }

    }
    // Method to insert a new node
    public static CustomLinkedList insert(CustomLinkedList list, int data)
    {

        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }

        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }
        return list;

    }

    // Method to print the LinkedList.
    public static void printList(CustomLinkedList list) {
        if(list == null) {
            System.out.println("List is null");
        }else{

            Node currentNode= list.head;
            if(currentNode ==null)
            {
                System.out.println("List is empty");
            }else
            {
                System.out.println("Elements in LinkedList-");
            }
            while(currentNode!=null)
            {
                System.out.println(currentNode.data);
                currentNode=currentNode.next;
            }
        }
    }

    // Method to delete a node in the LinkedList by KEY
    public static CustomLinkedList deleteByKey(CustomLinkedList list,
                                         int key)
    {
     Node currentNode=list.head;
     Node prev=null;
     //key is present in head node
     if(currentNode!=null && currentNode.data==key)
     {
         System.out.println(key + " found and deleted");

         list.head=currentNode.next;
         return list;
     }
     //key is not in head node but in other nodes -2nd, 3rd, 4th etc.
        //if key does not match we need to move to next node but keep previous node in memory
     while(currentNode!=null && currentNode.data!=key)
     {
             prev=currentNode;
             currentNode=currentNode.next;
      }
     //if key is present in currentNode, we are on target node, remove this
     if(currentNode!=null && currentNode.data==key)
     {
         prev.next=currentNode.next;
         System.out.println(key + " found and deleted");
     }
     //if we have reached to the last node & key is not found
        if (currentNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }
     return list;
    }

    public static int countNodes(CustomLinkedList list)
    {
        int count=0;
        if(list==null)
            return 0;
        if(list.head!=null)
        {
            count++;
            Node currentNode=list.head;

            while(currentNode.next!=null)
            {
                count++;
                currentNode=currentNode.next;
            }
        }

        return count;
    }

    public static CustomLinkedList reverseListWithStack(CustomLinkedList list)
    {
        if(list==null)
            return null;
        if(list.head!=null) {
            Stack<Node> st = new Stack<Node>();
            Node currentNode = list.head;
            st.push(currentNode);
            while (currentNode.next != null) {
                currentNode = currentNode.next;
                st.push(currentNode);
            }
            System.out.println("Stack Size="+st.size());
            list = new CustomLinkedList();
            if (st.isEmpty())
                return null;
            if (!st.isEmpty()) {
                Node head = st.pop();
                head.next = null;
                list.head = head;

            }
           Node currentNodeInNewList= list.head;
            while (!st.isEmpty())
            {
                Node nodefromStack = st.pop();
                Node newNode=new Node(nodefromStack.data);
                currentNodeInNewList.next=newNode;
                currentNodeInNewList=newNode;
            }
        }
        return list;

    }
    public static CustomLinkedList reverseList(CustomLinkedList list) {

        Node current=list.head;
        Node previous=null;
        Node next=null;
        while(current!=null)
        {
         next=current.next;
         current.next=previous;
         previous=current;
         list.head=previous;
         current=next;
        }
    return list;
    }
}


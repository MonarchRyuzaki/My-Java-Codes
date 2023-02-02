import java.util.LinkedList;

public class ArbitaryPointer {
    
    /* Link list node */
    static class Node
    {
        int data;
        Node next, arbit;
        
        Node(int data) 
        {
            this.data = data;
            next = null;
            arbit = null;
        }
    }
    
    static Node head;
    // Utility function to print result linked list
    static void printList(Node node, Node anode)
    {
        System.out.println("Traversal using Next Pointer");
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
  
        System.out.println("\nTraversal using Arbit Pointer");
        while (anode != null)
        {
            System.out.print(anode.data + " ");
            anode = anode.arbit;
        }
    }
    public static Node populateArbit(Node head){
        Node temp = head;
  
        // Copy next pointers to arbit pointers
        while (temp != null)
        {
            temp.arbit = temp.next;
            temp = temp.next;
        }
        return mergeSort(head);
    }
    public static Node midNode(Node head){
        Node slow = head;
        Node fast = head.arbit;
        while (fast!=null && fast.arbit!=null){
            fast = fast.arbit.arbit;
            slow = slow.arbit;
        }
        return slow;
    }
    public static Node mergeSort(Node head){
        if (head == null || head.arbit==null){
            return head;
        }

        //S-1 : Find the MidNode
        Node midNode = midNode(head);
        //S-2 : divide
        Node rightHead = midNode.arbit;
        midNode.arbit = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft,newRight);
    }
    public static Node merge(Node head1,Node head2){
        Node p = new Node(-1);
        Node t = p;
        while (head1!=null && head2!=null){
            if (head1.data < head2.data){
                t.arbit = head1;
                head1 = head1.arbit;
                t=t.arbit;
            } else {
                t.arbit = head2;
                head2 = head2.arbit;
                t=t.arbit;
            }
        }
        while (head1!=null){
            t.arbit = head1;
            head1 = head1.arbit;
            t=t.arbit;
        }
        while (head2!=null){
            t.arbit = head2;
            head2 = head2.arbit;
            t=t.arbit;
        }
        return p.arbit;
    }
    public static void main(String[] args)
    {
        ArbitaryPointer list = new ArbitaryPointer();
  
        /* Let us create the list shown above */
        list.head = new Node(5);
        list.head.next = new Node(10);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(3);
  
        /* Sort the above created Linked List */
        Node ahead = list.populateArbit(head);
        System.out.println("Result Linked List is:");
        list.printList(head, ahead);
    }
}

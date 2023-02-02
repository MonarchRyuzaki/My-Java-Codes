public class SegEvenOdd {
    static Node head; // head of list
 
    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static Node segregateEvenOdd(Node head){
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        Node end = temp;
        Node backupEnd = end;
        Node curr = head;
        Node newNode = new Node(-1);
        newNode.next = head;
        Node prev = newNode;
        Node after;
        // Node temp1 = head;
        // while (temp1!=null){
        //     temp1 = temp1.next;
        //     if (temp1.data%2 == 0){
        //         head = temp1;
        //         break;
        //     }
        // }
        while (curr!=backupEnd){
            if (curr.data%2==1){
                prev.next = curr.next;
                after = curr.next;
                end.next = curr;
                curr = after;
                end = end.next;
                end.next = null;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        if (curr.data%2==1){
            prev.next = curr.next;
            after = curr.next;
            end.next = curr;
            curr = after;
            end = end.next;
            end.next = null;
        } else {
            curr = curr.next;
            prev = prev.next;
        }
        return newNode.next;
    }
    public static void main(String[] args) {
        SegEvenOdd llist = new SegEvenOdd ();
        llist.push(99);
        llist.push(7);
        llist.push(1);
        //llist.push(4);
        llist.push(5);
        //llist.push(10);
        //llist.push(12);
        //llist.push(8);
        llist.push(15);
        //llist.push(16);
        //llist.push(12);

        System.out.println("Original Linked List");
        llist.printList(head);
 
        Node n = llist.segregateEvenOdd(head);
 
        System.out.println("Modified Linked List");
        llist.printList(n);
    }
}

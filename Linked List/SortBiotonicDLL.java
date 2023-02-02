public class SortBiotonicDLL {
    static public class Node {
        Node next;
        Node prev;
        int data;
    }

    // Function to insert a node at the beginning
    // of the Doubly Linked List
    static Node push(Node head_ref, int new_data)
    {
        // allocate node
        Node new_node = new Node();
 
        // put in the data
        new_node.data = new_data;
 
        // since we are adding at the beginning,
        // prev is always null
        new_node.prev = null;
 
        // link the old list of the new node
        new_node.next = (head_ref);
 
        // change prev of head node to new node
        if ((head_ref) != null)
            (head_ref).prev = new_node;
 
        // move the head to point to the new node
        (head_ref) = new_node;
        return head_ref;
    }
 
    // Function to print nodes in a given doubly
    // linked list
    static void printList(Node head)
    {
        // if list is empty
        if (head == null)
            System.out.println("Doubly Linked list empty");
 
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node before = null;
        Node after;
        while (curr!=null){
            after = curr.next;
            curr.next = before;
            curr.prev = after;
            before = curr;
            curr = after;
        }
        return before;
    }

    public static Node merge(Node head1,Node head2){
        Node p = new Node();
        push(p,-1);
        Node t = p;
        while (head1!=null && head2!=null){
            if (head1.data < head2.data){
                t.next = head1;
                head1 = head1.next;
                t=t.next;
            } else {
                t.next = head2;
                head2 = head2.next;
                t=t.next;
            }
        }
        while (head1!=null){
            t.next = head1;
            head1 = head1.next;
            t=t.next;
        }
        while (head2!=null){
            t.next = head2;
            head2 = head2.next;
            t=t.next;
        }
        return p.next;
    }

    public static Node sort(Node head){
        Node temp = head;
        Node endOf1st = null;
        while (temp.next!=null){
            
                if (temp.data > temp.next.data){
                    endOf1st = temp;
                    break;
                }
                temp = temp.next;
             
        }
        if (temp.next == null){
            return head;
        }
        Node begof2nd = endOf1st.next;
        endOf1st.next = null;
        begof2nd.prev = null;
        Node head2 = reverse(begof2nd);
        Node sorted = merge(head,head2);
        return sorted;
    }

    public static void main(String[] args) {
        Node head = null;
 
        // Create the doubly linked list:
        // 2<.5<.7<.12<.10<.6<.4<.1
        head = push(head, 1);
        head = push(head, 4);
        head = push(head, 6);
        head = push(head, 10);
        head = push(head, 12);
        head = push(head, 7);
        head = push(head, 5);
        head = push(head, 2);
 
        System.out.println("Original Doubly linked list:");
        printList(head);
 
        // sort the biotonic DLL
        head = sort(head);
 
        System.out.println(
            "\nDoubly linked list after sorting:");
        printList(head);
    }
}

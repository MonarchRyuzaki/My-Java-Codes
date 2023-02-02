public class ZigZagFashion {
    static class Node {
        int data;
        Node next;
    }
    static Node head = null;
    static int temp = 0;
    static void push(int new_data){
        /* allocate Node */
        Node new_Node = new Node();
 
        /* put in the data */
        new_Node.data = new_data;
 
        /* link the old list of the new Node */
        new_Node.next = (head);
 
        /* move the head to point to the new Node */
        (head) = new_Node;
    }
    static void printList(Node Node){
        while (Node != null) {
            System.out.print(Node.data + "->");
            Node = Node.next;
        }
        System.out.println("NULL");
    }
    public static void zigZagList(Node head){
        
        boolean flag = true;
        Node temp = head;
        while (temp!=null && temp.next != null){
            if (flag){
                if (temp.data>temp.next.data){
                    int x = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = x;
                }
            } else {
                if (temp.data<temp.next.data){
                    int x = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = x;
                }
            }
            temp = temp.next;
            flag = !flag;
        }
    }
    public static void main(String[] args){
        /* Start with the empty list */
        // Node head = null;
    
        // create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
        // answer should be -> 3 7 4 8 2 6 1
        push(1);
        push(2);
        push(6);
        push(8);
        push(7);
        push(3);
        push(4);
    
        System.out.println("Given linked list ");
        printList(head);
    
        zigZagList(head);
    
        System.out.println("Zig Zag Linked list ");
        printList(head);

    }
}
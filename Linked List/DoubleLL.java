public class DoubleLL {
    public class Node {
        Node next;
        Node prev;
        int data;
        public Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head = head.prev;
        size++;
    }

    //addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = tail = newNode;
            size++;
            return;
        }
        tail.next=newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
        return;
    }
    
    //removeFirst
    public int removeFirst(){
        if (head == null){
            System.out.println("Double LL is Empty");
            return -999;
        }
        if (head.next==null){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val = head.data;
        head= head.next;
        head.prev=null;
        size--;
        return val;
    }

    //removeLast
    public int removeLast(){
        if (head == null){
            System.out.println("Double LL is Empty");
            return -999;
        }
        if (head.next==null){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node temp = head;
        int i=1;
        while (i<size-1){
            temp=temp.next;
            i++;
        }
        int val = tail.data;
        temp.next=null;
        tail.prev=null;
        tail=temp;
        size--;
        return val;
    }
    public void print(){
        if (head==null){
            System.out.println("Double LL is Empty");
            return;
        }
        Node temp = head;
        System.out.print("null <-> ");
        while (temp!= null){
            System.out.print(temp.data+" <-> ");
            temp= temp.next;
        }
        System.out.println("null");
    }

    public void reverse(){
        if (head==null){
            System.out.println("Double LL is Empty");
            return;
        }
        Node curr = head;
        Node prev = null;
        Node after;
        while (curr!=null){
            after = curr.next;
            curr.next=prev;
            curr.prev=after;
            prev=curr;
            curr=after;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        //dll.print();
        // System.out.println(dll.removeFirst());
        // dll.print();
        dll.addLast(4);
        dll.print();
        //System.out.println(dll.removeLast());
        //dll.print();
        dll.reverse();
        dll.print();
    }
}

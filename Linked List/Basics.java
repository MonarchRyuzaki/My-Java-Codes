public class Basics {
    public static class Node {
        int data;
        Node next;
        Node (int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        size++;
        Node newNode = new Node(data);//s1 make new node
        if (head==null){ //base
            head=tail=newNode;
            return;
        }
        newNode.next=head;//s2 link new node with head
        head = newNode;//head = newNode
    }
    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
        if (head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void add(int index,int data)
    {
        if (index==0){
            addFirst(data);
            return;
        }
        size++;
        Node newNode = new Node(data);
        Node temp=head;
        int i=0;
        while (i<index-1){
            temp = temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int removeFirst(){
        int val = head.data;
        if (size==1){
            head = tail = null;
            size=0;
        }
        if (size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        int val = tail.data;
        if (size==1){
            head = tail = null;
            size=0;
        }
        if (size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        int i=0;
        Node prev = head;
        while (i<size-2){
            prev=prev.next;
            i++;
        }
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public int iterativeSearch(int key){
        Node temp = head;
        for (int i=0;i<size;i++){
            if (temp.data==key){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public boolean recSearch(int key,Node temp){
        if (temp==null){
            return false;
        }
        if (temp.data==key){
            return true;
        }
        return recSearch(key, temp.next);
    }
    public void reverse (){
        Node prev = null;
        Node curr = tail = head;
        Node after;
        while (curr!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        head = prev;
    }
    public void deleteNthNodefromEnd(int n){
        //calculating size
        int sz=0;
        Node temp = head;
        while (temp!=null){
            sz++;
            temp=temp.next;
        }
        if (n==sz){
            head = head.next;
            return;
        }
        int i=1;
        int itoFind = sz - n;
        Node prev = head;
        while (i<itoFind){
            prev = prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    //Slow-Fast Approach
    public Node midNode(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast!= null && fast.next!=null){
            slow=slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow;
    }
    public boolean checkPalindrome(){
        if (head==null || head.next==null){
            return true;
        }
        //S-1 : Find MidNode
        Node midNode = midNode(head);
        //S-2 : Reverse 2nd Part
        Node prev = null;
        Node curr = midNode;
        Node after;
        while (curr!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        Node right = prev;
        Node left = head;
        //S-3 : Check if Left Part and Right Part are Equal
        while (right!=null){
            if (left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static boolean checkCycle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!=null || fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(Node head){
        //Detect Cycle
        boolean c;
        Node slow = head;
        Node fast = head;
        while (fast!=null || fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                c= true;
            }
        }
        c=false;
        //lastnode.next=null;
        if (c==true){
            Node prev = fast ;
            while (slow!=fast){
                slow=slow.next;
                prev = fast;
                fast=fast.next;
            }
            prev.next=null;
        }
        else {
            System.out.println("Not a Loop LL");
        }
    }
    public Node merge (Node head1 , Node head2){
        Node mergeLL = new Node (-1);
        Node temp = mergeLL;
        while (head1 != null && head2!= null){
            if (head1.data <=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp = temp.next;
            } else {
                temp.next=head2;
                head2=head2.next;
                temp = temp.next;
            }
        }
        while (head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp = temp.next;
        }
        while (head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }    
    public Node mergeSort (Node head){
        if(head == null || head.next == null) {
            return head;
        }

        //find mid
        Node mid = midNode(head);        
        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }
    public void zigzag(Node head){
        //S-1  Get MidNode
        Node mid = midNode(head);
        //S-2  2nd Half Reverse
        Node prev = null;
        Node curr = mid.next;
        mid.next=null;
        Node after;
        while (curr!=null){
            after = curr.next;
            curr.next=prev;
            prev = curr;
            curr=after;
        }
        Node RH = prev;
        Node LH = head;
        Node nextLH;
        Node nextRH;
        while (LH!=null && RH!= null){
            nextLH = LH.next;
            LH.next = RH;
            nextRH = RH.next;
            RH.next = nextLH;
            LH=nextLH;
            RH=nextRH;
        }
    }
    public static void main(String[] args) {
        Basics ll = new Basics();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        //5->4->3->2->1->null
        ll.print();
        ll.zigzag(head);
        ll.print();
    }
}
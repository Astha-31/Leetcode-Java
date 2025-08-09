
class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data1, Node next1, Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLL {


    private static Node converta2ll(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1; i < arr.length; i++){
            Node n = new Node(arr[i]);
            n.prev = prev;
            prev.next = n;
            prev = n;
        }
        return head;
    }
    
    private static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }    

    private static Node deletehead(Node head){
        
        if(head == null || head.next == null){
            return null;
        } 
        head = head.next;
        head.prev = null;
       
        return head;
    }

    private static Node deletetail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }

    private static Node deletekthel(Node head, int k){
        if(head == null || k < 0){
            return head;
        }
        int c = 0;
        Node temp = head;
        while(temp != null){
            c++;
            if(c == k){
                break;
            }
            temp = temp.next;
        }
        if(temp == null){
            return head;        
        }
        Node previous = temp.prev;
        Node front = temp.next;
        if(previous == null && front == null){
           return null;
        }
        else if(previous == null){
            return deletehead(head);
        }
        else if(front == null){
           return deletetail(head);
        }
        

        previous.next = front;
        front.prev = previous;
        temp.next = null;
        temp.prev = null;

        return head;
    }

    private static void deletenode(Node temp){
        if(temp == null){
            return;
        }

        Node previous = temp.prev;
        Node front = temp.next;

        if(front == null){
            previous.next = null;
            temp.prev = null;
            return;
        }

        previous.next = front;
        front.prev = previous;
        temp.next = null;
        temp.prev = null;
    }

    private static Node insertbefHead(Node head, int element){
        Node newnode = new Node(element, head, null);
        head.prev = newnode;
        return newnode;
        
    }

    private static Node  insertbeftail(Node head,int element){
        if(head.next == null){
            return insertbefHead(head, element);
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node previous = temp.prev;
        Node newNode = new Node(element, temp, previous);
        previous.next = newNode;
        temp.prev = newNode;
        return head;

    }

    private static Node insertbefk(Node head, int k , int element){
        if(k == 1){
            return insertbefHead(head, element);
        }
        int c = 0;
        Node temp = head;
        while(temp.next != null){
            c++;
            if(c == k){
                break;
            }
            temp = temp.next;
        }

        Node previous = temp.prev;
        Node n = new Node(element, temp, previous);
        temp.prev = n;
        previous.next = n;
        return head;
    }

     private static void insertbefnode(Node temp, int val){
        Node previous = temp.prev;
        Node n = new Node(val, temp, previous);
        previous.next = n;
        temp.prev = n;
    }
    public static void main(String[] args){
        int[] arr = {2, 1, 4, 5, 6, 7};

        Node head = converta2ll(arr);

        head = deletehead(head);

        head = deletetail(head);

        head = deletekthel(head, 6);
        deletenode(head.next.next.next.next);
        head = insertbefHead(head, 10);

        head = insertbeftail(head, 12);

        head = insertbefk(head, 3, 8);

        insertbefnode(head.next.next, 100);
        print(head);

        
    }
}

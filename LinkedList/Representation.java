
class Node{
    int data;
    Node next;
    public Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class Representation {

    private static Node array2LL(int arr[]){
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < n; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    private static Node deletehead(Node head){
        if(head == null) return head;
        head = head.next;
        return head;
    }

    private static Node deletetail(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    private static Node deleteatk(Node head, int k){
        if(head == null){
            return head;
        }
        if(k == 1){
            head = head.next;
            return head;
        }

        int c = 0; 
        Node prev = null;
        Node temp = head;
        while(temp != null){
            c++;
            if(c == k){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node deleteValue(Node head, int k){
        if(head == null){
            return head;
        }
        if(k == head.data){
            head = head.next;
            return head;
        }

        Node prev = null;
        Node temp = head;
        while(temp != null){
            if( temp.data == k){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node inserthead(Node head, int val){
        Node temp = new Node(val, head);
        return temp;
    }

    private static Node insertattail(Node head, int val){
        if(head == null){
            return new Node(val);
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node y = new Node(val);
        temp.next = y;
        return head;
    }

    private static Node insertatk(Node head, int val , int k){
        if(head == null){
            if(k == 1){
                Node temp = new Node(val);
                return temp;
            }else{
                return null;
            }
        }
        if(k == 1){
            Node y = new Node(val, head);
            return y;
        }

        int c = 0;
        Node temp = head;
        while(temp != null){
            c++;
            if(c == k - 1){
                Node y = new Node(val);
                y.next = temp.next;
                temp.next = y;
                break;
            }
            temp  = temp.next;
        }
        return head;
    }

    private static Node insertbeforek(Node head, int val , int k){
        if(head == null){
            return null;
        }
        if(head.data == k){
            Node y = new Node(val, head);
            return y;
        }

        Node temp = head;
        while(temp.next != null){
    
            if(temp.next.data == k){
                Node y = new Node(val);
                y.next = temp.next;
                temp.next = y;
                break;
            }
            temp  = temp.next;
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
    
    public static void main(String[] args){
        int[] arr = {2, 1, 4, 5, 6, 7};
        Node y = new Node(arr[3]);
        System.out.println(y.data);
        Node head = array2LL(arr);
        System.out.println(head.data);
      
        // Traversal
        head = deletehead(head);

        head = deletetail(head);

        head = deleteatk(head, 4);

        head = deleteValue(head, 6);

        head = inserthead(head, 10);

        head = insertattail(head, 20);

        head = insertatk(head, 15, 1);

        head = insertbeforek(head, 10, 5);

        print(head);


        
    }
}

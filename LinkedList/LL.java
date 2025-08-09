class Node{
    int data;
    Node next;
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class LL{

    private static Node a2ll(int[] arr){
        Node head = new Node(arr[0]);
        int n = arr.length;
        Node temp = head;
        for(int i = 1; i < n; i++){
            Node t = new Node(arr[i]);
            temp.next = t;
            temp = t;
        }
        return head;
    }

    private static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node deleteHead(Node head){
        if(head == null) return head;
        return head.next;
    }

    private static Node deleteTail(Node head){
        Node temp = head;
        if(head == null || head.next == null) return null;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node deletek(Node head, int k){
        if(head == null) return head;
        if(k == 1) return head.next;
        Node temp = head;
        Node prev = null;
        int c = 0;
        while(temp != null){
            c++;
            if(c == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node deleteele(Node head, int k){
        if(head == null) return head;
        if(head.data == k) return head.next;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            
            if(temp.data == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node insertTail(Node head, int k){
        if(head == null ) return new Node(k);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(k);
        return head;
    }
    private static Node insertAtHead(Node head, int x){
        return new Node(x, head);
    }

    private static Node insertatk(Node head,int k,int data ){
        if(head == null){
            if(k == 1) return new Node(data);
            else 
            System.out.println("not possible");
        }
        Node temp = head;
        int c = 0;
        while(temp != null){
            c++;
            if(c == k - 1){
                Node n = new Node(data, temp.next);
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertbefValue(Node head, int k, int data){
        if(head == null)return null;
        if(head.data == k) return new Node(data, head);
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == k){
                Node n = new Node(data,temp.next);
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {2};
        Node head = a2ll(arr);
        // System.out.println(head.data);
        print(head);
        head = deleteHead(head);
        // head = deleteele(head, 1);
        print(head);

        // head = insertAtHead(head, 10);
        // head = insertTail(head, 18);
        // print(head);
        head = insertatk(head, 1, 12);
        print(head);
        head = insertbefValue(head, 12, 10);
        print(head);
    }
}
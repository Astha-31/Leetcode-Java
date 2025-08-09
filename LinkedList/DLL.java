class Node{
    int data;
    Node prev;
    Node next;
    public Node(int data , Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
        this.prev = null;
    }
    public Node(int data){
    this.data = data;
    this.prev = null;
    this.next = null;
    }
}


public class DLL {

    private static Node a2dll(int[] arr){
        Node head = new Node(arr[0]);
        int n = arr.length;
        Node previous = head;
        for(int i = 1; i < n; i++){
            Node k = new Node(arr[i]);
            k.prev = previous;
            previous.next = k;
            previous = k;

        }
        return head;
    }

    private static Node deleteHead(Node head){
        if(head ==null || head.next == null)return null;
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    }

    private static Node deleteTail(Node head){
        if(head == null || head.next == null)return null;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node previous = temp.prev;
        previous.next = null;
        temp.prev = null;
        return head;
    }

    private static Node removekthele(Node head, int k){
        if(head == null) return null;
        int c = 0;
        Node temp = head;
        
        while(temp != null){
            c++;
            if( c== k){ 
                break;
            }
            temp = temp.next;
        }
        Node previous = temp.prev;
        Node front = temp.next;

        if(previous == null && front == null){
                return null;
        }
        if(previous == null ) return deleteHead(head);
        if(front == null) return deleteTail(head);
        previous.next = temp.next;
        front.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        return head;

    }

    private static void deleteNode(Node n){
        Node previous = n.prev;
        Node front = n.next;
        if(front == null){
            previous.next = null;
            n.prev = null;
        }
        previous.next = front;
        front.prev = previous;
        n.next = null;
        n.prev = null;
    }

    private static Node insertHead(Node head, int data){
        Node n = new Node(data, head, null);
        head.prev = n;
        return n;
    }

    private static Node insertTail(Node head, int data){
        if(head.next == null){
            return insertHead(head, data);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node previous = temp.prev;
        Node n = new Node(data, temp, previous);
        previous.next = n;
        temp.prev = n;
        return head;
    }
    private static Node insertBefK(Node head, int k, int data){
        if(k == 1) return insertHead(head, data);
        Node temp = head;
        int c = 0;
        while(temp != null){
            c++;
            if(c == k){
                break;
            }
            temp = temp.next;
        }
        Node previous = temp.prev;
        Node front = temp.next;
        Node n = new Node(data, temp, previous);
        previous.next = n;
        front.prev = n;
        return head;
    }

    private static void insertbefNode(Node node,int data){
        Node previous = node.prev;
        Node n = new Node(data, node, previous);
        previous.next = n;
        node.prev = n;
    }
    private static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node last = null;
        Node temp = head;
        while(temp != null){
            last = temp.prev;
            temp.prev = temp.next;
            temp.next = last;

            temp = temp.prev;
        }
        return last.prev;

    }
    private static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4, 5};
        Node head = a2dll(arr);
        print(head);
        // head = deleteHead(head);
        // print(head);
        // head = deleteTail(head);
        // print(head);
        // head = removekthele(head, 2);
        // print(head);
        // deleteNode(head.next);
        // print(head);
        // head = insertHead(head, 20);
        // print(head);
        // head = insertTail(head, 30);
        // print(head);
        // head = insertBefK(head, 3, 45);
        // print(head);
        // insertbefNode(head.next.next, 78);
        // print(head);
        head = reverse(head);
        print(head);
    }
}

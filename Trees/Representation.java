class Node{
    int key;
    Node left;
    Node right;

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

}

public class Representation{

    private static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.key);
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }

    private static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.key);
    }

    
    public static void main(String[] args){
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(9);
        // preorder(root);
        // inorder(root);
        postorder(root);
    }
}

class Basic{

    private static void printName(int c, int n){
        if(c > n) return;

        System.out.println("Astha");
        printName(c + 1, n);
    }
    public static void main(String[] args){
        System.out.println("Code to print name n time");
        printName(1,5);
    }
}
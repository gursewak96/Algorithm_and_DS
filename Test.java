

public class Test {
    int x;

    public static void main(String [] args){
        int[][] x = new int[2][];
        System.out.println(x[0]);
        Test t = new Test();
       t.method();
    }
    public void method(){
        System.out.println(x);
    }
}
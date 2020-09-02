package NumberAndCounting;

public class Prime {
    public static boolean isPrime(int N){
        if(N<=1) return false;
        if(N==2) return true;

        for(int i = 3; i<Math.sqrt(N); i+=2){
            if(N%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        
        System.out.println(isPrime(23));
    }
}
package recursion;

/**
 * Identifying if the given number N is power of certain number n
 * we can use recursion.
 */

public class PowerOfN {
    public static void main(String[] args) {
        int n = 64;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n){
        if (n == 1) return true; // this is base case as any n^0 = 1
        if (n == 0 || n%4 !=0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }
}

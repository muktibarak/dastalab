package recursion;

/**
 * Recursion: method is called by the method itself.
 * if a problem can be broken down into many small repeated pieces or subproblems,
 * recursion can be implemented.
 *
 * in the give example below, calculateFactorial(int n) is a method which calls
 * itself to calculate factorial of given integer n. Factorial for 5 = 5 * 4 * 3 * 2 * 1
 * = 120. When the method calculates factorial for given integer n, each time it calls the method,
 * integer below n (which is n - 1) will be multiplied by the momentary n.
 * The formula for n factorial is n! = n × (n - 1)! .
 * In mathematics, factorial of given integer n is written as n!
 * For example, factorial seven is written 7!, meaning 1 × 2 × 3 × 4 × 5 × 6 × 7.
 *
 */

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int factorial = calculateFactorial(n);
        System.out.println("factorial calculate for " + n + " is = " + factorial);
    }

    public static int calculateFactorial(int n){
        if(n == 0){ // base case
            return 1;
        } else {
            return n * calculateFactorial(n - 1); // prints 120
        }
    }
}

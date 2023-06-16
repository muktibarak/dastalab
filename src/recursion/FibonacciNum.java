package recursion;

/**
 * Fibonacci is a sequential number where each number is the sum of the
 * two preceding ones. 0 and 1 are default fibonacci number.
 * Simple naive approach described in the recursive method fib(int n) is
 * only good for small numbers. Time complexity would increase with large
 * sequence indices such as finding 50th fibonacci sequence.
 * To deal with the time complexity of large fibonacci sequence,
 * iterative approach like memoization can be applied as mentioned in
 * fibMemo(int n) method.
 *
 * With memoization following happens:
 * The loop starts from index 2 and iterates up to n.
 * In each iteration, it calculates the Fibonacci number at the current index
 * by adding the previous two Fibonacci numbers.
 * The loop continues until it reaches index n, and the final Fibonacci number is returned.
 */
public class FibonacciNum {

    public static void main(String[] args) {
        int fibNum = 50;
//        System.out.println(fib(fibNum));
        System.out.println(fibMemo(50));
    }
/*
    fib method is not efficient for large index
 */
    public static int fib(int n){
        int fibNum = 0;
        if (n <= 1) return n;
        fibNum = fib(n - 1) + fib(n - 2);
        return fibNum;
    }
/*
 fibMemo method applies memoization which reduces time complexity of the calculation
 for large numbers.
 */
    public static long fibMemo(int n){
        if(n <= 1) return n;

        long fibAtIndexMinusTwo = 0;
        long fibAtIndexMinusOne = 1;
        long fibonacciNumber = 0;
        for (int i = 2; i <= n; i++){
            fibonacciNumber = fibAtIndexMinusTwo + fibAtIndexMinusOne;
            fibAtIndexMinusTwo = fibAtIndexMinusOne;
            fibAtIndexMinusOne = fibonacciNumber;
        }
        return fibonacciNumber;
    }

}

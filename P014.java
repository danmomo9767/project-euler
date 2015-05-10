public class P014 {
    public static void main(String[] args) {
        int[] collatzLength;  // store the length of collatz chain of each number
        int longestChain;  // length of longest collatz squence
        int n;  // the number producing the longest collatz squence
        int i;

        int bound = (int) 1e6;
        collatzLength = new int[bound + 1];
        for (i = 0; i < bound; i++)
            collatzLength[i] = -1;
        collatzLength[1] = 1;
        n = 1;
        longestChain = 0;
        for (i = 2; i < bound; i++) {
            if (collatz(i, collatzLength) > longestChain) {
                n = i;
                longestChain = collatz(i, collatzLength);
            }
        }
        System.out.print(n);
    }

    /**
     * Return the length of collatz chain of n.
     * @param n the number
     * @param collatzLength the caching of the length of collatz chain of each number.
     */
    private static int collatz(long n, int[] collatzLength) {
        // not use caching
        if (n >= collatzLength.length - 1) {
            if (n % 2 == 0)
                return 1 + collatz(n/2, collatzLength);
            else
                return 1 + collatz(3*n + 1, collatzLength);
        }

        int i = (int) n;
        // use caching
        if (collatzLength[i] == -1) {
            if (i % 2 == 0)
                collatzLength[i] = 1 + collatz(i/2, collatzLength);
            else
                collatzLength[i] = 1 + collatz(3*i + 1, collatzLength);
        }
        return collatzLength[i];
    }
}

public class P003 {
    public static void main(String args[]) {
        int[] primes;
        long n;
        n = 600851475143L;
        System.out.println(largestPrimeFactor(n));
    }

    /**
     * Find the largest prime factor of n
     * @param n the numer
     */
    public static int largestPrimeFactor(long n) {
        int largestFactor;
        int factor;

        factor = 1;
        largestFactor = factor;
        if (n % 2 == 0) {
            largestFactor = 2;
            while (n % 2 == 0)
                n /= 2;
        }

        factor = 3;
        while (n > 1 && factor <= Math.sqrt(n)) {
            if (n % factor == 0) {
                largestFactor = factor;
                while (n % factor == 0)
                    n /= factor;
            }
            factor += 2;
        }
        if (n != 1) largestFactor = (int) n;
        return largestFactor;
    }

}

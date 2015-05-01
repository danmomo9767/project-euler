public class P010 {
    public static void main(String[] args) {
        int n;

        n = (int) 2e6;
        System.out.println(sumOfPrimes(n));
    }

    /**
     * Find the sum of prime numbers which are less than n
     * @param n the numer
     */
    public static long sumOfPrimes(int n) {
        boolean[] isPrime;
        long sum;

        isPrime = new boolean[n];
        for (int i = 0; i < n; i++)
            isPrime[i] = true;

        isPrime[0] = false;
        isPrime[1] = false;
        int p = 2;
        sum = 0;
        while (p < n) {
            sum += p;
            for (int i = 2*p; i < n; i += p)
                isPrime[i] = false;

            while (++p < n && !isPrime[p])
                ;
        }

        return sum;
    }
}

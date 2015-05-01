/******************************************************************************
 * According to the prime number theorem, nth prime number p_n statisfies
 *                p_n ~ nln(n)
 *****************************************************************************/
public class P007 {
    public static void main(String[] args) {
        int n;

        n = 10001;
        System.out.print(nthPrime(n));
    }

    /**
     * Find the nth prime number
     * @param n
     */
    public static int nthPrime(int n) {
        boolean[] isPrime;
        int length;
        int totalPrimes;

        length = (int) (1.2 * Math.ceil(n * Math.log(n)));
        totalPrimes = 0;
        isPrime = new boolean[length];
        for (int i = 0; i < length; i++)
            isPrime[i] = true;

        isPrime[0] = false;
        isPrime[1] = false;
        int p = 2;
        while (p < length) {
            totalPrimes++;
            if (totalPrimes == n)
                return p;

            for (int i = 2*p; i < length; i += p)
                isPrime[i] = false;

            while (++p < length && !isPrime[p])
                ;
        }
        return p;
    }

}

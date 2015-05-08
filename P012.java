/******************************************************************************
 * Tn = n(n+1)/2
 * If n is odd, number of divisors of Tn equals nd of (n+1)/2 plus nd of n.
 * Otherwise, nd of Tn = nd of n/2 + nd of n+1.
 *****************************************************************************/
import java.util.*;

public class P012 {
    public static void main(String[] args) {
        int n, m;
        int i;
        int tn;
        int nDivisorsOfTn;
        int lowerBound;
        ArrayList<Integer> nDivisors;  // number of divisors of i

        lowerBound = 500;
        nDivisors = new ArrayList<>();
        nDivisors.add(0);
        nDivisors.add(1);
        nDivisors.add(2);
        tn = 1;
        nDivisorsOfTn = 1;
        i = 1;
        while (nDivisorsOfTn <= lowerBound) {
            if (i % 2 == 0) {
                n = i + 1;
                m = i / 2;
            }
            else {
                n = i;
                m = (i + 1) / 2;
            }
            tn = n * m;
            if (n - 1 > nDivisors.size() - 1)
                nDivisors.add(numberOfDivisors(n-1));
            if (n > nDivisors.size() - 1)
                nDivisors.add(numberOfDivisors(n));
            nDivisorsOfTn = nDivisors.get(n) * nDivisors.get(m);
            i++;
        }
        System.out.println(tn);
    }

    /**
     * Find the number divisors of n
     * @param n the numer
     */
    public static int numberOfDivisors(long n) {
        int nDivisors;
        int primeFactor;
        int nPrimeFactor;  // how many prime factor p n contains

        nDivisors = 1;
        primeFactor = 2;
        nPrimeFactor = 0;
        while (n % primeFactor == 0) {
            n /= primeFactor;
            nPrimeFactor++;
        }
        nDivisors *= nPrimeFactor + 1;

        primeFactor = 3;
        while (n > 1 && primeFactor <= Math.sqrt(n)) {
            nPrimeFactor = 0;
            while (n % primeFactor == 0) {
                n /= primeFactor;
                nPrimeFactor++;
            }
            nDivisors *= nPrimeFactor + 1;
            primeFactor += 2;
        }
        if (n != 1) nDivisors *= 2;
        return nDivisors;
    }

}

/******************************************************************************
 * sum of 3 and 5 = sum of 3 + sum of 5 - sum of 15
 ******************************************************************************/
public class P001 {
    public static void main(String args[]) {
        System.out.println(sumOfMultiple(1000, 3) + sumOfMultiple(1000, 5)
                           - sumOfMultiple(1000, 15));
    }

    /**
     * Sum of all the multiples of m in [0, a)
     * @param a the upper bound of the range
     * @param b the base number
     */
    public static int sumOfMultiple(int a, int b) {
        int n;  // the number of multiples
        n = (a - 1) / b;
        return n * (b + n*b) / 2;
    }
}

/*****************************************************************************
 * Euclid's formula(m < n),
 *                  a = m^2 - n^2,
 *                  b = 2mn,
 *                  c = m^2 + n^2.
 *****************************************************************************/
public class P009 {
    public static void main(String[] args) {
        int a, b, c;
        int m, n;
        int sum;  // sum = a + b + c = 2m(m+n)
        int upper;  // m < sqrt(sum/2)

        sum = 1000;
        upper = (int) Math.floor(Math.sqrt(sum/2));
        for (m = upper; m >= 1; m--) {
            for (n = m - 1; n >= 1; n--) {
                a = m*m - n*n;
                b = 2*m*n;
                c = m*m + n*n;
                if (a + b + c == sum) {
                    System.out.println(a*b*c);
                    return;
                }
            }
        }
    }
}

/******************************************************************************
 * A palindromic number, n,  made from the product of two 3-digit numbers must be
 * the form of
 *             1100a+10010b+100001c = 11(100a + 910b + 9091c) (1).
 * Let n = x1 * x2, 100<=x1<=999, 100<=x2<=999. From (1), we know that at least
 * one of x1 and x2 must be multiples of 11. So let x1 = 11*p, 10<=p<=90.
 ******************************************************************************/
public class P004 {
    public static void main(String[] args) {
        int m;  // m = n / 11
        int a, b, c;
        int x1, x2, p;

        for (c = 9; c >= 0; c--) {
            for (b = 9; b >= 0; b--) {
                for (a = 9; a >= 0; a--) {
                    m = 100*a + 910*b + 9091*c;
                    for (p = 10; p <= 90; p++) {
                        if (m % p == 0) {
                            x1 = 11*p;
                            x2 = m / p;
                            if (x2 >= 100 && x2 <= 999) {
                                System.out.format("%d = %d * %d", x1*x2, x1, x2);
                                return ;
                            }
                        }
                    }
                }
            }
        }
    }
}

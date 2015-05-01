/******************************************************************************
 * Observing that fibonacci series goes with one even number
 * after two odd number, we can skip checking even/odd.
 * Let x, y be two adjacent odd numbers in the series and
 * we get ..., x, y, x+y, x+2y, 2x+3y, ....
 ******************************************************************************/
public class P002 {
    public static void main(String[] args) {
        int x, y, z, sum;
        x = 1;
        y = 1;
        z = x + y;
        sum = 0;
        while (z <= 4e6) {
            sum += z;

            z = x + 2*y;
            y = 2*x + 3*y;
            x = z;

            z = x + y;
        }
        System.out.println(sum);
    }
}

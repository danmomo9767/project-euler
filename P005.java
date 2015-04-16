/******************************************************************************
 * least common multiple = multiple / greatest common divisor.
 *****************************************************************************/
public class P005 {
    public static void main(String args[]) {
        int lcm = 1;
        for (int i = 2; i < 20; i++)
            lcm = lcm * i / gcd(lcm, i);
        System.out.println(lcm);
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else if (a < b)
            return gcd(b, a);
        else
            return gcd(b, a % b);
    }
}

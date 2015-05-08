import java.util.*;
import java.io.*;

public class P013 {
    public static void main(String[] args) {
        int m, n;
        int i, j;
        int[][] numbers;
        int sum, carray;
        ArrayDeque<Integer> tenDigits;

        m = 50;
        n = 100;
        numbers = readNumbers(m, n, new File("P013.in"));
        assert(numbers != null);

        tenDigits = new ArrayDeque<>(10);
        carray = 0;
        for (i = 0; i < m; i++) {
            sum = carray;
            // add up all digits in ones, all digits in tens, and so on.
            for (j = 0; j < 100; j++)
                sum += numbers[i][j];
            carray = sum / 10;

            if (tenDigits.size() >= 10)
                tenDigits.removeLast();
            tenDigits.addFirst(sum % 10);
        }
        while (carray > 0) {
            tenDigits.removeLast();
            tenDigits.addFirst(carray % 10);
            carray /= 10;
        }
        for (int d : tenDigits)
            System.out.print(d);
    }

    /****
     * Read numbers from P013.in into a m * n array
     * The digits in ones of jth number store in (m_1, n_j) and
     * the digits in tens of jth number store in (m_2, n_j), ...
     **/
    private static int[][] readNumbers(int m, int n, File file) {
        int i, j;
        int c;
        int[][] numbers;

        numbers = new int[m][n];
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                numbers[i][j] = 0;

        try {
            Scanner sc = new Scanner(file).useDelimiter("");
            j = 0;
            while (sc.hasNext()) {
                i = m - 1;
                while (sc.hasNextInt())
                    numbers[i--][j] = sc.nextInt();
                sc.nextLine();
                j++;
            }
        }
        catch (IOException e) {
            System.err.println("Cannot open " + file);
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Input size don't match");
            numbers = null;
        }
        return numbers;
    }
}

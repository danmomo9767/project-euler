import java.io.*;
import java.util.*;

public class P008 {
    public static void main(String[] args) {
        int[] numbers;
        int length;  // the max length of adjacent digits
        long product;
        long maxProduct;  // maximum product

        length = 13;
        numbers = readDigits();

        product = 1;
        maxProduct = product;
        Queue<Integer> q = new ArrayDeque<Integer>(length);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {  // this sequence of numbers contains zero
                product = 1;
                q.clear();
            }
            else if (q.size() < length) {  // length of the sequence is less than max length
                product *= numbers[i];
                q.add(numbers[i]);
            }
            else {
                product = product / q.remove() * numbers[i];
                q.add(numbers[i]);
                if (product > maxProduct)
                    maxProduct = product;
            }
        }
        System.out.println(maxProduct);
    }

    private static int[] readDigits() {
        int c;
        int i;
        int[] numbers;
        numbers = new int[1000];
        for (i = 0; i < 1000; i++)
            numbers[i] = 0;

        try {
            Scanner sc = new Scanner(new File("1000-digit")).useDelimiter("");
            i = 0;
            while (sc.hasNext()) {
                while (sc.hasNextInt())
                    numbers[i++] = sc.nextInt();
                sc.nextLine();
            }
        }
        catch (IOException e) {
            System.err.println("Cannot open " + "1000-digit");
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Input size don't match");
            numbers = null;
        }
        return numbers;
    }
}

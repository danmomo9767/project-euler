public class P006 {
    public static void main(String[] args) {
        int n;
        int sumOfSquare, squareOfSum;

        n = 100;
        sumOfSquare = n * (n + 1) * (2*n + 1) / 6;
        squareOfSum = n*n*(n+1)*(n+1) / 4;
        System.out.println(squareOfSum - sumOfSquare);
    }
}

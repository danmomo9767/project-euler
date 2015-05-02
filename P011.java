/*****************************************************************************
 *                 (i, j)----(i, j+k)
 *                /  |   \
 *               /   |    \
 *              /    |     \
 *             /     |      \
 *    (i+k, j-k)  (i+k, j) (i+k, j+k)
 *****************************************************************************/
import java.io.*;
import java.util.*;

public class P011 {
    public static void main(String[] args) throws IOException {
        int m;  // number of rows
        int n;  // number of columns
        int[][] grid;
        int length;  // length of adjacent numbers
        long rowProduct, columnProduct, rightDiagProduct, leftDiagProduct;
        long maxProduct;
        int i, j, k;

        m = 20;
        n = 20;
        length = 4;
        Scanner sc = new Scanner(new File("20by20-grid"));
        grid = new int[m][n];
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++) {
                if (sc.hasNextInt())
                    grid[i][j] = sc.nextInt();
                else
                    grid[i][j] = 0;
            }

        maxProduct = 0;
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++) {
                if (i < m - length + 1 && j >= length - 1) {
                    leftDiagProduct = grid[i][j];
                    for (k = 1; k < length; k++)
                        leftDiagProduct *= grid[i+k][j-k];
                    if (leftDiagProduct > maxProduct)
                        maxProduct = leftDiagProduct;
                }

                if (i < m - length + 1 && j < n - length + 1) {
                    rightDiagProduct = grid[i][j];
                    for (k = 1; k < length; k++)
                        rightDiagProduct *= grid[i+k][j+k];
                    if (rightDiagProduct > maxProduct)
                        maxProduct = rightDiagProduct;

                }
                else if (i < m - length + 1) {
                    columnProduct = grid[i][j];
                    for (k = 1; k < length; k++)
                        columnProduct *= grid[i+k][j];
                    if (columnProduct > maxProduct)
                        maxProduct = columnProduct;
                }
                else if (j < n - length + 1) {
                    rowProduct = grid[i][j];
                    for (k = 1; k < length; k++)
                        rowProduct *= grid[i][j+k];
                    if (rowProduct > maxProduct)
                        maxProduct = rowProduct;
                }
            }

        System.out.println(maxProduct);
    }
}

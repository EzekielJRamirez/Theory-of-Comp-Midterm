import java.util.Arrays;
import java.util.*;

/**
 * this will generalize functions for matrix of n x n size
 * using recursion
 * <p>
 * base case of values will be numerical order increasing
 * from 0
 * <p>
 * Arrays are immutable, this means that once their size is
 * set they won't be able to change their dimension
 * afterwards
 */

public class Square {
    public static void main(String[] args) {
        int nxn = 4;
        double[][] matA = new double[nxn][nxn];
//        System.out.println();

        Random rand = new Random();

        for (int r = 0; r < nxn; r++) {
            //fill rows of matrix
            for (int c = 0; c < nxn; c++) {
                //BASE CASE VALUES
                matA[r][c] = (r * nxn) + c;

                //RANDOM ASSIGNMENT
                //fill cols of matrix in current row
                //the range defined by rand is from 0 to .nextInt(VALUE) - 1
//                matA[r][c] = rand.nextInt(nxn * 2 + 1);
            }
        }

        for (int i = 0; i < nxn; i++) {
            System.out.println(Arrays.toString(matA[i]));
//        for debug purpose
        }

        rec(nxn, matA);
    }

    public static double rec(int n, double[][] matRec) {
        // in theory the matrix should never go down to a 1 x 1 cell size
        if (n == 2) {
            //now I should solve for a 2x2 matrix and return that determinant
            double det = matRec[0][0] * matRec[1][1] - matRec[0][1] * matRec[1][0];
            System.out.println(det);
            return det;
        }
        n--;
        // build matrix after decrementing size of n
        double[][] matrix = new double[n][n];

        System.out.println(n);


        //now fill the new matrix with correct values

        for(int r = 0; r < n; r++) {    //row
            for (int c = 0; c < n; c++) {   //col
                //adding 1 to row of matRec causes submatrix to come from lower rows
                //adding 1 to col of matRec makes submatrix from later columns
                // basically adding 1 moves the submatrix one down or one right
                matrix[r][c] = matRec[r + 1][c + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println();

        rec(n, matrix);
        return 0;
    }
}

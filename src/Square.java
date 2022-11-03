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
 * <p>
 * REFERENCES
 * https://www.educative.io/answers/how-to-generate-random-numbers-in-java
 * https://www.javatpoint.com/add-elements-to-array-in-java#:~:text=In%20Java%2C%20Arrays%20are%20mutable,a%20new%20element%20in%20Array.
 * https://www.youtube.com/watch?v=k-7jJP7QFEM
 * https://www.dcode.fr/matrix-determinant
 * https://www.geeksforgeeks.org/print-2-d-array-matrix-java/
 * https://www.studypug.com/algebra-help/multiplying-a-matrix-by-another-matrix#:~:text=The%20dot%20product%20is%20the,column%20of%20the%20second%20matrix.
 */

public class Square {
    public static void main(String[] args) {
        int nxn = 4;
        int x = 3;
        double[][] matA = new double[nxn][nxn];
//        System.out.println();

        double[][] matXX = new double[x][x];

        initMat(nxn, matA, false);
        initMat(x, matXX, false);

//        for (int i = 0; i < nxn; i++) {
//            System.out.println(Arrays.toString(matA[i]));
////        for debug purpose
//        }
//        System.out.println();

        subMat(matXX);
//        rec(nxn, matA);
    }

    /**
     * this method will look at getting a specified submatrix
     * statically. then use this info to make a dynamic method
     * <p>
     * pass in a matrix and view it
     */
    public static void subMat(double[][] matrix) {
        //something
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
//        for debug purpose
        }
        System.out.println();

        System.out.println(Arrays.toString(matrix[0]));

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[0][i]);
        }

        // if the head comes from col 0 use col + 1
        // if head comes from last col use col
        // if head comes from somewhere after col 0 and before final col, exclude that col
        // sub 1
        // make variable here that tells us which head we using to make current sub matrix
        // this var will increment after every loop to tell which col to exclude
        double[][] sub1 = new double[matrix.length - 1][matrix.length - 1];
        for (int r = 0; r < sub1.length; r++) { //row
            //something
            for (int c = 0; c < sub1.length; c++) {
                // if equals 0 don't plug in the column values into sub matrix
                if (c == 0) {
                    sub1[r][c] = matrix[r][c + 1];
                }
            }
        }
        // sub 2
        double[][] sub2 = new double[matrix.length - 1][matrix.length - 1];
        // sub 3
        double[][] sub3 = new double[matrix.length - 1][matrix.length - 1];

    }

    public static double[][] initMat(int n, double[][] matrix, boolean randomize) {
        Random rand = new Random();

        for (int r = 0; r < n; r++) {
            //fill rows of matrix
            for (int c = 0; c < n; c++) {
                if (randomize) {
                    //this
                    //RANDOM ASSIGNMENT
                    //fill cols of matrix in current row
                    //the range defined by rand is from 0 to .nextInt(VALUE) - 1
                    matrix[r][c] = rand.nextInt(n + 10);
                } else {
                    //BASE CASE VALUES
                    matrix[r][c] = (r * n) + c;
                }
            }
        }

        return matrix;
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

        for (int r = 0; r < n; r++) {    //row
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

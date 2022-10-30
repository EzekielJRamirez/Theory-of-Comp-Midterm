/**
 * Ezekiel forked this from Chris
 */

import java.util.*;

public class zTest {
    public static void main(String[] args) {
        System.out.println("hi");

        //5     = 3.2x + 8.7y + 5.9z + 3.7
        //12.9  = 2.4x + 3.1y + 1.1z + 3.8
        //2     = 9.7x + 6.1y + 0.3z + 1

        //matrix A will be the values in front of x, y, and z
        //NOTE: I made paper calculation for 6.1 instead of 1.1 per
        // midterm instructions, debug accordingly
        double[][] matA = {{3.2, 8.7, 5.9},
                {2.4, 3.1, 6.1},
                {9.7, 6.1, 0.3}};
        System.out.println(matA[0][2]);//row, col

        //matrix b will be the values on the left
        double[] matb = {5, 12.9, 2};

        //matrix s will be the values on the right with no variables attached
        double[] mats = {3.7, 3.8, 1};

        //matrix x will the unknown variables, init with either smallest
        // or biggest values
        double[] matx = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        // equation is b = mx + s
        // first step is to sub s values from b matrix

        for (int i = 0; i < matb.length; i++) {
            matb[i] -= mats[i];
        }

//        for (int i = 0; i < matb.length; i++) {
//            System.out.println(matb[i]);
//        }

        // now solve matrix a to get its value

        // a = [[a0, b0, c0], [a1, b1, c1], [a2, b2, c2]]
        // a = a0(b1*c2 - c1*b2) - b0(a1*c2 - c1*a2) + c0(a1*b2 - b1*a2)
        //      term 1              term 2              term 3
        //matA[row][col]
        double t1 = matA[0][0] * (matA[1][1] * matA[2][2] - matA[1][2] * matA[1][2]);
        double t2 = -matA[0][1] * (matA[1][0] * matA[2][2] - matA[1][2] * matA[2][0]);
        double t3 = matA[0][2] * (matA[1][0] * matA[1][2] - matA[1][1] * matA[2][0]);

        double matASolved = t1 + t2 + t3;
        
        System.out.println(t1 + " is t1\n" + t2 + " is t2\n" + t3 + " is t3");
        System.out.println(matASolved);

        //now solve for matA but substitute whole column one by one with
        // updated b matrix. replacing col1 should give you matAx,
        // col2 gives matAy, col3 gives matAz
        // matAx / matA should give you x and so on

    }
}

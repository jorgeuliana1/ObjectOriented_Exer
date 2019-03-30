import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class J1_06 {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        float matrixA[][];
        float matrixB[][];

        matrixA = new float[5][4];
        matrixB = new float[4][6];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4; j++) {
                matrixA[i][j] = sc.nextFloat();
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j++) {
                matrixB[i][j] = sc.nextFloat();
            }
        }

        PrintMatrix(MatrixMultiplication(matrixA, matrixB));

		

    }
    
    public static float[][] MatrixMultiplication(float[][] a, float[][] b) {
        float[][] c;
        c = new float[5][6];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 6; j++) {
                for(int k = 0; k < 4; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    if(j == 5)
                        c[i][j] = 0;
                }
            }
        }

        return c;
    }

    public static void PrintMatrix(float[][] m) {

        DecimalFormat df = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US));

        // Printing...
        for(float[] i : m) {
            for(float j : i) {
                // Looks like a printf
                System.out.print(df.format(j) + " ");
            }
            System.out.println();
        }
    }

}

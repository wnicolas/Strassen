package multiplicacion.por.strassen;

public class MultiplicacionPorStrassen {

    public static int[][] x11(int a[][]) {
        int a11[][] = new int[a.length / 2][a.length / 2];

        for (int i = 0; i < a.length / 2; i++) {
            for (int j = 0; j < a.length / 2; j++) {
                a11[i][j] = a[i][j];
            }
        }
        return a11;
    }

    public static int[][] x12(int a[][]) {
        int a12[][] = new int[a.length / 2][a.length / 2];

        int auxi = 0, auxj = 0;
        for (int i = 0; i < a.length / 2; i++) {
            for (int j = a.length / 2; j < a.length; j++) {
                a12[i][auxj] = a[i][j];
                auxj++;
            }
            auxj = 0;
        }
        return a12;
    }

    public static int[][] x21(int a[][]) {
        int a21[][] = new int[a.length / 2][a.length / 2];

        int auxi = 0, auxj = 0;
        for (int i = a.length / 2; i < a.length; i++) {
            for (int j = 0; j < a.length / 2; j++) {
                a21[auxi][j] = a[i][j];
            }
            auxi++;

        }
        return a21;
    }

    public static int[][] x22(int a[][]) {
        int a22[][] = new int[a.length / 2][a.length / 2];

        int auxi = 0, auxj = 0;
        for (int i = a.length / 2; i < a.length; i++) {
            for (int j = a.length / 2; j < a.length; j++) {
                a22[auxi][auxj] = a[i][j];
                auxj++;
            }
            auxj = 0;
            auxi++;

        }
        return a22;
    }

    public static int[][] suma(int a[][], int b[][]) {

        int suma[][] = new int[a.length][b.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                suma[i][j] = (a[i][j] + b[i][j]);
            }
        }
        return suma;
    }

    public static int[][] resta(int a[][], int b[][]) {

        int resta[][] = new int[a.length][b.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                resta[i][j] = (a[i][j] - b[i][j]);
            }
        }
        return resta;
    }

    public static int[][] Strassen(int a[][], int b[][]) {
        if (a.length == 2 && b.length == 2) {
            int m1, m2, m3, m4, m5, m6, m7;

            int c11, c12, c21, c22, x11, x22, x33, x44;

            m1 = (x11(a)[0][0] + x22(a)[0][0]) * (x11(b)[0][0] + x22(b)[0][0]);
            m2 = (x21(a)[0][0] + x22(a)[0][0]) * x11(b)[0][0];
            m3 = x11(a)[0][0] * (x12(b)[0][0] - x22(b)[0][0]);
            m4 = x22(a)[0][0] * (x21(b)[0][0] - x11(b)[0][0]);
            m5 = (x11(a)[0][0] + x12(a)[0][0]) * x22(b)[0][0];
            m6 = (x21(a)[0][0] - x11(a)[0][0]) * (x11(b)[0][0] + x12(b)[0][0]);
            m7 = (x12(a)[0][0] - x22(a)[0][0]) * (x21(b)[0][0] + x22(b)[0][0]);

            c11 = m1 + m4 - m5 + m7;
            c12 = m3 + m5;
            c21 = m2 + m4;
            c22 = m1 - m2 + m3 + m6;

            int resultado[][] = new int[2][2];
            resultado[0][0] = c11;
            resultado[0][1] = c12;
            resultado[1][0] = c21;
            resultado[1][1] = c22;

            return resultado;
        } else {

            int m1[][] = new int[a.length / 2][a.length / 2];
            int m2[][] = new int[a.length / 2][a.length / 2];
            int m3[][] = new int[a.length / 2][a.length / 2];
            int m4[][] = new int[a.length / 2][a.length / 2];
            int m5[][] = new int[a.length / 2][a.length / 2];
            int m6[][] = new int[a.length / 2][a.length / 2];
            int m7[][] = new int[a.length / 2][a.length / 2];

            //int m1[][], m2[][], m3[][], m4[][], m5[][], m6[][], m7[][];
            int c11[][] = new int[a.length / 2][a.length / 2];
            int c12[][] = new int[a.length / 2][a.length / 2];
            int c21[][] = new int[a.length / 2][a.length / 2];
            int c22[][] = new int[a.length / 2][a.length / 2];

            m1 = Strassen(suma(x11(a), x22(a)), suma(x11(b), x22(b)));
            m2 = Strassen(suma(x21(a), x22(a)), x11(b));
            m3 = Strassen(x11(a), resta(x12(b), x22(b)));
            m4 = Strassen(x22(a), resta(x21(b), x11(b)));
            m5 = Strassen(suma(x11(a), x12(a)), x22(b));
            m6 = Strassen(resta(x21(a), x11(a)), suma(x11(b), x12(b)));
            m7 = Strassen(resta(x12(a), x22(a)), suma(x21(b), x22(b)));

            c11 = suma(resta(suma(m1, m4), m5), m7);
            c12 = suma(m3, m5);
            c21 = suma(m2, m4);
            c22 = suma(resta(m1, m2), suma(m3, m6));

            int resultado[][] = new int[a.length][a.length];

            for (int i = 0; i < a.length / 2; i++) {
                for (int j = 0; j < a.length / 2; j++) {
                    resultado[i][j] = c11[i][j];
                }
            }
            int auxi = 0, auxj = 0;
            for (int i = 0; i < a.length / 2; i++) {
                for (int j = a.length / 2; j < a.length; j++) {
                    resultado[i][j] = c12[i][auxj];
                    auxj++;
                }
                auxj = 0;
            }
            for (int i = a.length / 2; i < a.length; i++) {
                for (int j = 0; j < a.length / 2; j++) {
                    resultado[i][j] = c21[auxi][j];

                }
                auxi++;
            }
            auxi = 0;
            auxj = 0;

            for (int i = a.length / 2; i < a.length; i++) {
                for (int j = a.length / 2; j < a.length; j++) {
                    resultado[i][j] = c22[auxi][auxj];
                    auxj++;
                }
                auxi++;
                auxj = 0;
            }

            return resultado;
        }
    }

    public static void main(String[] args) {
        int a[][] = {
            {1, 2, 3, 4, 5, 6, 7, 8},
            {9, 1, 2, 3, 4, 5, 6, 7},
            {8, 9, 1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3, 4, 5},
            {6, 7, 8, 9, 1, 2, 3, 4},
            {5, 6, 7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9, 1, 2},
            {3, 4, 5, 6, 7, 8, 9, 2},};
        int b[][] = {
            {1, 2, 3, 4, 5, 6, 7, 8},
            {9, 1, 2, 3, 4, 5, 6, 7},
            {8, 9, 1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3, 4, 5},
            {6, 7, 8, 9, 1, 2, 3, 4},
            {5, 6, 7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9, 1, 2},
            {3, 4, 5, 6, 7, 8, 9, 1},};

        /* 
        int a[][] = {
            {1, 2, 3, 4},
            {9, 1, 2, 3},
            {8, 9, 1, 2},
            {7, 8, 9, 1},};

        int b[][] = {
            {1, 2, 3, 4},
            {9, 1, 2, 3},
            {8, 9, 1, 2},
            {7, 8, 9, 1},};
         */
 /*
        int a[][] = {
            {1, 2},
            {9, 1},};
        int b[][] = {
            {2, 7},
            {4, 4},};
         */

 /*  int a[][] = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};

        int b[][] = {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},};
         */
        //int c[][] = Strassen(a, b);
        int c[][] = Strassen(a, b);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print("****" + c[i][j] + " ");
            }
            System.out.println("");
        }

    }

}

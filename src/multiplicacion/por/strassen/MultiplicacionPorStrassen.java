package multiplicacion.por.strassen;

public class MultiplicacionPorStrassen {
    public static int contador=0;
    public static int prueba=0;
    public static int prueba2=0;
    

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
        
        contador+=3;
        if (a.length == 2 && b.length == 2) {
            int m1, m2, m3, m4, m5, m6, m7;
            prueba += 1;
            

            int c11, c12, c21, c22, x11, x22, x33, x44;

            m1 = (x11(a)[0][0] + x22(a)[0][0]) * (x11(b)[0][0] + x22(b)[0][0]);
            m2 = (x21(a)[0][0] + x22(a)[0][0]) * x11(b)[0][0];
            m3 = x11(a)[0][0] * (x12(b)[0][0] - x22(b)[0][0]);
            m4 = x22(a)[0][0] * (x21(b)[0][0] - x11(b)[0][0]);
            m5 = (x11(a)[0][0] + x12(a)[0][0]) * x22(b)[0][0];
            m6 = (x21(a)[0][0] - x11(a)[0][0]) * (x11(b)[0][0] + x12(b)[0][0]);
            m7 = (x12(a)[0][0] - x22(a)[0][0]) * (x21(b)[0][0] + x22(b)[0][0]);
            contador+=71;
            

            c11 = m1 + m4 - m5 + m7;
            c12 = m3 + m5;
            c21 = m2 + m4;
            c22 = m1 - m2 + m3 + m6;
            contador +=12;

            int resultado[][] = new int[2][2];
            resultado[0][0] = c11;
            resultado[0][1] = c12;
            resultado[1][0] = c21;
            resultado[1][1] = c22;
            contador +=18;  
            
            return resultado;
            
            
        } else {
            
            prueba2 += 1;
            int m1[][] = new int[a.length / 2][a.length / 2];
            int m2[][] = new int[a.length / 2][a.length / 2];
            int m3[][] = new int[a.length / 2][a.length / 2];
            int m4[][] = new int[a.length / 2][a.length / 2];
            int m5[][] = new int[a.length / 2][a.length / 2];
            int m6[][] = new int[a.length / 2][a.length / 2];
            int m7[][] = new int[a.length / 2][a.length / 2];
            contador += 49;

            //int m1[][], m2[][], m3[][], m4[][], m5[][], m6[][], m7[][];
            int c11[][] = new int[a.length / 2][a.length / 2];
            int c12[][] = new int[a.length / 2][a.length / 2];
            int c21[][] = new int[a.length / 2][a.length / 2];
            int c22[][] = new int[a.length / 2][a.length / 2];
            contador += 28;

            m1 = Strassen(suma(x11(a), x22(a)), suma(x11(b), x22(b)));
            m2 = Strassen(suma(x21(a), x22(a)), x11(b));
            m3 = Strassen(x11(a), resta(x12(b), x22(b)));
            m4 = Strassen(x22(a), resta(x21(b), x11(b)));
            m5 = Strassen(suma(x11(a), x12(a)), x22(b));
            m6 = Strassen(resta(x21(a), x11(a)), suma(x11(b), x12(b)));
            m7 = Strassen(resta(x12(a), x22(a)), suma(x21(b), x22(b)));
            contador += 7;
           // contador += 24;//
            

            c11 = suma(resta(suma(m1, m4), m5), m7);
            c12 = suma(m3, m5);
            c21 = suma(m2, m4);
            c22 = suma(resta(m1, m2), suma(m3, m6));
            contador += 4;

            int resultado[][] = new int[a.length][a.length];
            contador += 5;
            contador += 3;                

            for (int i = 0; i < a.length / 2; i++) {
                contador += 6;
                
                for (int j = 0; j < a.length / 2; j++) {
                    resultado[i][j] = c11[i][j];
                    contador +=8;//8(a/2)(-a/2+6)+3***************** (a/2)*(8*(a/2)+6)                    
                }
            }            
            
            
            contador += 2;
            int auxi = 0, auxj = 0;
            contador += 3;         
             
            
            for (int i = 0; i < a.length / 2; i++) {
                contador += 6;
                
                for (int j = a.length / 2; j < a.length; j++) {
                    resultado[i][j] = c12[i][auxj];
                    auxj++;
                    contador += 8;
                    
                }
                contador += 1;//(7n(8n-a))+3***** 8(a)(a/2+7)+3   *********  (a/2)*(8*(a/2)+7)
                
                auxj = 0;
            }
            
            contador += 3;
            
            for (int i = a.length / 2; i < a.length; i++) {
                contador += 5;
                
                for (int j = 0; j < a.length / 2; j++) {
                    resultado[i][j] = c21[auxi][j];
                    contador += 8;//(6n(8n)-a)+3***** 8(a/2)(-a+6)+3 *********  (a/2)*(8*(a/2)+6)
                    

                }
                auxi++;
                contador += 1;
               
            }
            contador += 2;
            
            auxi = 0;
            auxj = 0;
            contador += 3;
            
          

            for (int i = a.length / 2; i < a.length; i++) {
                contador += 5;
               
                for (int j = a.length / 2; j < a.length; j++) {
                    resultado[i][j] = c22[auxi][auxj];
                    auxj++;
                    contador += 8;//(8n(8n-a/2)-a)+3 ***** 8(a/2)(a/2+8)+3 ******* (a/2)*(8*(a/2)+8)
                    
                    
                }
                auxi++;
                auxj = 0;
                contador += 3;
                
            }
           
            //System.out.println("El contador es: "+contador);
            //System.out.println("++++++"+a.length);
            
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

        
        /*int a[][] = {
            {1, 2, 3, 4},
            {9, 1, 2, 3},
            {8, 9, 1, 2},
            {7, 8, 9, 1},};

        int b[][] = {
            {1, 2, 3, 4},
            {9, 1, 2, 3},
            {8, 9, 1, 2},
            {7, 8, 9, 1},};*/
         
 
        /*int a[][] = {
            {1, 2},
            {9, 1},};
        int b[][] = {
            {2, 7},
            {4, 4},};*/
         
        int []d = new int [4];
        double e=109.5;
        /*int a[][] = {
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
       int p1,p2,p3,p4,p5;
       double p6;
       
       /* p1=(8*(a.length)*(a.length+8)+3);
        p2=(8*(a.length)*(-(a.length/2)+6)+3);
        p3=(8*(a.length/2)*(a.length+7)+3);
        p4=(8*(a.length/2)*(-(a.length/2)+6)+3);*/ 
       
        p1=(d.length/2)*(8*(d.length/2)+6);//44
        p2=(d.length/2)*(8*(d.length/2)+7);//46
        p3=(d.length/2)*(8*(d.length/2)+6);//44
        p4=(d.length/2)*(8*(d.length/2)+8);//48 
            
        p5=p1+p2+p3+p4;
        p6=(prueba*101)+(p5*prueba2)+(prueba2*109)+(3*(prueba+prueba2))+((prueba2/2)*e);      
        
        
       /* p1=(8*(a.length/2)*(a.length/2+8)+3);
        p2=(8*(a.length/2)*(-a.length/2+6)+3);
        p3=(8*(a.length/2)*(a.length/2+7)+3);
        p4=(8*(a.length/2)*(-(a.length/2)+6)+3);
        p5=(p1+p2+p3+p4)*7;*/
                
        //System.out.println("La fomula es: "+(8*(a.length/2)*(a.length/2+8)+3)+(8*(a.length/2)*(-a.length/2+6)+3)+
                    //(8*(a.length)*(a.length/2+7)+3)+(8*(a.length/2)*(-(a.length/2)+6)+3));
        //System.out.println("La fomula es: "+p);            
        System.out.println("P5: "+p4);
        System.out.println("La fomula es: "+p6);
        System.out.println("prueba:"+prueba);
        System.out.println("prueba2:"+prueba2);
        System.out.println("contador2:"+contador);
        

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print("****" + c[i][j] + " ");
            }
            System.out.println("");
        }

    }

}

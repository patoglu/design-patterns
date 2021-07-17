

public class Matrix {
    private final int i;
    private final int j;
    private final double[][] matrix;

    public Matrix(int x, int y)
    {
        i = x;
        j = y;
        matrix = new double[i][j];
    }
    public Matrix(double[][] user_matrix)
    {   
        
        int x,y;
        i = user_matrix.length;
        j = user_matrix[0].length;
        System.out.println(i);
        System.out.println(j);
        matrix = new double[i][j];
        for(x = 0 ; x < i ; ++x)
        {
            for(y = 0 ; y < j ; ++y)
            {
                matrix[x][y] = user_matrix[x][y];
            }
        }
    }


    public Matrix(double[][] user_matrix, double[] constants )
    {   
        
        int x,y;
        i = user_matrix.length;
        j = user_matrix[0].length;
        System.out.println(i);
        System.out.println(j);
        matrix = new double[i][j];
        for(x = 0 ; x < i ; ++x)
        {
            for(y = 0 ; y < j ; ++y)
            {
                matrix[x][y] = user_matrix[x][y];
            }
        }
    }

    


    public void show() {
        for (int x = 0; x < i; x++) {
            for (int y = 0; y < j; y++) 
                System.out.format("%.3f ",  matrix[x][y]);  
            System.out.println(); 
        }
    }


    
    /** 
     * @return Matrix inversed Matrix.
     */
    public Matrix inverse() {
        assert(i == j);
        // Augment by identity matrix
        Matrix tmp = new Matrix(i, j * 2);
        for (int row = 0; row < i; ++row) {
            System.arraycopy(matrix[row], 0, tmp.matrix[row], 0, j);
            tmp.matrix[row][row + j] = 1;
        }
        tmp.toReducedRowEchelonForm();
        Matrix inv = new Matrix(i, j);
        for (int row = 0; row < i; ++row)
            System.arraycopy(tmp.matrix[row], j, inv.matrix[row], 0, j);
        return inv;
    }



    
    /** 
     * @param B Constants of the equation
     */
    public void solve(double[] B)

    {

        int N = B.length;

        for (int k = 0; k < N; k++) 

        {

            /** find pivot row **/

            int max = k;

            for (int x = k + 1; x < N; x++) 

                if (Math.abs(matrix[x][k]) > Math.abs(matrix[max][k])) 

                    max = x;

 

            /** swap row in A matrix **/    

            double[] temp = matrix[k]; 

            matrix[k] = matrix[max]; 

            matrix[max] = temp;

 

            /** swap corresponding values in constants matrix **/

            double t = B[k]; 

            B[k] = B[max]; 

            B[max] = t;

 

            /** pivot within A and B **/

            for (int x = k + 1; x < N; x++) 

            {

                double factor = matrix[x][k] / matrix[k][k];

                B[x] -= factor * B[k];

                for (int y = k; y < N; y++) 

                    matrix[x][y] -= factor * matrix[k][y];

            }

        }

 


 



        double[] solution = new double[N];

        for (int x = N - 1; x >= 0; x--) 

        {

            double sum = 0.0;

            for (int y = x + 1; y < N; y++) 

                sum += matrix[x][y] * solution[y];

            solution[x] = (B[x] - sum) / matrix[x][x];

        }        

        /** Print solution **/

        int M = solution.length;

        System.out.println("\nSolution : ");

        for (int i = 0; i < M; i++) 

            System.out.printf("%.3f ", solution[i]);   

        System.out.println(); 


    }
    //https://rosettacode.org/wiki/Gauss-Jordan_matrix_inversion#Java- Got help from there.

    public void toReducedRowEchelonForm() {
        for (int row = 0, lead = 0; row < i && lead < j; ++row, ++lead) {
            int x = row;
            while (matrix[x][lead] == 0) {
                if (++x == i) {
                    x = row;
                    if (++lead == j)
                        return;
                }
            }
            swapRows(x, row);
            if (matrix[row][lead] != 0) {
                double f = matrix[row][lead];
                for (int column = 0; column < j; ++column)
                    matrix[row][column] /= f;
            }
            for (int y = 0; y < i; ++y) {
                if (y == row)
                    continue;
                double f = matrix[y][lead];
                for (int column = 0; column < j; ++column)
                    matrix[y][column] -= f * matrix[row][column];
            }
        }
    }

  

    
    /** 
     * @param x first row
     * @param y second row
     */
    private void swapRows(int x, int y) {
        double[] tmp = matrix[x];
        matrix[x] = matrix[y];
        matrix[y] = tmp;
    }

    
    /** 
     * @param other the second matrix.
     * @return Matrix multiplied new matrix.
     */
    public Matrix times(Matrix other) {
        Matrix original_matrix = this;
        if (original_matrix.j != other.i) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix result = new Matrix(original_matrix.i, other.j);
        for (int x = 0; x < result.i; x++)
            for (int y = 0; y < result.j; y++)
                for (int k = 0; k < original_matrix.j; k++)
                result.matrix[x][y] += (original_matrix.matrix[x][k] * other.matrix[k][y]);
        return result;
    }



    
}

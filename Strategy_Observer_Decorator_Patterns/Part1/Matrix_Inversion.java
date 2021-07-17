public class Matrix_Inversion implements LinearSolverDeluxe{

    
    /** 
     * @param linear_system system input of the user.
     * 
     */
    @Override
    public void solve_linear_equation(Linear_System linear_system) {
        Matrix result;
        Matrix d = new Matrix(linear_system.get_expression());
        Matrix constant_matrix = new Matrix(linear_system.get_constants());
        Matrix echelon_matrix = new Matrix(linear_system.get_expression());
        System.out.println("Here our matrix: ");
        echelon_matrix.show();
        d = echelon_matrix.inverse();

        result = d.times(constant_matrix);

        System.out.println("This is the solution");
        result.show();
        
    }
    
}

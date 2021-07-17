public class Gaussian_Elimination implements LinearSolverDeluxe{

    
    /** 
     * @param linear_system system of the user
     * 
     */
    @Override
    public void solve_linear_equation(Linear_System linear_system) {
        // TODO Auto-generated method stub

        
        Matrix d = new Matrix(linear_system.get_expression());
        d.solve(linear_system.get_constants_1d());
        


        
    }
    
}

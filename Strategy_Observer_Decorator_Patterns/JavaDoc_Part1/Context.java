public class Context
{
    private LinearSolverDeluxe linear_solver;

    public Context(LinearSolverDeluxe linear_solver)
    {
        this.linear_solver = linear_solver;
    }


    
    /** 
     * @param input_system input system of the user
     * @return double[] returns the equation as 1D array.
     */
    public void solve_equation(Linear_System input_system)
    {
        linear_solver.solve_linear_equation(input_system);
    }
}
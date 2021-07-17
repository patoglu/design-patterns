
import java.util.Scanner;

public class Linear_System
{
    private double[][] expression;

    public Linear_System()
    {

    }

    public void input()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Hello dear user... This program will help you with linear system solving.");
        System.out.println("Let's start. How many equations will you have in your system ?");        
        int exp_count = myObj.nextInt();
        System.out.format("Alright your system will have %d equations.\n",exp_count);
        System.out.format("According to your system you need to have %d unknowns on your equations.\n",exp_count);
        int unknown_variables = exp_count; 

        expression = new double[exp_count][unknown_variables + 1];
        for(int i = 0 ; i < exp_count ; ++i)
        {
            System.out.format("Enter the %d. equation as list.\n", i + 1);  
            for(int j = 0 ; j < unknown_variables + 1 ; ++j)
            {
                expression[i][j] =  myObj.nextInt();
            }
        }  

        myObj.close();
    }
    public void info()
    {
        System.out.println("(1)For 2x + y - 5 = 0 (constant needs to placed at the end), you should enter 2 1 -5.\n\n");
        System.out.println("(2)The constant in the equation needs to be at the other side of the equation always.\n\n");
        System.out.println("(3) If you want to skip some variables. For example 2x + z = 0, you need to enter 2 0 1 0\n\n");

    }
    
    /** 
     * @return double[][]
     */
    /*public double[][] get_expression()
    {
        double[][] matrix_form=Arrays.stream(expression)
                    .map(a ->  Arrays.copyOf(a, a.length))
                    .toArray(double[][]::new);

        //return matrix_form;
        return this.expression;
    }*/

    public double[][] get_expression() {
        int length = expression.length;
        double[][] target = new double[length][expression[0].length - 1] ;
        for (int i = 0; i < length; i++) {
            System.arraycopy(expression[i], 0, target[i], 0, expression[i].length - 1);
        }
        return target;
    }
    
    
    /** 
     * @return double[][] which is the constants of the equation
     */
    public double[][] get_constants()
    {
        
        int length = expression.length;
        double[][] constants = new double[length][1];
        for(int i = 0 ; i < length ; ++i)
        {
            constants[i][0] = expression[i][length];
        }
        return constants;
    }
    
    /** 
     * @return double[] which is the id of the constants
     */
    public double[] get_constants_1d()
    {
        int length = expression.length;
        double constants[] = new double[length];
        for(int i = 0 ; i < length ; ++i)
        {
            constants[i] = expression[i][length];
        }
        return constants;
    }
    
    /** 
     * @return String which is the human readable form of the equation.
     */
    public String toString() 
    {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int n = expression.length;
        int m = expression[0].length;

        StringBuilder sb = new StringBuilder();
        if(expression == null)
        {
            return "null-equation(s)";
        }
        else
        {
            for(int i = 0 ; i < n ; ++i)
            {
                for(int j = 0 ; j < m ; ++j)
                {
                    if(j == m - 1)
                    {
                        sb.append("= ");
                        sb.append(String.valueOf(expression[i][j] +" "));
                    }
                    else if(expression[i][j] > 0 )
                    {
                        if(j == 0)
                        {
                            sb.append(String.valueOf(expression[i][j] )+alphabet[j]+" ") ;
                        }
                        else
                        {
                            sb.append("+ ");
                            sb.append(String.valueOf(expression[i][j] )+alphabet[j]+" ") ;
                        }
                        
                    }
                    else if(expression[i][j] < 0)
                    {
                        //sb.append("-");
                        sb.append(String.valueOf(expression[i][j])+alphabet[j]+" ");
                    }
                    else
                    {
                        sb.append("+ ");
                        sb.append(String.valueOf(expression[i][j])+alphabet[j]+" ");
                    }
                }
                sb.append("\n\n");

            }
        }        
        String single_string = sb.toString();
        return single_string;
    }
       
    
}
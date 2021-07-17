
class Main
{

    
    public static void main(String[] args)
    {
        
        Linear_System user_system = new Linear_System();
        user_system.info();
        user_system.input(); 
        System.out.println("\n\n\n");
        System.out.println("Here is your system. Check it, is this okay ?");
        System.out.println(user_system);


        Context context = new Context(new Matrix_Inversion());
        Context context2 = new Context(new Gaussian_Elimination());
        context.solve_equation(user_system);
        context2.solve_equation(user_system);
    }
}

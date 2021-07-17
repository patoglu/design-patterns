import java.util.Scanner;
public class Main
{

    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welcome to Armor shop. You will make some selections for your shiny new armor now..");
        System.out.println("Please pick a number for the main armor type.\n(1) dec\n(2) ora\n(3) tor");
        int armor_selection = myObj.nextInt();

        System.out.println("Wise choice ! Now let's add some accessories! :)\n\n ");
        System.out.println("Please enter the desired number of flamethrowers in your equipments. If you don't need, simply type 0\n");
        int flame_thrower_count = myObj.nextInt();

        System.out.println("Please enter the desired number of autorifles in your equipments. If you don't need, simply type 0\n");
        int auto_rifle_count = myObj.nextInt();


        System.out.println("Please enter the desired number of rocket launchers in your equipments. If you don't need, simply type 0\n");
        int rocket_launcher_count = myObj.nextInt();


        System.out.println("Please enter the desired number of lasers in your equipments. If you don't need, simply type 0\n");
        int laser_count = myObj.nextInt();
        myObj.close();
        Armor armor;
        if(armor_selection == 1)
        {
            armor = new Dec();
        }
        else if(armor_selection == 2)
        {
            armor = new Ora();
        }
        else if(armor_selection == 3)
        {
            armor = new Tor();
        }
        else
        {
            throw new IllegalArgumentException();
        }
        for(int i = 0 ; i < flame_thrower_count ; ++i)
        {
            armor = new Flamethrower(armor);
        }
        for(int i = 0 ; i < rocket_launcher_count ; ++i)
        {
            armor = new RocketLauncher(armor);
        }
        for(int i = 0 ; i < auto_rifle_count ; ++i)
        {
            armor = new AutoRifle(armor);
        }
        for(int i = 0 ; i < laser_count ; ++i)
        {
            armor = new Laser(armor);
        }

        System.out.println(armor.get_armor_name() + " $ " + armor.cost());
        System.out.println(armor.get_armor_name() + " kg " + armor.weight());

    
        

    }
}



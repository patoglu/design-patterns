public abstract class Armor
{
    String armor_name = "Raw Armor."; 
    
    /** 
     * @return String armor name.
     */
    public String get_armor_name()
    {
        return  armor_name;
    }
    public abstract double cost();
    public abstract double weight();
}




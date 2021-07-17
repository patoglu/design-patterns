public class Laser extends Decorator{
    private Armor armor;

    Laser(Armor armor)
    {
        this.armor = armor;
    }

    
    /** 
     * @return double which is cost
     */
    @Override
    public double cost()
    {
        return armor.cost() + 200000;
    }
    
    /** 
     * @return double which is the weight
     */
    @Override
	public double weight() {
		
		return armor.weight() + 5.5;
    }
    
    /** 
     * @return String which is the name of the armor
     */
    @Override
    public String get_armor_name() {
        return armor.get_armor_name() + "Laser ";
    }
}

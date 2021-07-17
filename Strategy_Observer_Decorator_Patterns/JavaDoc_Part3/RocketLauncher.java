public class RocketLauncher extends Decorator{
    private Armor armor;

    RocketLauncher(Armor armor)
    {
        this.armor = armor;
    }

    
    /** 
     * @return double which is the cost
     */
    @Override
    public double cost()
    {
        return armor.cost() + 150000;
    }
    
    /** 
     * @return double which is the weight
     */
    @Override
	public double weight() {
		
		return armor.weight() + 7.5;
    }
    
    /** 
     * @return String which is the armor name.
     */
    @Override
    public String get_armor_name() {
        return armor.get_armor_name() + "RocketLauncher ";
    }
}

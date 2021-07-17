public class AutoRifle extends Decorator{
    private Armor armor;

    AutoRifle(Armor armor)
    {
        this.armor = armor;
    }

    
    /** 
     * @return double armor cost
     */
    @Override
    public double cost()
    {
        return armor.cost() + 30000;
    }
    
    /** 
     * @return double armor weight
     */
    @Override
	public double weight() {
		
		return armor.weight() + 1.5;
	}

    
    /** 
     * @return String name of the armor
     */
    @Override
    public String get_armor_name() {
        return armor.get_armor_name() + "AutoRifle ";
    }
}

    

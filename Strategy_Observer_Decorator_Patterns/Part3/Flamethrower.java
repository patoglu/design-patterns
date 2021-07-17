public class Flamethrower extends Decorator{
    private Armor armor;

    Flamethrower(Armor armor)
    {
        this.armor = armor;
    }

    
    /** 
     * @return double which is cost
     */
    @Override
    public double cost()
    {
        return armor.cost() + 50000;
    }
    
    /** 
     * @return double which is weight
     */
    @Override
	public double weight() {
		
		return armor.weight() + 2;
    }
    
    /** 
     * @return String which is name of the armor
     */
    @Override
    public String get_armor_name() {
        return armor.get_armor_name() + "Flamethrower ";
    }
}

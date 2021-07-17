public class Tor extends Armor{
    Tor()
    {
        armor_name = "Tor";
    }
    
    /** 
     * @return double which is the cost
     */
    @Override
    public double cost() {
        // TODO Auto-generated method stub
        return 5000000;
    }

    
    /** 
     * @return double which is the weight
     */
    @Override
    public double weight() {
        // TODO Auto-generated method stub
        return 50;
    }
}

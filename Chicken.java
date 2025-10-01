public class Chicken extends Animal
{


    public Chicken(){
        this("chicken");
    }

    public Chicken(String chickenType){
        super("Gallus Gallus Domesticus", chickenType);
    }
    
    @Override
    public void speak(){
        System.out.println("bawk");
    }

    
}

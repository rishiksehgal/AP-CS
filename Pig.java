public class Pig extends Animal{
    public Pig(){
        this("pig");
    }

    public Pig(String pigType){
        super("Sus Crofa Domesticus", pigType);
    }

    public void speak()
    {
        System.out.println("oink");
    }
}

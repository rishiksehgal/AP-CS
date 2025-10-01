public abstract class Animal implements Comparable<Animal>
{


private String latinName;
private String commonName;

public Animal(String l, String c){
    latinName = l;
    commonName = c;
}

public String getLatinName(){
    return latinName;
}

public String getCommonName(){
    return commonName;
}

public void setLatinName(String s){
    latinName = s;
}

public void setCommonName(String s){
    commonName = s;
}

public abstract void speak();


public int compareTo(Animal a ){
    return a.getCommonName().compareTo(this.getCommonName());
}

}
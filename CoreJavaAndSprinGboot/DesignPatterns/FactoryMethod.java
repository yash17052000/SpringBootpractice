package CreationOfThreads;

abstract class Burger {
  public void prepare(){};
    
}
 class SimpleBurger extends Burger{

    @Override
    public void prepare() {
        System.out.println("simple burger");
    }
}

 class NormalBurger extends Burger{

    @Override
    public void prepare() {
        System.out.println("Normal burger");
    }
}
 class PremiumBurger extends Burger{

    @Override
    public void prepare() {
        System.out.println("Premium burger");
    }
}
class BurgerFactory {

  public Burger createBurger(String type){
  
    
      return null;
  }
    
}
class KingBurgerFactory extends BurgerFactory{
    public Burger createBurger(String type){
         System.out.print("kingh");
        if(type=="basic") return new NormalBurger();
      if(type=="simple") return new SimpleBurger();
      if(type=="premium") return new PremiumBurger();
      return null;
    }
}
class  SinghBurgerFactpry extends BurgerFactory{
    public Burger createBurger(String type){
        System.out.print("Singh");
        if(type=="basic") return new NormalBurger();
      if(type=="simple") return new SimpleBurger();
      if(type=="premium") return new PremiumBurger();
      return null;
    }
}
public class FactoryMethod {
public static void main(String[] args) {
    BurgerFactory kb= new KingBurgerFactory();
    kb.createBurger("premium").prepare();;

}
    
}
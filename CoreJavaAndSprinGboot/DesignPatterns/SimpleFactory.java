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
  
     if(type=="basic") return new NormalBurger();
      if(type=="simple") return new SimpleBurger();
      if(type=="premium") return new PremiumBurger();
      return null;
  }
    
}
public class SimpleFactory {
public static void main(String[] args) {
    BurgerFactory b= new BurgerFactory();
    Burger nm=b.createBurger("basic");
    nm.prepare();
     b.createBurger("premium").prepare();;

}
    
}
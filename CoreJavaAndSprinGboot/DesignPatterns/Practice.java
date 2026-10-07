package CreationOfThreads;



import java.util.ArrayList;
import java.util.List;

import CreationOfThreads.SingleTon;

class Singleton{

    private final static Singleton instance;
    public  Singleton(){
      instance=null;
    }
    public Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
               if(instance==null)
               {
                instance=new Singleton();
               }
            }
        }
        return instance;
    }

}
public class Practice {
public static void main(String[] args) {


    Singleton s1= new Singleton();
     Singleton s2= new Singleton();
System.out.println(s1==s2);
   
}
    
}
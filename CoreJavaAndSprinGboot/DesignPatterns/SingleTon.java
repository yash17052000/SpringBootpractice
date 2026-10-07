package CreationOfThreads;

class SingleTonClass {
 private static SingleTonClass instance=null;
    public static SingleTonClass getInstance(){
       
        if(instance==null){
             synchronized(SingleTonClass.class){
                if(instance==null  )
            instance=new SingleTonClass();
             }
        }
    
        return instance;
    }
    
}

public class SingleTon {
public static void main(String[] args) {
    SingleTonClass s1=SingleTonClass.getInstance();
    SingleTonClass s2 = SingleTonClass.getInstance();
    System.out.println(s1==s2);
}
    
}
package CreationOfThreads;

import java.util.Scanner;

interface Strategy {
    public int  execute(int a,int b);
}
class AddStrategy implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a+b;
    }
    
}
class SubtractStrategy implements Strategy {

    @Override
    public int execute(int a, int b) {
        return Math.abs(a-b);
    }
    
}
class Context  {
public Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public int executeStrategy(int a,int b){
        return strategy.execute(a, b);
    }

}
public class StrategyPattern {
    
public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a=scn.nextInt();
    int b=scn.nextInt();
    Context context= new Context();

    int i=scn.nextInt();
    switch (i) {
        case 1:{
            context.setStrategy(new AddStrategy());
           System.out.print( context.executeStrategy(a, b));
            break;
        }
        case 2:{
            context.setStrategy(new SubtractStrategy());
            System.out.print( context.executeStrategy(a, b));
            break;
        }
    
        default:
            break;
    }
}
}

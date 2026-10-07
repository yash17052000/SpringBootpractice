
package CreationOfThreads;
import java.util.*;
interface DirectionStrategy{
    int getDirection(int dir);
}
class UpdirectionStrategy implements DirectionStrategy{
    public int getDirection(int dir){
        return  dir-1;
    }
}
class DowndirectionStrategy implements DirectionStrategy{
    public int getDirection(int dir){
        return  dir+1;
    }
}
class RightdirectionStrategy implements DirectionStrategy{
    public int getDirection(int dir){
        return  dir+1;
    }
}
class LeftdirectionStrategy implements DirectionStrategy{
    public int getDirection(int dir){
        return  dir-1;
    }
}
class Context{
    private DirectionStrategy directionStrategy;
    public void setState(DirectionStrategy directionStrategy){
      this.directionStrategy=directionStrategy;
    }
    public int direction(int dir){
        
       return  directionStrategy.getDirection(dir);
    }
}
public class SnakeFoodGame {
    int width;
    int height;
    int food[][];// food positions
    int foodIndex;// which food is comming next 
    Deque <Integer> snake;// snake positions
    Set<Integer> set;// quality check  whether snake is occupied

    SnakeFoodGame(int width,int height,int food[][]){
        this.width=width;
        this.height=height;
        this.food=food;
        this.foodIndex=0;
        snake= new LinkedList<>();
        set= new HashSet<>();
        int start=0;
        snake.addFirst(start);
        set.add(start);
    }

    public int move(int  dir){
        int head=snake.peekFirst();
        int row = head/width;
        int col=head%width;
        Context context= new Context();
        switch (dir) {
            case 1:
                   {
                context.setState(new UpdirectionStrategy());
               
                row=context.direction(row);
                
                break;
               }
                case 2:
                    {
                context.setState(new DowndirectionStrategy());
                row=context.direction(row);
                 System.out.println(row+"jjiji");
                break;
                }
                case 3:
                    {
                context.setState(new RightdirectionStrategy());
                col=context.direction(col);
                break;
                }
                case 4:
                    {
                context.setState(new LeftdirectionStrategy());
                col=context.direction(col);
                break;
                }
        
            default:
                {
                    System.out.println("invalid direction");
                }
        }
        if(row<0||col<0||row>=height||col>=width) return -1;
        int newpostion=row*width+col;
        boolean atefood=false;
        if(foodIndex<food.length&&row==food[foodIndex][0]&&col==food[foodIndex][1]){
        atefood=true;
        foodIndex++;
        }        
        if(!atefood){
            int tail=snake.removeLast();
            set.remove(tail);
            
        }
        if(set.contains(newpostion)){
            return -1;
        }
        set.add(newpostion);
        snake.addFirst(newpostion);
        return foodIndex;
    }
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int[][] food = {
        {1, 2},
        {0, 1}
    };

   SnakeFoodGame game = new SnakeFoodGame(3, 3, food);

    System.out.println("Snake Game");
    System.out.println("1 = UP");
    System.out.println("2 = DOWN");
    System.out.println("3 = RIGHT");
    System.out.println("4 = LEFT");
    System.out.println("Enter -1 to exit");

    while (true) {

        System.out.print("Enter direction: ");
        int move = sc.nextInt();

        if (move == -1) {
            System.out.println("Game exited.");
            break;
        }

        int result = game.move(move);

        System.out.println("Score: " + result);

        if (result == -1) {
            System.out.println("GAME OVER");
            break;
        }

        System.out.println("----------------");
    }

    sc.close();
}
}

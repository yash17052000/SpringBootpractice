package CreationOfThreads;

/**
 * 
 */
 interface  State{
 void play(MusicPlayer MusicPlayer);
 void pause(MusicPlayer MusicPlayer);
 void stop(MusicPlayer MusicPlayer);
}
class PlayingState implements State{
   public void play(MusicPlayer MusicPlayer){
        System.out.println("Playing");
    }
   public void stop(MusicPlayer MusicPlayer){
        System.out.println("Stopped");
        MusicPlayer.setState(new StoppedState());
    }
  public  void pause(MusicPlayer MusicPlayer){
     System.out.println("Paused");
        MusicPlayer.setState(new PausedState());
    }
}
class StoppedState implements State{
   public void play(MusicPlayer MusicPlayer)  {
        System.out.println("Playing");
        MusicPlayer.setState(new PlayingState());
    }
   public void stop(MusicPlayer MusicPlayer){
       System.out.println("Stopped");
    }
  public  void pause(MusicPlayer MusicPlayer){
         System.out.println("Paused");
         MusicPlayer.setState(new PausedState());
    }
}
class PausedState implements State{
   public void play(MusicPlayer MusicPlayer){
        System.out.println("Playing");
        MusicPlayer.setState(new PlayingState());
    }
   public void stop(MusicPlayer MusicPlayer){
        System.out.println("stopped");
        MusicPlayer.setState(new StoppedState());
    }
   public  void pause(MusicPlayer MusicPlayer){
        System.out.println("Pasused");
        
    }
}
class MusicPlayer{
    private State  state;
    public MusicPlayer(){
        state=new StoppedState();
    }
    public void setState(State state){
        this.state=state;
        
    }
    public void play(){
        state.play(this);
    }
    public void stop(){
        state.stop(this);
    }
    public void pause(){
        state.pause(this);
    }
}
public class StatePattern {
    public static void main(String[] args) {
        MusicPlayer musicPlayer= new MusicPlayer();
        musicPlayer.play();
        musicPlayer.setState(new PlayingState());
        
        musicPlayer.pause();
        musicPlayer.play();
        musicPlayer.pause();
    }
}

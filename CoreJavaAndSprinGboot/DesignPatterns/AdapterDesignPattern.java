package CreationOfThreads;

interface Mediaplayer{
    void play();

}
class AudioPlayer implements Mediaplayer{

    public void play(){
        System.out.println("Aduio player is working ");
    }
}

class Vlccodec {
    public void playVlccodec(){
        System.out.println("Vlccodec is palyaing");
    }
}

class Mp4Player {
    public void playMp4player(){
        System.out.println("Mp4codec is palyaing");
    }
}
class VlcAdpater implements Mediaplayer{
    private Vlccodec vlccodec;
    
    @Override
    public void play() {
        // TODO Auto-generated method stub
     vlccodec.playVlccodec();  
    }
    public VlcAdpater(Vlccodec vlccodec) {
        this.vlccodec = vlccodec;
    }
    
}

class Mp4Adpater implements Mediaplayer{
    private Mp4Player mp4Player;
    
    @Override
    public void play() {
        // TODO Auto-generated method stub
     mp4Player.playMp4player();  
    }
    public Mp4Adpater(Mp4Player mp4Player) {
        this.mp4Player=mp4Player;
    }
    
}
// From ashsish pratap singh code and understanding by durgesh
 class AudioMediaPlayer {
    Mediaplayer mediaplayer;
public void play(String file) {
   
   String filename=file.substring(file.lastIndexOf(".")+1);
   
   switch (filename) {
    case "audio":
        mediaplayer= new AudioPlayer();
        mediaplayer.play();
        break;

    case "mp4":
        mediaplayer= new Mp4Adpater(new Mp4Player());
        mediaplayer.play();
        break;
    case "vlc":
        
        mediaplayer= new VlcAdpater(new Vlccodec());
        mediaplayer.play();
    default:
        System.out.println("Unsupporeted format");
        break;
        
   }
   

  
  
}    
}

/**
 * AdapterDesignPattern
 */
public class AdapterDesignPattern {

    public static void main(String[] args) {
        AudioMediaPlayer audioMediaPlayer= new AudioMediaPlayer();
        
         audioMediaPlayer.play("song.mp4");
         audioMediaPlayer.play("image.png");
    }
}

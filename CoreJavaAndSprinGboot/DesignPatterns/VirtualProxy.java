package CreationOfThreads;
 interface Image {
    void display();
 }

// video by coder army  similarly remote and protection will be implemnted
 class RealImage implements Image{

   String file;
    
    public RealImage(String file) {
    this.file=file;   
    // heavy operation
    System.out.println("loading image from disc"+file);
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
       System.out.println("display image"+file);
    }
    
 }

 class ImageProxy implements Image{
    RealImage realImage;
    String file;

    public ImageProxy(String file) {
        this.file=file;
         realImage=null;
    }
// lazy loading
    @Override
    public void display() {
        // TODO Auto-generated method stub
        if(realImage==null)
      {
        realImage = new RealImage(file);
      }
       realImage.display();
    }
  
}
public class VirtualProxy {
    public static void main(String[] args) {
        Image imageProxy= new ImageProxy("flower.png");
        imageProxy.display();
    }
}

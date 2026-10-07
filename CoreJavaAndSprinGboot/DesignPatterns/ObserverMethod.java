package CreationOfThreads;

import java.util.ArrayList;

interface IObserver {

    void update();
    
}
 interface IObservable {
 public void add(IObserver iObserver);
 public void remove(IObserver iObserver);
 public void notifying();
    
}
class ConcreteObservable implements IObservable{
      ArrayList<IObserver> List= new ArrayList<>();
      String videoName;
      public void ConcreteObservable(){

      }
      public  ConcreteObservable(ArrayList<IObserver> List,String videoName){
      this.List=List;
      this.videoName=videoName;
      }
      public void add(IObserver iObserver){
      List.add(iObserver);
      System.out.println("Subscriber Added");
      }
      public void remove(IObserver iObserver){
      List.remove(iObserver);
      System.out.println("Subsrciber removed");
      }
      public void addVideo(String video){
        videoName=video;
        System.out.println("new video is added");
      }
      public String getVideo(){
        
        return videoName;
      }
      public void notifying(){
      for (int i = 0; i < List.size(); i++) {
        List.get(i).update();
      }
      }
}
class ConcreteObserver implements IObserver{
    String name;
    ConcreteObservable concreteObservable;
     public ConcreteObserver(String name,ConcreteObservable concreteObservable){
      this.name=name;
      this.concreteObservable=concreteObservable;
     }   
    public void update(){
    System.out.println(name+concreteObservable.getVideo()+" added");
    }
}
public class ObserverMethod {
   public static void main(String[] args) {

    ConcreteObservable observable =
            new ConcreteObservable(new ArrayList<>(), "");

    ConcreteObserver o1 =
            new ConcreteObserver("Ram", observable);

    ConcreteObserver o2 =
            new ConcreteObserver("Shyam", observable);

    ConcreteObserver o3 =
            new ConcreteObserver("Aman", observable);

    observable.add(o1);
    observable.add(o2);
    observable.add(o3);

    observable.addVideo("Video 1");

    observable.notifying();
}
}

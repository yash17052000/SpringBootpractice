package CreationOfThreads;

interface Itertor{
    boolean hasNext();
    String next();
}
class SongIterator implements Itertor{
 private String  songs[];
 public SongIterator (String songs[]){
    this.songs=songs;
 }
  int index =0;
    @Override
    public boolean hasNext() {
        
        return index<songs.length;
    }

    @Override
    public String next() {
        // TODO Auto-generated method stub
        return songs[index++];
    }
    
}
class SongCollection {
    private String songs[]={"A","B","C","D"};

      public Itertor createIterator(){
      return new SongIterator(songs);
    }
} 

public class IteratorDesignpattern {
public static void main(String[] args) {
    SongCollection songCollection= new SongCollection();
   Itertor itertor= songCollection.createIterator();
    while (itertor.hasNext()) {
        System.out.println(itertor.next());
    }
}    
}

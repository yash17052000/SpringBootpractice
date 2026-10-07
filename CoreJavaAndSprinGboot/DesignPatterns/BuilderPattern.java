package CreationOfThreads;

/**
 * When the end result is immutable, but doing it all with a constructor would be too complicated
When I want to partially build something and reuse that partially built thing, but customize it at the end each time
When you start with the factory pattern, but the thing being built by the factory has too many permutations
 */
class Student {
private final String name;
private final int age;

private Student (Builder builder){
 this.age=builder.age;
 this.name=builder.name;
}

static class Builder  {
  
    private String name;
    private int age;

     Builder(String name){
        this.name=name;
    }
    Builder age(int age){
        this.age=age;
        return this;
    }
    public Student build(){
        return new Student(this);
    }
    
}

public void display(){
    System.out.println(name+age);
}
    
}
public class BuilderPattern {
    public static void main(String[] args) {
        Student student= new Student.Builder("yash").age(16).build();
        student.display();
    }
}

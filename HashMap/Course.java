package HashMap;

import java.util.Objects;

public class Course {
    int id;
    String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    According to the Java Language Specification, there is a contract between equals(Object) and hashCode():
    If two objects are equal according to the equals(Object) method, then calling the hashCode method
    on each of the two objects must produce the same integer result.
    It is not required that if two objects are unequal according to the equals(java.lang.Object)
    method, then calling the hashCode method on each of the two objects must produce distinct integer results.
    However, the programmer should be aware that producing distinct integer results for unequal
    objects may improve the performance of hashtables.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass()!= o.getClass()) return false;
        Course that = (Course) o;
        return id == that.id && Objects.equals(name, that.name);
    }
    public int hashCode(){
        return Objects.hash(id,name);
    }
    @Override
    public String toString() {
        return "{" + "'Id':" +id + ", 'Name':"+ name +"}";
    }
}

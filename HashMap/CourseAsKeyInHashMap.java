package HashMap;

import java.util.HashMap;

public class CourseAsKeyInHashMap {
    public static void main(String[] args){
        Course c1 = new Course(123,"Java");
        Course c2 = new Course(234,"Python");
        Course c3 = new Course(123, "Java8");
        Course c4 = new Course(123, "Java8");

        HashMap<Course, String> map = new HashMap<>();
        map.put(c1, "Java Multithreading feature");
        map.put(c2, "Tuple feature");
        map.put(c3, "Java8 feature");
        map.put(c4, "Java8 feature");
        System.out.println(map);
    }
}

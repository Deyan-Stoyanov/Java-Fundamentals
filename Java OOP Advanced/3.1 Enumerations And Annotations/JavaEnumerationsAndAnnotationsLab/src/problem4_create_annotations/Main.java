package problem4_create_annotations;

import java.lang.annotation.Annotation;

@Subject(categories = {"first", "second"})
public class Main {
    public static void main(String[] args) {
        Subject subject = Main.class.getAnnotation(Subject.class);
        Annotation[] annotations = Main.class.getAnnotations();
        for (String category : subject.categories()) {
            System.out.println(category);
        }
    }
}

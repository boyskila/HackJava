@ClassInfo(author = "Boyko", isChecked = true, related = {Boolean.class, String.class, Integer.class, AnnotationTestClass.class })
public class AnnotationTestClass {
    public static void main(String[] args) {
        AnnotationTestClass ac = new AnnotationTestClass();
        ClassInfo classInfo = ac.getClass().getAnnotation(ClassInfo.class);
        System.out.println(ac.getClass().getAnnotation(ClassInfo.class));
        System.out.println("Author: " + classInfo.author());
        System.out.println("Revised times: " + classInfo.revision());
        System.out.println("Checked: " + classInfo.isChecked());
        Class<?>[] related = classInfo.related();
        for (Class<?> class1 : related) {
            System.out.println(class1);
        }
    }
}

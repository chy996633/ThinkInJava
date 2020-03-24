/**
 * 测试引用类型在方法参数中的传递方式 ： 按值传递
 */
public class ReferenceTest {

    public static void main(String[] args) {

        Student s1 = new Student("a");
        Student s2 = new Student("b");

        ReferenceTest rt = new ReferenceTest();
        rt.changeRef(s1);

        // should be a
        System.out.println(s1.name);

        rt.swap(s1, s2);

        // should be a , b

        System.out.println(s1.name);
        System.out.println(s2.name);

    }

    public void swap(Student s1, Student s2) {
        Student temp = s1;
        s1 = s2;
        s2 = temp;
    }

    public void changeRef(Student s1) {
        s1 = new Student("another");
    }


}

class Student {
    public String name;

    public Student(String name) {
        this.name = name;
    }
}

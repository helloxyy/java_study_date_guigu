/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-06-16 16:59:16
 */
public class Student {
    private int id;
    private String className;
    private String name;

    public Student() {
    }

    public Student(int id, String className, String name) {
        this.id = id;
        this.className = className;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号是：" + id +
                ", 班级是：'" + className + '\'' +
                ", 姓名是： '" + name + '\'' +
                '}';
    }
}

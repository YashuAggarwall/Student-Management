public class Student {
    private String id;
    private  String name;
    private int age;
    private String grade;
//CONSTRUCTOR
    public Student(String id, String name, int age, String grade){
        this.id=id;
        this.age=age;
        this.name=name;
        this.grade=grade;
    }
//    GETTER SETTER


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "ID: "+id + ", Name: "+name + ", Age: "+age+ ", Grade: " + grade;
    }
}

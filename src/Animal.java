public class Animal {
    protected String name;
    protected int age;

    int getAge(){
        return age;
    }

    void setAge(int age){
        if (age > 0 && age < 99){
            this.age = age;
        }
    }
}

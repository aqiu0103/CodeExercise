public class method01 {
    public static void main(String[] args) {
        Person person1=new Person();
        person1.age=10;
        person1.name="哈哈哈哈";
        person1.Speak();
        person1.Sum(4,7);
    }
}

class Person {
    int age;
    String name;//属性

    public void Speak() {
        System.out.println("我是一个好人");
    }

    public void Sum(int a,int b){
        int sum;
        sum=a+b;
        System.out.println("两数之和为"+sum);
    }

}
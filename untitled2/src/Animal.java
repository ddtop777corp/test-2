public class Animal {
    public static void main(String[] args) {
        Cat cat = new CatBuilderImpl().setName("Bob").setAge(22).setSalary(60000).build();
        cat.print();
    }
}
class Cat {
    String name;
    int age;
    double salary;

    public void print() {
        System.out.println(name + " " + age + " " + salary);
    }
}
//test PR
interface CatBuilder {
    CatBuilder setName(String name);

    CatBuilder setAge(int age);

    CatBuilder setSalary(double salary);

    Cat build();
}

class CatBuilderImpl implements CatBuilder {
    Cat cat = new Cat();

    @Override
    public CatBuilder setName(String name) {
        cat.name = name;
        return this;
    }

    @Override
    public CatBuilder setAge(int age) {
        cat.age = age;
        return this;
    }

    @Override
    public CatBuilder setSalary(double salary) {
        cat.salary = salary;
        return this;
    }

    @Override
    public Cat build() {
        return cat;
    }
}
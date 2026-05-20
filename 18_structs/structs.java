class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name) {
        this.name = name;
        this.age = 0;
    }

    @Override
    public String toString() {
        return "{" + name + " " + age + "}";
    }
}

Person newPerson(String name) {
    Person p = new Person(name);
    p.age = 42;
    return p;
}

void main() {
    System.out.println(new Person("Bob", 20));
    System.out.println(new Person("Alice", 30));
    System.out.println(new Person("Fred"));
    System.out.println(new Person("Ann", 40));
    System.out.println(newPerson("Jon"));

    Person s = new Person("Sean", 50);
    System.out.println(s.name);

    Person sp = s;
    System.out.println(sp.age);

    sp.age = 51;
    System.out.println(sp.age);
}

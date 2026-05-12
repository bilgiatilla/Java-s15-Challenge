package entitiy;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void whoYouAre () {
        System.out.println("I am a person. My name is " + name);
    }
}

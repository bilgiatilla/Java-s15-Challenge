package entity;

public abstract class Person {
    private Long personId;
    private String name;

    public Person(Long personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }
    public void whoYouAre () {}
}

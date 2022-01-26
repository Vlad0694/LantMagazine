package LantDeMagazine;

public class Person {
    private String name;
    private String surname;
    private int id;

    Person(String name, String surname, int id){
        this.name = name;
        this.surname = surname;
        this. id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setId(int id) {
        this.id = id;
    }

}

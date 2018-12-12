package FIFOAnimalShelter;

public class Animal {
    public String name;
    public int age;
    public String color;

    public Animal() {
        this.name = "Nameless";
        this.color = "Unknown";
    }

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}

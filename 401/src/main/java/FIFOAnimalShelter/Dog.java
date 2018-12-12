package FIFOAnimalShelter;

public class Dog extends Animal {
    public boolean barks;

    public Dog(String name, int age, String color, boolean barks) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.barks = barks;
    }
}

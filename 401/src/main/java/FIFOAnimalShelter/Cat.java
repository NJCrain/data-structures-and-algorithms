package FIFOAnimalShelter;

public class Cat extends Animal {
    public boolean hasClaws;

    public Cat(String name, int age, String color, boolean hasClaws) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.hasClaws = hasClaws;
    }
}

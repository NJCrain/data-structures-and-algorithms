package FIFOAnimalShelter;

import stacksandqueues.Queue;

public class FIFOAnimalShelter {

    public Queue<Cat> catQueue;
    public  Queue<Dog> dogQueue;

    public FIFOAnimalShelter() {
        this.catQueue = new Queue<>();
        this.dogQueue = new Queue<>();
    }

    public void enqueue(Animal toAdd) {
        if (toAdd instanceof Cat) {
            catQueue.enqueue((Cat) toAdd);
        } else {
            dogQueue.enqueue((Dog) toAdd);
        }
    }

    public Animal dequeue(String pref) {
        if(pref.toLowerCase() == "cat") {
            return catQueue.dequeue();
        } else if (pref.toLowerCase() == "dog") {
            return dogQueue.dequeue();
        } else {
            return null;
        }
    }
}

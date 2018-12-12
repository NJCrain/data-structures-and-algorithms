package FIFOAnimalShelter;

import stacksandqueues.Queue;

public class FIFOAnimalShelter {

    public Queue<Cat> catQueue;
    public  Queue<Dog> dogQueue;

    public FIFOAnimalShelter() {
        this.catQueue = new Queue<>();
        this.dogQueue = new Queue<>();
    }

    //Checks to see what type of animal is being enqueued and adds it to the appropriate queue
    public void enqueue(Animal toAdd) {
        if (toAdd instanceof Cat) {
            catQueue.enqueue((Cat) toAdd);
        } else {
            dogQueue.enqueue((Dog) toAdd);
        }
    }

    //Determines the preference for which Animal to dequeue, and then returns the dequeued Animal from the appropriate queue
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

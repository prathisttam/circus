package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Elephant;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

import static circus.animal.Animal.AnimalNameComparator;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Animal length " + animals.length);

        ArrayList<Animal> animalList = new ArrayList<>(Arrays.asList(animals));

        Parrot perry = new Parrot("Perry");
        animalList.add(perry);
        animalList.add(new Elephant("Brute")); // we don't have object reference for this --> no pointer
        Duck andy = new Duck("Andy");
        animalList.add(andy);
        // substitutability allows to add specific animals to "Animal" array list
        System.out.println("Before sorting:");
        printAnimals(animalList);

        System.out.println("Size of array List: " + animalList.size());

        System.out.println("Perry is in position " + animalList.indexOf(perry));
        animalList.sort(AnimalNameComparator);

        System.out.println("After sorting:");
        printAnimals(animalList);

        //        makeAnimalsTalk();
        //        System.out.println("Total value of animals " + calculateAssetValue(animals));
        //        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }

    private static void printAnimals(ArrayList<Animal> animalList) {
        for(Animal a : animalList) {
            System.out.println(a);
        }
    }
}

package org.example;
import java.util.*;
public class Zoo {
    private static List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
        // Add at least 2 kinds of animals for each type
        animals.add(new Mammal("Elephant", "Trumpeting", "Large herbivore"));
        animals.add(new Mammal("Monkey", "Chattering", "Tree-dwelling primate"));
        animals.add(new Amphibian("Frog", "Croaking", "Amphibious creature"));
        animals.add(new Amphibian("Salamander", "Hissing", "Slender amphibian"));
        animals.add(new Reptile("Snake", "Hissing", "Slithering reptile"));
        animals.add(new Reptile("Turtle", "Hissing", "Shelled reptile"));
    }
    public static boolean removeAnimal(String name) {
            for (Animal animal : animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    animals.remove(animal);
                    return true; // Animal found and removed
                }
            }
            return false; // Animal not found
        }

    public static boolean isValidAnimalType(String type) {
        return type.equals("Mammal") || type.equals("Reptile") || type.equals("Amphibian");
    }

    public static void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public static List<Animal> getAnimals() {
        return animals;
    }
}


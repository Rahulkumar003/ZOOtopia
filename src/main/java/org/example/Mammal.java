package org.example;

public class Mammal implements Animal {
    private  String name;
    private final String type="Mammal";
    private  String sound;
    private  String description;

    public Mammal(String name, String sound, String description) {
        this.name = name;
        this.sound = sound;
        this.description = description;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSound() {
        return sound;
    }

    @Override
    public String getDescription() {
        return description;
    }
    // Specific Mammal-related attributes and methods
}

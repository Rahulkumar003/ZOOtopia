package org.example;

public class Reptile implements Animal {
    private  String name;
    private final String type="Reptile";
    private  String sound;
    private  String description;

    public Reptile(String name, String sound, String description) {
        this.name = name;
        this.sound = sound;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // Specific Reptile-related attributes and methods
}

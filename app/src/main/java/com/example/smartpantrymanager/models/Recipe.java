package com.example.smartpantrymanager.models;

public class Recipe {
    private int id;
    private String title;
    private String instructions;

    public Recipe(int id, String title, String instructions) {
        this.id = id;
        this.title = title;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}

package com.company;

public enum TypesOfSides {
    Equilateral,
    Isosceles,
    Versatile;

    @Override
    public String toString() {
        switch (this) {
            case Equilateral:
                return "Равносторонний";
            case Isosceles:
                return "Равнобедренный";
            default:
                return "Разносторонний";
        }
    }
}

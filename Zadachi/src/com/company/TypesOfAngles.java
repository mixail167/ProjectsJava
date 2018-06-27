package com.company;

public enum TypesOfAngles {
    Rectangular,
    Obtuse,
    Acute;

    @Override
    public String toString() {
        switch (this) {
            case Rectangular:
                return "Прямоугольный";
            case Obtuse:
                return "Тупоугольный";
            default:
                return "Остроугольный";
        }
    }
}

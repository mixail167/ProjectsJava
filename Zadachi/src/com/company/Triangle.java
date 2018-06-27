package com.company;

public class Triangle {
    private int a;
    private int b;
    private int c;
    private TypesOfSides typeOfSides;
    private TypesOfAngles typeOfAngles;

    int getA() {
        return a;
    }

    int getB() {
        return b;
    }

    int getC() {
        return c;
    }

    boolean IsEquilateral() {
        return a == b && a == c;
    }

    Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    boolean Check() {
        return a + b > c && a + c > b && b + c > a;
    }

    boolean IsIsosceles() {
        return a == b && a != c;
    }

    boolean IsRectangular() {
        return a * a + b * b == c * c;
    }

    boolean IsObtuse() {
        return a * a + b * b < c * c;
    }

    boolean IsAcute() {
        return a * a + b * b > c * c;
    }

    TypesOfSides GetTypeOfSides() {
        Triangle triangle2 = new Triangle(this.b, this.c, this.a);
        Triangle triangle3 = new Triangle(this.c, this.a, this.b);
        if (this.IsEquilateral())
            typeOfSides = TypesOfSides.Equilateral;
        else if (this.IsIsosceles() || triangle2.IsIsosceles() || triangle3.IsIsosceles())
            typeOfSides = TypesOfSides.Isosceles;
        else typeOfSides = TypesOfSides.Versatile;
        return typeOfSides;
    }

    TypesOfAngles GetTypeOfAngle() {
        Triangle triangle2 = new Triangle(this.b, this.c, this.a);
        Triangle triangle3 = new Triangle(this.c, this.a, this.b);
        if (this.IsRectangular() || triangle2.IsRectangular() || triangle3.IsRectangular()) {
            typeOfAngles = TypesOfAngles.Rectangular;
        } else if (this.IsObtuse() || triangle2.IsObtuse() || triangle3.IsObtuse()) {
            typeOfAngles = TypesOfAngles.Obtuse;
        } else typeOfAngles = TypesOfAngles.Acute;
        return typeOfAngles;
    }
}


package com.company;

class Decimal {
    int numerator;
    int denominator;

    Decimal(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    int getNumerator() {
        return numerator;
    }

    void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    int getDenominator() {
        return denominator;
    }
}

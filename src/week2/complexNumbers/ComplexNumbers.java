package week2.complexNumbers;

public class ComplexNumbers {
    private double realPart;
    private double imaginaryPart;

    ComplexNumbers(double realPart) {
        this.realPart = realPart;
    }
    ComplexNumbers(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumbers addTo(ComplexNumbers another) {
        double realPart = this.realPart + another.realPart;
        double imaginaryPart = this.imaginaryPart + another.imaginaryPart;
        return new ComplexNumbers(realPart, imaginaryPart);
    }

    public ComplexNumbers subtract(ComplexNumbers another) {
        double realPart = this.realPart - another.realPart;
        double imaginaryPart = this.imaginaryPart - another.imaginaryPart;
        return new ComplexNumbers(realPart, imaginaryPart);
    }

    public ComplexNumbers multiplyBy(ComplexNumbers another) {
        double realPart = (this.realPart * another.realPart) - (this.imaginaryPart * another.imaginaryPart);
        double imaginaryPart = (this.realPart * another.imaginaryPart) + (another.realPart * this.imaginaryPart);
        return new ComplexNumbers(realPart, imaginaryPart);
    }

    public double getModule() {
        return Math.sqrt(this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart);
    }

    @Override
    public String toString() {
        if (this.imaginaryPart < 0)
            return this.realPart + " - " + -this.imaginaryPart + "i";
        return this.realPart + " + " + this.imaginaryPart + "i";
    }
}

package week2.complexNumbers;

public class ComplexNumbersImpl implements ComplexNumbers{
    private double realPart;
    private double imaginaryPart;

    ComplexNumbersImpl(double realPart) {
        this.realPart = realPart;
    }
    ComplexNumbersImpl(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }
    @Override
    public ComplexNumbersImpl addTo(ComplexNumbersImpl another) {
        double realPart = this.realPart + another.realPart;
        double imaginaryPart = this.imaginaryPart + another.imaginaryPart;
        return new ComplexNumbersImpl(realPart, imaginaryPart);
    }

    @Override
    public ComplexNumbersImpl subtract(ComplexNumbersImpl another) {
        double realPart = this.realPart - another.realPart;
        double imaginaryPart = this.imaginaryPart - another.imaginaryPart;
        return new ComplexNumbersImpl(realPart, imaginaryPart);
    }

    @Override
    public ComplexNumbersImpl multiplyBy(ComplexNumbersImpl another) {
        double realPart = (this.realPart * another.realPart) - (this.imaginaryPart * another.imaginaryPart);
        double imaginaryPart = (this.realPart * another.imaginaryPart) + (another.realPart * this.imaginaryPart);
        return new ComplexNumbersImpl(realPart, imaginaryPart);
    }

    @Override
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

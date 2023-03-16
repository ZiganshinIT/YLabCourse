package week2.complexNumbers;

public interface ComplexNumbers {
    /**
     * суммирует к значению объекта значение, переданное в параметре
     * @param another объект ComplexNumbersImpl
     * @return новый объект ComplexNumbersImpl
     */
    ComplexNumbersImpl addTo(ComplexNumbersImpl another);

    /**
     * вычитает из значения объекта значение объекта, переданного в параметре
     * @param another объект ComplexNumbersImpl
     * @return новый объект ComplexNumbersImpl
     */
    ComplexNumbersImpl subtract(ComplexNumbersImpl another);

    /**
     * умножает значение объекта значение, переданное в параметре
     * @param another объект ComplexNumbersImpl
     * @return новый объект ComplexNumbersImpl
     */
    ComplexNumbersImpl multiplyBy(ComplexNumbersImpl another);

    /**
     * Возращает модуль числа
     * @return модуль числа
     */
    double getModule();
}

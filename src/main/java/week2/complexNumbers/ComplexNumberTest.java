package week2.complexNumbers;
public class ComplexNumberTest {

    public static void main(String[] args) {
        ComplexNumbersImpl cn = new ComplexNumbersImpl(4);
        ComplexNumbersImpl cn2 = new ComplexNumbersImpl(3, 5);
        ComplexNumbersImpl cn3 = new ComplexNumbersImpl(1, -6);

        System.out.println(cn);
        System.out.println(cn2);
        System.out.println(cn3);
        System.out.println();

        ComplexNumbersImpl result1 = cn.addTo(cn2);
        ComplexNumbersImpl result2 = cn2.subtract(cn3);
        ComplexNumbersImpl result3 = cn3.multiplyBy(cn);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println();

        double numModule = cn2.getModule();
        System.out.println(numModule);
    }
}

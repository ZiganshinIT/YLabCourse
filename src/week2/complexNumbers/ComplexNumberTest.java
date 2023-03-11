package week2.complexNumbers;
public class ComplexNumberTest {

    public static void main(String[] args) {
        ComplexNumbers cn = new ComplexNumbers(4);
        ComplexNumbers cn2 = new ComplexNumbers(3, 5);
        ComplexNumbers cn3 = new ComplexNumbers(1, -6);

        System.out.println(cn);
        System.out.println(cn2);
        System.out.println(cn3);
        System.out.println();

        ComplexNumbers result1 = cn.addTo(cn2);
        ComplexNumbers result2 = cn2.subtract(cn3);
        ComplexNumbers result3 = cn3.multiplyBy(cn);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println();

        double numModule = cn2.getModule();
        System.out.println(numModule);
    }
}

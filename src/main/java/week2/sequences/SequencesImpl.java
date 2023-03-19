package week2.sequences;

public class SequencesImpl implements Sequences{
    @Override
    public void a(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.print((i * 2) + " ");
        }
        System.out.println();
    }

    @Override
    public void b(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.print((2 * i - 1) + " ");
        }
        System.out.println();
    }

    @Override
    public void c(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.print((i * i) + " ");
        }
        System.out.println();
    }

    @Override
    public void d(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.print((i * i * i) + " ");
        }
        System.out.println();
    }

    @Override
    public void e(int n) {
        for(int i = 1, j = 1; i <= n; i++, j = -j) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    @Override
    public void f(int n) {
        for(int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print("-");
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public void g(int n) {
        for(int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                System.out.print("-");
            System.out.print((i * i) + " ");
        }
        System.out.println();
    }

    @Override
    public void h(int n) {
        for (int i = 1, j = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(0 + " ");
                j++;
            } else {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void i(int n) {
        for (int i = 1, j = 1; i <= n; i++, j *= i) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    @Override
    public void j(int n) {
        int previousNumber = 1;
        int nextNumber = 1;
        for(int i = 1; i <= n; i++) {
            System.out.print(previousNumber + " ");
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }
        System.out.println();
    }
}

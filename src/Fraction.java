public class Fraction {
    private int num;
    private int den;

    public Fraction(int n, int d) {
        if(d == 0) {
            throw new ArithmeticException();
        }
        num = n;
        den = d;
    }

    public boolean equals(Fraction fraction) {
        return this.den * fraction.num == this.num * fraction.den;
    }

    public String toString() {
        return Integer.toString(num) + " / " + Integer.toString(den);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }
}

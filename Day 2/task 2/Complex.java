package practice;

public class Complex {
    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public Complex add(Complex complex ){
        return new Complex(this.re + complex.re,
                this.im + complex.im);
    }

    public Complex sub(Complex complex ){
        return new Complex(this.re - complex.re,
                this.im - complex.im);
    }

    public Complex mul(Complex complex ){
        return new Complex(this.re * complex.re - this.im * complex.im,
                this.re * complex.im + complex.re * this.im);
    }
    public void print () {
        if (im < 0)
            System.out.println(re + "" + im + "i");
        else
            System.out.println(re + "+" + im + "i");
    }
}

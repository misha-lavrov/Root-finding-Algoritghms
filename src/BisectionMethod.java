public class BisectionMethod {
    private Function f;
    private double a;
    private double b;
    private double error;

    public BisectionMethod(Function f, double a, double b, double error){
        this.f = f;
        this.a = a;
        this.b = b;
        this.error = error;
    }

    public void solve(){
        double a = this.a,
                b = this.b,
                c = (a + b) / 2,
                error = this.error;
        int step = 1;
        print();
        while(Math.abs(b - a) >= error){
            print(step, a, b, c, error);
            if(f.apply(a) * f.apply(c) < 0){
                b = c;
            }else{
                a = c;
            }
            c = (a + b) / 2;
            step++;
        }
        print(step, a, b, c, error);
        print(c);
    }

    private void print(int step, double a, double b, double c, double error){
        System.out.println(String.format(
                "|%4d||%9.4f|%9.4f|%9.4f||%9.4f|%9.4f|%9.4f||%9.4f|",
                step, a, c, b, f.apply(a), f.apply(c), f.apply(b), Math.abs(b - a)));
    }

    private void print(double result){
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println(String.format("Result: x = %.4f\t\tf(x) = %.4f", result, f.apply(result)));
        System.out.println();
    }

    private void print(){
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|                            Bisection Method                                 |");
        System.out.println("|-----------------------------------------------------------------------------|");
        System.out.println("|step||    a    |    c    |    b    ||   f(a)  |   f(c)  |   f(b)  ||  error  |");
        System.out.println("|-----------------------------------------------------------------------------|");
    }

}

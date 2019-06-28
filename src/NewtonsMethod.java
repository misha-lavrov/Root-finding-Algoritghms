public class NewtonsMethod {
    private Function f;
    private Function f1;
    private Function f2;
    private double a;
    private double b;
    private double error;

    public NewtonsMethod(Function f, Function f1, Function f2, double a, double b, double error){
        this.f = f;
        this.f1 = f1;
        this.f2 = f2;
        this.a = a;
        this.b = b;
        this.error = error;
    }

    public void solve(){
        double x, prev;
        int step = 1;
        print();
        if(f.apply(a) * f2.apply(a) > 0){
            x = a;
        }else{
            x = b;
        }

        do {
            prev = x;
            x = prev - f.apply(prev) / f1.apply(prev);
            print(step, x, prev, f.apply(prev), f1.apply(prev), Math.abs(x - prev));
            step++;
        } while(Math.abs(x - prev) >= error);
        print(x);
    }

    private void print(int step, double x, double prev, double f, double f1, double error){
        System.out.println(String.format("|%5d||%9.4f|%9.4f|%9.4f|%9.4f||%9.4f|", step, x, prev, f, f1, error));
    }

    private void print(double result){
        System.out.println("|---------------------------------------------------------|");
        System.out.println(String.format("Result: x = %.4f\t\tf(x) = %.4f", result, f.apply(result)));
        System.out.println();
    }

    private void print(){
        System.out.println("|---------------------------------------------------------|");
        System.out.println("|                    Newton's Method                      |");
        System.out.println("|---- ----------------------------------------------------|");
        System.out.println("|step ||    x    |   prev  | f(prev) | f1(prev)||  error  |");
        System.out.println("|---------------------------------------------------------|");
    }
}

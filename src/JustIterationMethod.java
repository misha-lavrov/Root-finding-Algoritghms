public class JustIterationMethod {
    private Function f;
    private Function g;
    private double a;
    private double b;
    private double error;

    public JustIterationMethod(Function f, Function g, double a, double b, double error){
        this.f = f;
        this.g = g;
        this.a = a;
        this.b = b;
        this.error = error;
    }

    public void solve(){
        double x = a, prev, delta;
        int step = 1;
        print();
        do{
            prev = x;
            x = g.apply(prev);
            print(step, x, prev);
            step++;
        }while(Math.abs(x - prev) >= error);
        print(x);
    }

    private void print(int step, double x, double prev){
        System.out.println(String.format("|%5d||%9.4f|%9.4f||%9.4f|", step, x, prev, Math.abs(x - prev)));
    }

    private void print(double result){
        System.out.println("|-------------------------------------|");
        System.out.println(String.format("Result: x = %.4f\t\tf(x) = %.4f", result, f.apply(result)));
        System.out.println();
    }

    private void print(){
        System.out.println("|-------------------------------------|");
        System.out.println("|       Just Iteration Method         |");
        System.out.println("|-------------------------------------|");
        System.out.println("|step ||    x    |   prev  ||  error  |");
        System.out.println("|-------------------------------------|");
    }
}

public class Main {
    public static void main(String[] args) {
        Function f = (x) -> Math.pow(x, 5) + 4 * x + 4;
        Function g = (x) -> x - 0.1 * f.apply(x);
        Function f1 = (x) -> 5 * Math.pow(x, 4) + 4;
        Function f2 = (x) -> 20 * Math.pow(x, 3);
        double a = -2;
        double b = 2;
        double error = 0.001;

        BisectionMethod bisectionMethod = new BisectionMethod(f, a, b, error);
        NewtonsMethod newtonsMethod = new NewtonsMethod(f, f1, f2, a, b, error);
        JustIterationMethod justIterationMethod = new JustIterationMethod(f, g, a, b, error);

        bisectionMethod.solve();
        newtonsMethod.solve();
        justIterationMethod.solve();
    }
}

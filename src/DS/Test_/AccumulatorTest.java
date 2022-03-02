package DS.Test_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class AccumulatorTest {
    public static void main(String[] args) {
        int T = 100000;
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++) {
            a.addValue(Math.random());
        }
        System.out.println(a);
    }
}

class Accumulator {
    private double total;
    private int N;

    public void addValue(double val) {
        N++;
        total += val;
    }
    public double mean() {
        return total/N;
    }

    @Override
    public String toString() {
        return "Mean(" + N + " values): " + String.format("%7.5f", mean());
    }
}

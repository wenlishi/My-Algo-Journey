public class Solution_NewtonIterationMethod {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double x0 = 1;
        double xn = 0;
        while (true) {
            xn = 0.5 * (x0 + x / x0);
            if (Math.abs(xn - x0) < 1e-7) {
                break;
            }
            x0 = xn;
        }
        return (int) xn;
    }

}
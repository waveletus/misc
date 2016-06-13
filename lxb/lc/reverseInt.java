/**
 * Created by lxb on 6/12/16.
 */
public class reverseInt {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;

        // to handle overflow
        long m = 0;
        x = Math.abs(x);
        while (x > 0) {
            m = x % 10 + m * 10;
            x = x / 10;
        }

        // overflow
        if (m > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) m * sign;
    }
}

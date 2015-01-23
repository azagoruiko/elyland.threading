package elyland.threading;

public class FibCalcImpl implements FibCalc, Runnable {
    private final int n;

    public FibCalcImpl(int n) {
        this.n = n;
    }
    
    @Override
    public long fib(int n) {
        if (n == 0 || n == 1) return 0;
        long res = 1;
        long prev = 0;
        for (int i = 2; i <= n; i++) {
            res += prev;
            prev = res - prev;
        }
        return res;
    }
    
    @Override
    public void run() {
        fib(n);
    }
    
}

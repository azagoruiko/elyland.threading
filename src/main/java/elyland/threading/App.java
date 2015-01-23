package elyland.threading;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        int n = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);
        int poolSize = Integer.parseInt(args[2]);
        
        PerformanceTester tester = new PerformanceTestImpl();
        PerformanceTestResult res = tester.runPerformanceTest(new FibCalcImpl(n), count, poolSize);
        System.err.println(res);
        System.exit(0);
    }
}

package elyland.threading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PerformanceTestImpl implements PerformanceTester{
    private class MeasuringCallable implements Callable<Long> {
        private final Runnable task;

        public MeasuringCallable(Runnable task) {
            this.task = task;
        }
        
        @Override
        public Long call() throws Exception {
            long startTime = System.currentTimeMillis();
            Thread.sleep(1);
            task.run();
            return System.currentTimeMillis() - startTime;
        }
        
    }
    @Override
    public PerformanceTestResult runPerformanceTest(Runnable task, 
            int executionCount, int threadPoolSize) throws InterruptedException {
        
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<Long>> execTimes = new LinkedList<>();
        for (int i = 0; i < executionCount; i++) {
            execTimes.add(executor.submit(new MeasuringCallable(task)));
        }
        
        long totalTime = 0l, minTime = Long.MAX_VALUE, maxTime = 0l;
        
        for (Future<Long> future : execTimes) {
            try {
                long time = future.get();
                totalTime += time;
                minTime = Math.min(time, minTime);
                maxTime = Math.max(time, maxTime);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }
        
        PerformanceTestResult res = new PerformanceTestResult(totalTime, minTime, maxTime);
        return res;
    }
    
}

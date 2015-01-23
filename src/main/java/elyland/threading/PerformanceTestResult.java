package elyland.threading;

/**
 * Stores the result of a performance test.
 * All values are in milliseconds.
 */
public class PerformanceTestResult {
	private final long totalTime;
	private final long minTime;
	private final long maxTime;
	
	public PerformanceTestResult(long totalTime, long minTime, long maxTime) {
		this.totalTime = totalTime;
		this.minTime = minTime;
		this.maxTime = maxTime;
	}
	/**
	 * How long the longest single execution took.
	 */
	public long getMaxTime() {
		return maxTime;
	}
	/**
	 * How long the shortest single execution took.
	 */
	public long getMinTime() {
		return minTime;
	}
	/**
	 * How long the whole performance test took in total.
	 */
	public long getTotalTime() {
		return totalTime;
	}
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Total time:\t");
            sb.append(totalTime);
            sb.append("\n");
            sb.append("Minimum time:\t");
            sb.append(minTime);
            sb.append("\n");
            sb.append("Maximim time:\t");
            sb.append(maxTime);
            sb.append("\n");
            return sb.toString();
        }
	
}

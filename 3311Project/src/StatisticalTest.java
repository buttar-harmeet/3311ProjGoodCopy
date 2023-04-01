


import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math4.legacy.stat.descriptive.rank.Percentile.*;


public class StatisticalTest {

    public static void main(String[] args) {
        double[] data = {1.2, 2.1, 3.5, 4.3, 5.8, 6.4, 7.9, 8.2, 9.1, 10.0};

        // Get a DescriptiveStatistics instance
        DescriptiveStatistics stats = new DescriptiveStatistics();

        // Add the data from the array
        for (int i = 0; i < data.length; i++) {
            stats.addValue(data[i]);
        }

        // Compute some statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();

        System.out.println(mean);
        System.out.println(std);


    }
}
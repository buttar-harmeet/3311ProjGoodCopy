import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class MachineTest {
    public static void main(String[] args) throws Exception {
        // Load data
        Instances data = DataSource.read("path/to/data.arff");
        data.setClassIndex(data.numAttributes() - 1);

        // Create classifier
        J48 classifier = new J48();
        classifier.buildClassifier(data);

        // Make predictions
        Instances testData = DataSource.read("path/to/test_data.arff");
        testData.setClassIndex(testData.numAttributes() - 1);
        for (int i = 0; i < testData.numInstances(); i++) {
            double prediction = classifier.classifyInstance(testData.instance(i));
            System.out.println("Prediction: " + prediction);
        }
    }
}






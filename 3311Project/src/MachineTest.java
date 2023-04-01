import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.Instances;
import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.trees.J48;

public class MachineTest {
    public static void main(String[] args) throws Exception {

        // Load the CSV file using Weka's built-in CSV loader
        BufferedReader reader = new BufferedReader(new FileReader("18100205.csv"));
        Instances data = new Instances(reader);
        reader.close();

        // Set the class attribute (the attribute to be predicted)
        data.setClassIndex(data.numAttributes() - 1);

        // Choose a classifier (for example, J48 decision tree or Linear Regression)
        Classifier classifier = new J48(); // or new LinearRegression();

        // Train the classifier using the data
        classifier.buildClassifier(data);

        // Make predictions for new data
        BufferedReader newDataReader = new BufferedReader(new FileReader("new_data.csv"));
        Instances newData = new Instances(newDataReader);
        newDataReader.close();
        newData.setClassIndex(newData.numAttributes() - 1);
        for (int i = 0; i < newData.numInstances(); i++) {
            double predictedClass = classifier.classifyInstance(newData.instance(i));
            System.out.println("Predicted class for instance " + (i+1) + ": " + predictedClass);
        }
    }
}

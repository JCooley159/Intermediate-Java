import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class kkkCapitolQuiz {

    ArrayList<Integer> fifty = new ArrayList();

    public void generateQuiz() {

        for (int i = 0; i < 50; i++) {
            fifty.add(i);
        }
        Collections.shuffle(fifty);
    }

    private String[][] stateCapitals;

    public String[][] createReferenceArray() throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        File file = new File("states.xml");
        FileInputStream stream = new FileInputStream(file);
        InputSource source = new InputSource(stream);
        // grab all states from XML file, we are using XPath expressions //state for
        // state tags
        // https://blog.scrapinghub.com/2016/10/27/an-introduction-to-xpath-with-examples
        XPathExpression expr = xpath.compile("//state");
        NodeList states = (NodeList) expr.evaluate(source, XPathConstants.NODESET);
        FileInputStream stream2 = new FileInputStream(file);
        InputSource source2 = new InputSource(stream2);
        XPathExpression expr2 = xpath.compile("//capital");
        NodeList capitals = (NodeList) expr2.evaluate(source2, XPathConstants.NODESET);

        stateCapitals = new String[50][2];
        for (int i = 0; i < states.getLength(); i++) {
            Node state = states.item(i);
            Node capital = capitals.item(i);
            stateCapitals[i][0] = state.getTextContent();
            stateCapitals[i][1] = capital.getTextContent();
        }
        return stateCapitals;
    }

    public String getState(int i) {
        return stateCapitals[fifty.get(i)][0];
    }

    public String getCapitol(int i) {
        return stateCapitals[fifty.get(i)][1];
    }

    public ArrayList<String> getAnswers(int i) {
        ArrayList<String> answers = new ArrayList();

        answers.add(getCapitol(i));
        answers.add(getCapitol(i + 10));
        answers.add(getCapitol(i + 20));
        answers.add(getCapitol(i + 30));
        answers.add(getCapitol(i + 40));
        Collections.shuffle(answers);
        return answers;
    }

    public void askQuestions() {
        Scanner input = new Scanner(System.in);
        try {
            String[][] list = createReferenceArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String answer;
        int correct = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("What is the capitol of " + getState(i) + "?");
            System.out.println(Arrays.toString(getAnswers(i).toArray()));
            answer = input.nextLine();
            if (answer.toUpperCase().equals(getCapitol(i).toUpperCase())) {
                System.out.println("Correct!");
                correct++;
                System.out.println();
            } else {
                System.out.println("Wrong.  The correct answer is " + getCapitol(i));
                System.out.println();
            }
        }
        System.out.println("You got " + correct + "/10 correct");
        System.out.println("Would you like to play again? Y/N");
    }

    public void printReferenceArray() {
        for (int i = 0; i < stateCapitals.length; i++) {
            System.out.println(stateCapitals[i][0] + ", " + stateCapitals[i][1]);
        }
    }
}
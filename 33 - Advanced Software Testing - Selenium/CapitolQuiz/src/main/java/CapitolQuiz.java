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

public class CapitolQuiz
{
    private String[][] stateCapitals;
    private ArrayList<Integer> fifty = new ArrayList();



    public CapitolQuiz() {
        try
        {
            stateCapitals = createReferenceArray();
            generateQuiz();
        } catch (Exception e) {}

    }

    public String[][] getReferenceArray()
    {
        return stateCapitals;
    }

    public String[][] createReferenceArray() throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        File file = new File("C:\\Users\\JCool\\Documents\\___GGC\\Soft Testing & QA\\CapitolQuiz\\src\\main\\resources\\states.xml");


//        grab all states from XML file, we are using XPath expressions //state for state tags
        FileInputStream stream = new FileInputStream(file);
        InputSource source = new InputSource(stream);
        XPathExpression expr = xpath.compile("//state");
        NodeList states = (NodeList) expr.evaluate(source, XPathConstants.NODESET);


        FileInputStream stream2 = new FileInputStream(file);
        InputSource source2 = new InputSource(stream2);
        XPathExpression expr2 = xpath.compile("//capital");
        NodeList capitals = (NodeList) expr2.evaluate(source2, XPathConstants.NODESET);

        stateCapitals = new String[50][2];
        for (int i = 0; i < states.getLength(); i++)
        {
            Node state = states.item(i);
            Node capital = capitals.item(i);
            stateCapitals[i][0] = state.getTextContent();
            stateCapitals[i][1] = capital.getTextContent();
        }
        return stateCapitals;
    }

    public void printReferenceArray() {
        for (int i = 0; i < stateCapitals.length; i++)
        {
            System.out.println(stateCapitals[i][0] + ", " + stateCapitals[i][1]);
        }
    }

    public ArrayList<Integer> getFiftyAL()
    {
        return fifty;
    }



    public String getState(int i) { return stateCapitals[i][0];   }

    public String getCapitol(int i){ return  stateCapitals[i][1]; }




    public void generateQuiz() {
        for (int i=0; i<50; i++) {
            fifty.add(i);
        }

        Collections.shuffle(fifty);
        Collections.shuffle(fifty);
    }

    public ArrayList<Integer> getQuizArray()
    {
        return fifty;
    }


    public ArrayList<String> getAnswers(int i) {
        ArrayList<String> answers = new ArrayList();

        // Adds the correct and incorrect answers to an array
        answers.add(getCapitol(i));
        answers.add(getCapitol(i + 10));
        answers.add(getCapitol(i + 20));
        answers.add(getCapitol(i + 30));
        answers.add(getCapitol(i + 40));
        // Shuffles the array and then returns the correct and incorrect answers
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
            // Asks Question
            System.out.println("What is the capitol of " + getState(fifty.get(i)) + "?");
            System.out.println(Arrays.toString(getAnswers(i).toArray()) + "\n");
            answer = input.nextLine();

            // Takes the user's input and compares it to the correct Capitol
            if (answer.toUpperCase().equals(getCapitol(fifty.get(i)).toUpperCase())) {
                System.out.println("Correct!\n");
                correct++;
                System.out.println();
            } else {
                System.out.println("Wrong; The correct answer is " + getCapitol(fifty.get(i)) + "\n");
                System.out.println();
            }
        }
        System.out.println("\nYou got " + correct + "/10 correct\n");

    }



}
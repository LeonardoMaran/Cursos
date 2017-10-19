CalculatorModel.java

01
// The Model performs all the calculations needed
02
// and that is it. It doesn't know the View
03
// exists
04
 
05
public class CalculatorModel {
06
 
07
    // Holds the value of the sum of the numbers
08
    // entered in the view
09
     
10
    private int calculationValue;
11
     
12
    public void addTwoNumbers(int firstNumber, int secondNumber){
13
         
14
        calculationValue = firstNumber + secondNumber;
15
         
16
    }
17
     
18
    public int getCalculationValue(){
19
         
20
        return calculationValue;
21
         
22
    }
23
     
24
}
CalculatorView.java

01
// This is the View
02
// Its only job is to display what the user sees
03
// It performs no calculations, but instead passes
04
// information entered by the user to whomever needs
05
// it.
06
 
07
import java.awt.event.ActionListener;
08
 
09
import javax.swing.*;
10
 
11
public class CalculatorView extends JFrame{
12
 
13
    private JTextField firstNumber  = new JTextField(10);
14
    private JLabel additionLabel = new JLabel("+");
15
    private JTextField secondNumber = new JTextField(10);
16
    private JButton calculateButton = new JButton("Calculate");
17
    private JTextField calcSolution = new JTextField(10);
18
     
19
    CalculatorView(){
20
         
21
        // Sets up the view and adds the components
22
         
23
        JPanel calcPanel = new JPanel();
24
         
25
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
26
        this.setSize(600, 200);
27
         
28
        calcPanel.add(firstNumber);
29
        calcPanel.add(additionLabel);
30
        calcPanel.add(secondNumber);
31
        calcPanel.add(calculateButton);
32
        calcPanel.add(calcSolution);
33
         
34
        this.add(calcPanel);
35
         
36
        // End of setting up the components --------
37
         
38
    }
39
     
40
    public int getFirstNumber(){
41
         
42
        return Integer.parseInt(firstNumber.getText());
43
         
44
    }
45
     
46
    public int getSecondNumber(){
47
         
48
        return Integer.parseInt(secondNumber.getText());
49
         
50
    }
51
     
52
    public int getCalcSolution(){
53
         
54
        return Integer.parseInt(calcSolution.getText());
55
         
56
    }
57
     
58
    public void setCalcSolution(int solution){
59
         
60
        calcSolution.setText(Integer.toString(solution));
61
         
62
    }
63
     
64
    // If the calculateButton is clicked execute a method
65
    // in the Controller named actionPerformed
66
     
67
    void addCalculateListener(ActionListener listenForCalcButton){
68
         
69
        calculateButton.addActionListener(listenForCalcButton);
70
         
71
    }
72
     
73
    // Open a popup that contains the error message passed
74
     
75
    void displayErrorMessage(String errorMessage){
76
         
77
        JOptionPane.showMessageDialog(this, errorMessage);
78
         
79
    }
80
     
81
}
CalculatorController.java

01
import java.awt.event.ActionEvent;
02
import java.awt.event.ActionListener;
03
 
04
// The Controller coordinates interactions
05
// between the View and Model
06
 
07
public class CalculatorController {
08
     
09
    private CalculatorView theView;
10
    private CalculatorModel theModel;
11
     
12
    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
13
        this.theView = theView;
14
        this.theModel = theModel;
15
         
16
        // Tell the View that when ever the calculate button
17
        // is clicked to execute the actionPerformed method
18
        // in the CalculateListener inner class
19
         
20
        this.theView.addCalculateListener(new CalculateListener());
21
    }
22
     
23
    class CalculateListener implements ActionListener{
24
 
25
        public void actionPerformed(ActionEvent e) {
26
             
27
            int firstNumber, secondNumber = 0;
28
             
29
            // Surround interactions with the view with
30
            // a try block in case numbers weren't
31
            // properly entered
32
             
33
            try{
34
             
35
                firstNumber = theView.getFirstNumber();
36
                secondNumber = theView.getSecondNumber();
37
                 
38
                theModel.addTwoNumbers(firstNumber, secondNumber);
39
                 
40
                theView.setCalcSolution(theModel.getCalculationValue());
41
             
42
            }
43
 
44
            catch(NumberFormatException ex){
45
                 
46
                System.out.println(ex);
47
                 
48
                theView.displayErrorMessage("You Need to Enter 2 Integers");
49
                 
50
            }
51
             
52
        }
53
         
54
    }
55
     
56
}
MVCCalculator.java

01
public class MVCCalculator {
02
     
03
    public static void main(String[] args) {
04
         
05
        CalculatorView theView = new CalculatorView();
06
         
07
        CalculatorModel theModel = new CalculatorModel();
08
         
09
        CalculatorController theController = new CalculatorController(theView,theModel);
10
         
11
        theView.setVisible(true);
12
         
13
    }
14
}

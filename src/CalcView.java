
import com.sun.glass.ui.InvokeLaterDispatcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import javax.swing.*;

public class CalcView {
    private final static int WIDTH = 320;
    private final static int HEIGHT = 480;
    private final static boolean frameIsResizeable =false;
    private final static boolean resultFieldIsEditable = false;

    private JTextField resultField;
    private JButton[] numberButtons;
    private JButton[] oppButtons;
    GridBagLayout layout;
    GridBagConstraints c;
    JFrame frame;

    CalcView(){
        createAndShowGUI();
    }

    public void setResFieldText(double vale) {
        resultField.setText(Double.toString(vale));
    }

    public double getResultFieldText() {
        return Double.parseDouble(resultField.getText());
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JButton[] getNumberButtons() {
        return numberButtons;
    }

    public JButton[] getOppButtons() {
        return oppButtons;
    }

    private void addNumButtons(Container pane, GridBagConstraints c){
        numberButtons = new JButton[10];
        int[][] numConstrains = new int[][]{
                {0,5,2,1},
                {0,4,1,1},
                {1,4,1,1},
                {2,4,1,1},
                {0,3,1,1},
                {1,3,1,1},
                {2,3,1,1},
                {0,2,1,1},
                {1,2,1,1},
                {2,2,1,1},
        };

        for (int i=0; i<numberButtons.length; i++){
            numberButtons[i] = new JButton(" " +i);
            c.gridx=numConstrains[i][0];
            c.gridy=numConstrains[i][1];
            c.gridwidth=numConstrains[i][2];
            c.gridheight=numConstrains[i][3];
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(2,2,2,2);
            pane.add(numberButtons[i],c);

        }
    }

    private void addOppButtons(Container pane, GridBagConstraints gbc){
        oppButtons = new JButton[8];
        oppButtons[0]=new JButton(".");
        oppButtons[1]=new JButton("=");

        oppButtons[2]=new JButton("+");
        oppButtons[3]=new JButton("-");
        oppButtons[4]=new JButton("*");

        oppButtons[5]=new JButton("/");
        oppButtons[6]=new JButton("+/-");
        oppButtons[7]=new JButton("C");

        int[][] oppConstrains = new int[][]{
                {2,5,1,1},
                {3,4,1,2},
                {3,3,1,1},
                {3,2,1,1},
                {3,1,1,1},
                {2,1,1,1},
                {1,1,1,1},
                {0,1,1,1},

        };

        for (int i=0; i<oppButtons.length; i++){
            gbc.gridx= oppConstrains[i][0];
            gbc.gridy= oppConstrains[i][1];
            gbc.gridwidth= oppConstrains[i][2];
            gbc.gridheight= oppConstrains[i][3];
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(2,2,2,2);
            pane.add(oppButtons[i],gbc);

        }


    }

    private  void addResultField(Container pane, GridBagConstraints c){
        resultField=new JTextField();
        resultField.setEditable(resultFieldIsEditable);
        resultField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));
        resultField.setBackground(Color.white);
        resultField.setFont(new Font("Arial",Font.PLAIN,24));

        c.gridx=0;
        c.gridy=0;
        c.gridwidth=4;
        c.gridheight=1;
        // c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,2,2,2);

        pane.add(resultField,c);
    }

    private void addComponentsToPane(Container pane) {
        layout = new GridBagLayout();
        layout.columnWidths=new int[]{80,80,80,80};
        layout.rowHeights=new int[]{80,80,80,80,80,80};
        pane.setLayout(layout);
        c = new GridBagConstraints();
        addNumButtons(pane,c);
        addOppButtons(pane,c);
        addResultField(pane, c);

    }

    public void createAndShowGUI() {

        //Create and set up the window.
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(frameIsResizeable);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.setVisible(true);
        frame.pack();
    }

    public void addActionListener(ActionListener listenForButton){
        for (int i=0;i<numberButtons.length;i++){
            numberButtons[i].addActionListener(listenForButton);

        }
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(frame,errorMessage);

    }





}






package com.jeremy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgileOrWaterfall extends JFrame{
    //GUI variables
    private JTextField projectName;
    private JPanel rootPanel;
    private JCheckBox programmersSize;
    private JCheckBox firmDeadlines;
    private JCheckBox programExperience;
    private JCheckBox qualityRequirements;
    private JCheckBox earlyIntegrationGUI;
    private JCheckBox earlyWorking;
    private JButton recommendButton;
    private JLabel resultsLabel;

    //method to show the GUI, and to display how big it will be
    protected AgileOrWaterfall()

    {
        setContentPane(rootPanel);
        pack();
        setSize(1000, 500);
        setTitle("Agile or Waterfall");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        //Action listener for the recommend button to give a recommendation
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                results();
            }
        });
    }
    //method to turn the check box results into a recommendation
    private void results(){

        int numberResult = agileOrWaterfall();
        String recommendation = projectName.getText();
        //if statement to determine what recommendation should be
        if(numberResult == 1){
            String textOutput = "For project " + recommendation +  " my recommendation is to use the Waterfall methodology";
            resultsLabel.setText(textOutput);
        }
        else if(numberResult == 2){
            String textOutput = "For project " + recommendation + " my recommendation is to use the Agile methodology";
            resultsLabel.setText(textOutput);
        }
        else{
            String textOutput = "For project " + recommendation + " is too close to call " +
                    "but, I would say to use the Agile methodology because the number of people you " +
                    "have on your team";
            resultsLabel.setText(textOutput);
        }
    }

        //a method that counts each check box to determine if it agile or waterfall will be better
        public int agileOrWaterfall() {
            //initializing the variables
            int agile = 0;
            int waterFall = 0;

            //each if/else statement will add 1 to the recommended methodology
            if (programmersSize.isSelected()) {
                waterFall = waterFall+ 1;
            }
            else{
                agile = agile + 1;
            }
            if(firmDeadlines.isSelected()){
                waterFall = waterFall+ 1;
            }
            else{
                agile = agile + 1;
            }
            if(programExperience.isSelected()){
                agile = agile + 1;
            }
            else{
                waterFall = waterFall+ 1;
            }
            if(qualityRequirements.isSelected()){
                agile = agile + 1;
            }
            else{
                waterFall = waterFall+ 1;

            }
            if(earlyIntegrationGUI.isSelected()){
                agile = agile + 1;

            }
            else{
                waterFall = waterFall+ 1;

            }
            if(earlyWorking.isSelected()){
                agile = agile + 1;
            }
            else {
                waterFall = waterFall+ 1;
            }

            //final if statement will determine the highest value to return which recommendation
            if(waterFall > agile){
                return 1;
            }
            else if(waterFall == agile){
                return 3;
            }
            else{
                return 2;
            }


        }


    }


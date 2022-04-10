package com.mango.prjmango.ui.activities.math;

import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;


public class MathEquation extends JPanel {
    @Setter private MathQuestion mathQuestion;
    private JLabel operation;
    private JLabel operationLines;
    private JLabel firstNumber;
    private JLabel secondNumber;
    private int largestNumber;
    public MathEquation() {
    }
    public MathEquation(MathQuestion mathQuestion) {
        this.mathQuestion = mathQuestion;
        setPanel();
    }
    public void setPanel(){
        setOpaque(true);
        //make panel only 300x300
//        setPreferredSize(new Dimension(200,200));
        setBackground(Color.WHITE);
        createComponents();
        createLayout();
    }
    private void createComponents() {
        firstNumber = new JLabel(""+mathQuestion.getFirstNumber(),SwingConstants.RIGHT);
        firstNumber.setFont(Fonts.SEGOE_UI_70.getFont());
        secondNumber = new JLabel(""+mathQuestion.getSecondNumber(),SwingConstants.RIGHT);
        secondNumber.setFont(Fonts.SEGOE_UI_70.getFont());

        if(firstNumber.getWidth()>secondNumber.getWidth()){
            largestNumber = firstNumber.getWidth();
        }else{
            largestNumber = secondNumber.getWidth();
        }

        switch (mathQuestion.getOperation()) {
            case ADDITION:
                operation = new JLabel(ImageIcons.ADDITION.getImageIcon());
                operationLines = new JLabel(ImageIcons.MATH_SEPARATOR.getImageIcon());
                break;
            case SUBTRACTION:
                operation  = new JLabel(ImageIcons.SUBTRACTION.getImageIcon());
                operationLines = new JLabel(ImageIcons.MATH_SEPARATOR.getImageIcon());
                break;
            case MULTIPLICATION:
                operation  = new JLabel(ImageIcons.MULTIPLICATION.getImageIcon());
                operationLines = new JLabel(ImageIcons.MATH_SEPARATOR.getImageIcon());
                break;
            case DIVISION:
                operation  = new JLabel(ImageIcons.DIVISION.getImageIcon());
                operationLines = new JLabel(ImageIcons.MATH_SEPARATOR.getImageIcon());
                break;

        }
    }
    private void createLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(88, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(operationLines, javax.swing.GroupLayout.PREFERRED_SIZE, largestNumber, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(operation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(firstNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(secondNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(114, Short.MAX_VALUE)
                                .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(operation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(operationLines)
                                .addContainerGap(115, Short.MAX_VALUE))
        );


    }

}

package com.mango.prjmango.ui.activities.math;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MathQuestion {
    @Getter private Operation operation;
    @Getter private int firstNumber;
    @Getter private int secondNumber;
    @Getter private double answer;
    @Getter private double answer2;
    @Getter private boolean wholeNumbers;

    public MathQuestion(Operation operation, int firstNumber, int secondNumber, boolean wholeNumbers) {
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.wholeNumbers = wholeNumbers;
        switch (operation) {
            case ADDITION:
                answer = firstNumber + secondNumber;
                break;
            case SUBTRACTION:
                answer = firstNumber - secondNumber;
                break;
            case MULTIPLICATION:
                answer = firstNumber * secondNumber;
                break;
            case DIVISION:
                if(wholeNumbers) {
                    answer = firstNumber / secondNumber;
                }else {
                    answer = ((double) firstNumber) / ((double) secondNumber);
                    BigDecimal roundDown = new BigDecimal(answer).setScale(2,RoundingMode.DOWN);
                    BigDecimal roundUp = new BigDecimal(answer).setScale(2,RoundingMode.UP);
//                    BigDecimal roundHalfDown = new BigDecimal(answer).setScale(2,RoundingMode.HALF_DOWN);
//                    BigDecimal roundHalfUp = new BigDecimal(answer).setScale(2,RoundingMode.HALF_UP);
//                    BigDecimal roundHalfEven = new BigDecimal(answer).setScale(2,RoundingMode.HALF_EVEN);
//                    BigDecimal roundFloor = new BigDecimal(answer).setScale(2,RoundingMode.FLOOR);
//                    BigDecimal roundCeiling = new BigDecimal(answer).setScale(2,RoundingMode.CEILING);

                    answer = roundDown.doubleValue();
                    answer2 = roundUp.doubleValue();

                    System.out.println(roundDown.doubleValue());
                    System.out.println(roundUp.doubleValue());
//                    System.out.println(roundHalfDown.doubleValue());
//                    System.out.println(roundHalfUp.doubleValue());
//                    System.out.println(roundHalfEven.doubleValue());
//                    System.out.println(roundFloor.doubleValue());
//                    System.out.println(roundCeiling.doubleValue());
                    break;

                }
        }
    }
    public boolean isCorrect(double answer) {
        if (this.operation == Operation.DIVISION && !wholeNumbers) {
                return answer == this.answer || answer == this.answer2;
        }else {
            return this.answer == answer;
        }
    }
}

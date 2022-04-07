package com.mango.prjmango.ui.activities.math;

import lombok.Getter;

public class MathQuestion {
    @Getter private Operation operation;
    @Getter private int firstNumber;
    @Getter private int secondNumber;
    @Getter private int answer;

    public MathQuestion(Operation operation, int firstNumber, int secondNumber) {
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.answer = solveQuestion();
    }
    public int solveQuestion() {
        switch (operation) {
            case ADDITION:
                return firstNumber + secondNumber;
            case SUBTRACTION:
                return firstNumber - secondNumber;
            case MULTIPLICATION:
                return firstNumber * secondNumber;
            case DIVISION:
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }
    public boolean isCorrect(int answer) {
        return this.answer == answer;
    }
}

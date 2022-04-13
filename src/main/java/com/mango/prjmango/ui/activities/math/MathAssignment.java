package com.mango.prjmango.ui.activities.math;

import com.mango.prjmango.student.Student;
import java.util.ArrayList;
import java.util.Random;
import lombok.Getter;

public class MathAssignment {
    @Getter private String assignmentName;
    @Getter Student student;
    @Getter private int additionTotal;
    @Getter private int subtractionTotal;
    @Getter private int multiplicationTotal;
    @Getter private int divisionTotal;
    @Getter private int numeratorMin;
    @Getter private int numeratorMax;
    @Getter private int denominatorMin;
    @Getter private int denominatorMax;
    @Getter private int currentQuestionIndex = 0;
    @Getter private int correctAnswers = 0;
    @Getter private boolean wholeNumbers = true;
    ArrayList<MathQuestion> questions = new ArrayList<>();

    public MathAssignment(String assignmentName, Student student, int additionTotal, int subtractionTotal, int multiplicationTotal, int divisionTotal, int numeratorMin, int numeratorMax, int denominatorMin, int denominatorMax, boolean wholeNumbers) {
        this.assignmentName = assignmentName;
        this.student = student;
        this.additionTotal = additionTotal;
        this.subtractionTotal = subtractionTotal;
        this.multiplicationTotal = multiplicationTotal;
        this.divisionTotal = divisionTotal;
        this.numeratorMin = numeratorMin;
        this.numeratorMax = numeratorMax;
        this.denominatorMin = denominatorMin;
        this.denominatorMax = denominatorMax;
        this.wholeNumbers = wholeNumbers;
        generateQuestions();
    }
    public void generateQuestions() {
        Random numberGenerator = new Random();
        int numerator;
        int denominator = 0;
        for (int i = 0; i < additionTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin + 1) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin + 1) + denominatorMin;
            }
            questions.add(new MathQuestion(Operation.ADDITION, numerator, denominator, wholeNumbers));
        }
        for (int i = 0; i < subtractionTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin + 1) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin + 1) + denominatorMin;
            }
            questions.add(new MathQuestion(Operation.SUBTRACTION, numerator, denominator, wholeNumbers));
        }
        for (int i = 0; i < multiplicationTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin + 1) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin + 1) + denominatorMin;
            }
            questions.add(new MathQuestion(Operation.MULTIPLICATION, numerator, denominator, wholeNumbers));        }
        for (int i = 0; i < divisionTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin + 1) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin + 1) + denominatorMin;
            }
            if(denominator != 0){
                questions.add(new MathQuestion(Operation.DIVISION, numerator, denominator, wholeNumbers));
            }
        }
    }
    public MathQuestion getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }
    public void nextQuestion() {
        currentQuestionIndex++;
    }
    public void answerQuestion(double answer) {
        if (answer == getCurrentQuestion().getAnswer()) {
            correctAnswers++;
        }
    }
    public boolean hasNextQuestion() {
        return currentQuestionIndex < getNumberOfQuestions() - 1;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }
}

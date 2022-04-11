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
    @Getter private int total;
    @Getter private int currentQuestionIndex = 0;
    @Getter private int correctAnswers = 0;
    ArrayList<MathQuestion> questions = new ArrayList<>();

    public MathAssignment(String assignmentName, Student student, int additionTotal, int subtractionTotal, int multiplicationTotal, int divisionTotal, int numeratorMin, int numeratorMax, int denominatorMin, int denominatorMax) {
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
        this.total = additionTotal + subtractionTotal + multiplicationTotal + divisionTotal;
        generateQuestions();
    }
    public void generateQuestions() {
        Random numberGenerator = new Random();
        int numerator;
        int denominator;
        for (int i = 0; i < additionTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin;
            }
            questions.add(new MathQuestion(Operation.ADDITION, numerator, denominator));
        }
        for (int i = 0; i < subtractionTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin;
            }
            questions.add(new MathQuestion(Operation.SUBTRACTION, numerator, denominator));
        }
        for (int i = 0; i < multiplicationTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin;
            }
            questions.add(new MathQuestion(Operation.MULTIPLICATION, numerator, denominator));        }
        for (int i = 0; i < divisionTotal; i++) {
            if(numeratorMin == numeratorMax){
                numerator = numeratorMin;
            }else{
                numerator = numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin;
            }
            if(denominatorMin == denominatorMax){
                denominator = denominatorMin;
            }else{
                denominator = numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin;
            }
            questions.add(new MathQuestion(Operation.DIVISION, numerator, denominator));        }
    }
    public MathQuestion getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }
    public void nextQuestion() {
        currentQuestionIndex++;
    }
    public void answerQuestion(int answer) {
        if (answer == getCurrentQuestion().getAnswer()) {
            correctAnswers++;
        }
    }
    public boolean hasNextQuestion() {
        return currentQuestionIndex < total - 1;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }
}

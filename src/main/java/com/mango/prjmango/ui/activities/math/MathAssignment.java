package com.mango.prjmango.ui.activities.math;

import com.mango.prjmango.student.Student;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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
        for (int i = 0; i < additionTotal; i++) {
            questions.add(new MathQuestion(Operation.ADDITION, numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin, numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin));
        }
        for (int i = 0; i < subtractionTotal; i++) {
            questions.add(new MathQuestion(Operation.SUBTRACTION, numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin, numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin));
        }
        for (int i = 0; i < multiplicationTotal; i++) {
            questions.add(new MathQuestion(Operation.MULTIPLICATION, numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin, numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin));
        }
        for (int i = 0; i < divisionTotal; i++) {
            questions.add(new MathQuestion(Operation.DIVISION, numberGenerator.nextInt(numeratorMax - numeratorMin) + numeratorMin, numberGenerator.nextInt(denominatorMax - denominatorMin) + denominatorMin));
        }
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
        nextQuestion();
    }
    public boolean hasNextQuestion() {
        return currentQuestionIndex < total - 1;
    }
}

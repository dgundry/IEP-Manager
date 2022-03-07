package com.mango.prjmango.windows.activities;

import lombok.Getter;
import lombok.Setter;

public class CreateAssignment {
    public @Getter @Setter String studentName;
    public @Getter @Setter String assignmentName;
    public @Getter String date;
    public @Getter int currentQuestionIndex;
    public @Getter String[] questions;
    public @Getter boolean[] studentAnswers;
    public CreateAssignment(String studentName, String assignmentName,String[] questions){
        this.studentName = studentName;
        this.assignmentName = assignmentName;
        this.date = java.time.LocalDate.now().toString();
        this.currentQuestionIndex = 0;
        this.questions= questions;
        this.studentAnswers = new boolean[questions.length];
    }

    /**
     * Gets the total # of questions in the assignment
     * @return length of array
     */
    public int getTotalQuestions(){
        return questions.length;
    }

    /**
     * Gets the index/# question in the assignment
     * @param index index of wanted String in array
     * @return String of current index in the array
     */
    private String getQuestionIndex(int index){
        return questions[index];
    }

    /**
     * Gets the next questions in the assignment.
     * @return If on the final Question, returns "Completed", or else returns the next String in the array of questions.
     */
    public String getNextQuestion(){
        if(hasNextQuestion()){
            return getQuestionIndex(++currentQuestionIndex);
        }else{
            return "Completed";
        }
    }

    /**
     * Returns true if there is a next question, false if not
     * @return boolean
     */
    public boolean hasNextQuestion(){
        if(currentQuestionIndex < getTotalQuestions()-1){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Gets the current questions in the assignment.
     * @return current String in array of questions.
     */
    public String getCurrentQuestion(){
        return questions[currentQuestionIndex];
    }

    /**
     * Sets Student's answer to the same index of the question in the questions array
     * @param answer given answer from Sight Word Assignment Controller
     */
    public void setStudentAnswer(boolean answer){
        studentAnswers[currentQuestionIndex] = answer;
    }
}

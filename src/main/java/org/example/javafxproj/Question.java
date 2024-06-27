package org.example.javafxproj;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "questions_answner")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String questionType;
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

    public Question(String questionType, String questionText, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.questionType = questionType;
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

}

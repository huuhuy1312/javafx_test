package org.example.javafxproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        DatabaseConnnection connection = new DatabaseConnnection();
        Connection connectionDB = connection.getConnection();
        String connectQuery = "SELECT * FROM questions ORDER BY RAND() LIMIT 1;";
        Question question = null;

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            if (queryOutput.next()) {
                String questionType = queryOutput.getString("question_type");
                String questionText = queryOutput.getString("question_text");
                String option1 = queryOutput.getString("option1");
                String option2 = queryOutput.getString("option2");
                String option3 = queryOutput.getString("option3");
                String option4 = queryOutput.getString("option4");
                String correctAnswer = queryOutput.getString("correct_answer");
                question = new Question(questionType, questionText, option1, option2, option3, option4, correctAnswer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 506);

        // Lấy controller và truyền câu hỏi vào
        HelloController helloController = fxmlLoader.getController();
        if (question != null) {
            if ("FILL".equals(question.getQuestionType())) {
                helloController.showFillForm(question.getQuestionText());
            } else {
                helloController.showQuestionWithOptions(question);
            }
        }

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

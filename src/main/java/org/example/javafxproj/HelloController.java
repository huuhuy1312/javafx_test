package org.example.javafxproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private Label questionLabel;

    @FXML
    private TextField answerTextField;

    @FXML
    private VBox answerOptionsBox;

    @FXML
    private Button submitButton;

    public void showFillForm(String questionText) {
        questionLabel.setText(questionText);
        answerTextField.setVisible(true);
        answerOptionsBox.setVisible(false);
    }

    public void showQuestionWithOptions(Question question) {
        questionLabel.setText(question.getQuestionText());
        answerTextField.setVisible(false);
        answerOptionsBox.setVisible(true);

        // Ví dụ đơn giản: hiển thị các lựa chọn dưới dạng label
        // Bạn có thể sử dụng các controls phù hợp với nhu cầu của mình
        Label option1Label = new Label(question.getOption1());
        option1Label.getStyleClass().addAll("choice");

        Label option2Label = new Label(question.getOption2());
        Label option3Label = new Label(question.getOption3());
        Label option4Label = new Label(question.getOption4());

        answerOptionsBox.getChildren().addAll(option1Label, option2Label, option3Label, option4Label);
    }

    @FXML
    private void onSubmitButtonClick() {
        // Xử lý khi nút Submit được nhấn
        String answer = answerTextField.getText();
        // Xử lý câu trả lời ở đây
    }
}

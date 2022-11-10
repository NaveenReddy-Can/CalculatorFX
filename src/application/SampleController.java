package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
	// Variables for Storing temp data
	static TextField textField;
	private double numberOne = 0;
	private double numberTwo = 0;
	private double finalResult = 0;
	private int operatorCount = 0;
	private String PreviousOperator = "";

	private int numOfDot = 0;

	// Getting textfield object from main.java
	public static void setText(TextField textField1) {
		textField = textField1;
	}

	// Method is Triggered if an number button Event Occurs
	@FXML
	private void btnClick(ActionEvent event) {
		event.consume();
		String text = ((Button) event.getSource()).getText();

		if (text.equals(".") && numOfDot == 1) {

		} else {
			String textInField = textField.getText();
			textInField += text;
			textField.setText(textInField);
		}

		if (text.equals(".") && numOfDot < 1) {
			numOfDot++;
		}

	}

	// Method triggers if an Operator Button Event Occurs
	@FXML
	private void btnOperator(ActionEvent event) {
		String textInField = textField.getText();
		double num = Double.parseDouble(textInField);
		String operator = ((Button) event.getSource()).getText();

		clearText();

		if (operator.equals("sqrt")) {
			double sqr = Math.sqrt(num);
			textField.setText(Double.toString(sqr));
		}

		if (operator.equals("+/-")) {
			double negativeNum = num * 2;
			numberOne = num - negativeNum;
			textField.setText(Double.toString(numberOne));
		}

		if (operatorCount == 0) {
			numberOne = num;
			operatorCount++;
			if (!operator.equals("+/-")) {
				PreviousOperator = operator;
			}
		}

		if (operator.equals("=")) {
			if (PreviousOperator.equals("+")) {
				numberTwo = num;
				finalResult = numberOne + numberTwo;
				textField.setText(Double.toString(finalResult));
			}
			if (PreviousOperator.equals("-")) {
				numberTwo = num;
				finalResult = numberOne - numberTwo;
				textField.setText(Double.toString(finalResult));
			}
			if (PreviousOperator.equals("x")) {
				numberTwo = num;
				finalResult = numberOne * numberTwo;
				textField.setText(Double.toString(finalResult));
			}
			if (PreviousOperator.equals("/")) {
				numberTwo = num;
				finalResult = numberOne / numberTwo;
				textField.setText(Double.toString(finalResult));
			}

			System.out.println(
					"--------------------------------------------------------------------------------------------");
			System.out.println("numberOne: " + numberOne);
			System.out.println("numberTwo: " + numberTwo);
			System.out.println("---------------------------------------------------------");
			System.out.println("finalResult: " + finalResult);
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			numberOne = finalResult;
			PreviousOperator = "";
			operatorCount = 0;
		}
	}

	// Method to clear the Data in the background After a click Event on CE Button
	@FXML
	private void btnClear(ActionEvent event) {
		clearText();
		numberOne = 0;
		numberTwo = 0;
		finalResult = 0;
		operatorCount = 0;
		PreviousOperator = "";

	}

	// Method to clear all the data in the TextField
	@FXML
	private void clearText() {
		numOfDot = 0;
		textField.setText("");
	}

}

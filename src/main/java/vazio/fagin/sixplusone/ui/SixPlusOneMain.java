package vazio.fagin.sixplusone.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vazio.fagin.sixplusone.SixPlusOne;
import vazio.fagin.sixplusone.SixPlusOneController;

public class SixPlusOneMain extends Application{

	TextField firstTextField;
	TextField secondTextField;
	TextField thirdTextField;
	TextField fourthTextField;
	TextField fifthTextField;
	TextField sixthTextField;
	
	TextField bonusTextField;
	
	TextArea collectionTextArea;
	
	Button submitButton;
	
	SixPlusOneController sixPlusOneController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		firstTextField = new TextField();
		firstTextField.setPrefWidth(30);
		secondTextField = new TextField();
		secondTextField.setPrefWidth(30);
		thirdTextField = new TextField();
		thirdTextField.setPrefWidth(30);
		fourthTextField = new TextField();
		fourthTextField.setPrefWidth(30);
		fifthTextField = new TextField(); 
		fifthTextField.setPrefWidth(30);
		sixthTextField = new TextField();
		sixthTextField.setPrefWidth(30);
		bonusTextField = new TextField();
		bonusTextField.setPrefWidth(30);
		
		Label sixNumbersLabel = new Label("Lucky Numbers: ");		
		Label bonusNumberLabel = new Label("Bonus Number: ");
		
		submitButton = new Button("Submit");
		submitButton.setOnAction(e -> {
			if(validateAllTextFields()) {
				saveNumbers();
			}
		});
		
		
		HBox oldNumbersBox = new HBox(sixNumbersLabel, 
				firstTextField, 
				secondTextField, 
				thirdTextField, 
				fourthTextField, 
				fifthTextField, 
				sixthTextField, 
				bonusNumberLabel, 
				bonusTextField,
				submitButton);
		oldNumbersBox.setSpacing(10);
		
		collectionTextArea = new TextArea();
		
		Label newLuckyNumber = new Label();
		newLuckyNumber.setText("Your new " + new SixPlusOne().toString());
				
		VBox oldNumberCollectionBox = new VBox(oldNumbersBox, collectionTextArea, newLuckyNumber);
		oldNumberCollectionBox.setSpacing(2);
		
		Group rootGroup = new Group(oldNumberCollectionBox);
		
		Scene scene = new Scene(rootGroup);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Six plus One");
		primaryStage.show();
	}
	
	private void saveNumbers() {
		int first = 0;
		int second = 0;
		int third = 0;
		int fourth = 0;
		int fifth = 0;
		int sixth = 0;
		int bonus = 0;
		try {
			first = Integer.parseInt(firstTextField.getText());
			second = Integer.parseInt(secondTextField.getText());
			third = Integer.parseInt(thirdTextField.getText());
			fourth = Integer.parseInt(fourthTextField.getText());
			fifth = Integer.parseInt(fifthTextField.getText());
			sixth = Integer.parseInt(sixthTextField.getText());
			bonus = Integer.parseInt(bonusTextField.getText());
			
			sixPlusOneController = new SixPlusOneController();
			try {
				sixPlusOneController.validateSixNumberRange(first);
				sixPlusOneController.validateSixNumberRange(second);
				sixPlusOneController.validateSixNumberRange(third);
				sixPlusOneController.validateSixNumberRange(fourth);
				sixPlusOneController.validateSixNumberRange(fifth);
				sixPlusOneController.validateSixNumberRange(sixth);
				sixPlusOneController.validateBonusNumberRange(bonus);
								
				int[] sixNumbers = {first, second, third, fourth, fifth, sixth};
				
				if(sixPlusOneController.checkNumbers(sixNumbers)) {
					sixPlusOneController.storeSixNumbersAndBonusInSixPlusOne(sixNumbers, bonus);
				} else {
					clearAllTextField();
				}
				
				//collectionTextArea.clear();				
				for(SixPlusOne sixPlusOne : sixPlusOneController.getSixPlusOnes()) {
					collectionTextArea.appendText(sixPlusOne.toString() + "\n");
				}
				clearAllTextField();
				
			} catch (Exception e) {			
				e.printStackTrace();
				clearAllTextField();
				showAlertError();
			}				
		} catch (NumberFormatException e) {
			e.printStackTrace();
			clearAllTextField();
			showAlertError();
		}		
	}
	
	private void clearAllTextField() {
		firstTextField.setText("");
		secondTextField.setText("");
		thirdTextField.setText("");
		fourthTextField.setText("");
		fifthTextField.setText("");
		sixthTextField.setText("");
		bonusTextField.setText("");			
	}
	
	private void showAlertError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, there was an error!");

		alert.showAndWait();
	}

	private boolean validateAllTextFields() {
		boolean isRightNumber = false;
		if(!firstTextField.getText().equals("")) {
			isRightNumber = true;
		} else {
			isRightNumber = false;
		}
		if(!secondTextField.getText().equals("")) {
			isRightNumber = true;
		} else {
			isRightNumber = false;
		}
		if(!thirdTextField.getText().equals("")) {
			isRightNumber = true;
		} else {
			isRightNumber = false;
		}
		if(!fourthTextField.getText().equals("")) {
			isRightNumber = true;
		} else {
			isRightNumber = false;
		}
		if(!fifthTextField.getText().equals("")) {
			isRightNumber = true;
		} else {
			isRightNumber = false;
		}
		if(!sixthTextField.getText().equals("")) {
			isRightNumber = true;
		} else {
			isRightNumber = false;
		}
		if(!bonusTextField.getText().equals("")) {
			isRightNumber = true;
		} else {
			isRightNumber = false;
		}		 
		
		return isRightNumber;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

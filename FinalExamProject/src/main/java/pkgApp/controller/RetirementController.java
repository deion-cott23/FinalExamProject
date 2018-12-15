package pkgApp.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import pkgCore.Retirement;
import pkgApp.RetirementApp;

public class RetirementController implements Initializable {
	
		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturn;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetiree;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private Label lblTotalSaved;
	
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		//Clear text views and labels when clear button is pressed 
		
		System.out.println("clear");
		txtYearsToWork.setText("");
		txtAnnualReturn.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetiree.setText("");
		txtRequiredIncome.setText("");
		lblSaveEachMonth.setText("");
		lblTotalSaved.setText("");
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//Call AmountToSave and TotalAmountSaved and populate 
		
		DecimalFormat formatted = new DecimalFormat("#0.00");
		
		boolean error = false;
		
		Retirement rt = new Retirement();
		
		
		try {
			if (Integer.parseInt(txtYearsToWork.getText()) > 0) {
				int yearsToWork = Integer.parseInt(txtYearsToWork.getText());
				rt.setiYearsToWork(yearsToWork);
				
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);	
				alert.setTitle("Years Not Valid");
				alert.setHeaderText("Invalid amount of years worked");
				alert.setContentText("Enter amount of years of work needed");
				alert.showAndWait();
				error = true;
			}
				
		}
		
		catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Years Not Valid");
			alert.setHeaderText("Invalid amount of years worked");
			alert.setContentText("Enter amount of years of work needed");
			alert.showAndWait();
			error = true;
		}
		
		//Make sure that annual return while working is valid 
		
		try {
			if (Double.parseDouble(txtAnnualReturn.getText()) >= 0.0 && Double.parseDouble(txtAnnualReturn.getText()) <= 0.15) {
				double annualReturn = Double.parseDouble(txtAnnualReturn.getText());
				rt.setdAnnualReturnWorking(annualReturn);
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Annual Return Not Valid");
				alert.setHeaderText("Annual return before retirement entered is not valid");
				alert.setContentText("Enter annual return while working between 0 and 15 percent");
				alert.showAndWait();
				error = true;
			}
		}
		
		catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Annual Return Not Valid");
			alert.setHeaderText("Annual Return while working entered is not valid");
			alert.setContentText("Enter annual return while working between 0 and 15 percent");
		}
		
		//Checking to see if years retired is a valid number
		try {
			if (Integer.parseInt(txtYearsRetired.getText()) > 0) {
				int yearsRetired = Integer.parseInt(txtYearsRetired.getText());
				rt.setiYearsRetired(yearsRetired);
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Years retired not valid");
				alert.setHeaderText("Retired years entered is not a valid amount");
				alert.setContentText("Enter valid amount of years to retire");
				alert.showAndWait();
				error = true;
			}
		}
		
		catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Years retired not valid");
			alert.setHeaderText("Retired years entered is not a valid amount");
			alert.setContentText("Enter valid amount of years to retire");
			alert.showAndWait();
			error = true;
		}
		
		//Check that annual return after retired is valid
		
		try {
			if (Double.parseDouble(txtAnnualReturnRetiree.getText()) >= 0.0 && Double.parseDouble(txtAnnualReturnRetiree.getText()) <= 0.03) {
				double annualReturnRetired = Double.parseDouble(txtAnnualReturnRetiree.getText());
				rt.setdAnnualReturnRetired(annualReturnRetired);
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Annual Return Not Valid");
				alert.setHeaderText("Annual Return for retiree not valid");
				alert.setContentText("Enter valid annual return for retirement between 0 and 3 percent");
				alert.showAndWait();
				error = true;
			}
		}
		
		catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Annual Return Not Valid");
			alert.setHeaderText("Annual Return for retiree not valid");
			alert.setContentText("Enter valid annual return for retirement between 0 and 3 percent");
			alert.showAndWait();
			error = true;
			
		}
		
		//Check for required income as a valid number
		
		try {
			if (Double.parseDouble(txtRequiredIncome.getText()) > 0.0) {
				double requiredIncome = Double.parseDouble(txtRequiredIncome.getText());
				rt.setdRequiredIncome(requiredIncome);
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Required Income Not Valid");
				alert.setHeaderText("Required Income for retirement not valid");
				alert.setContentText("Enter monthly income required greater than 0");
				alert.showAndWait();
				error = true;
				
			}
		}
		
		catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Required Income Not Valid");
			alert.setHeaderText("Required Income for retirement not valid");
			alert.setContentText("Enter monthly income required greater than 0");
			alert.showAndWait();
			error = true;
		}
		
		//Check monthly SSI is valid
		
		try {
			if (Double.parseDouble(txtMonthlySSI.getText()) >= 0.0) {
				double monthlySSI = Double.parseDouble(txtMonthlySSI.getText());
				rt.setdMonthlySSI(monthlySSI);
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Monthly SSI Not Valid");
				alert.setHeaderText("Monthly SSI entered not valid");
				alert.setContentText("Enter number for monthly Social Security");
				alert.showAndWait();
				error = true;
				
			}
		}
		
		catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Montly SSI Not Valid");
			alert.setHeaderText("Monthly SSI entered not valid");
			alert.setContentText("Enter number for monthly Social Security");
			alert.showAndWait();
			error = true;
		}
		
//if no error persists, calculate total and monthly amount to save and print results
		
		if (!error) {
			lblTotalSaved.setText(String.valueOf(formatted.format((-1) * rt.AmountToSave())));
			lblSaveEachMonth.setText(String.valueOf(formatted.format((-1) * rt.TotalAmountSaved())));
		}
		
		error = true;
		
		
	}
	
}

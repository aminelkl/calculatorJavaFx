package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainProcess {
    @FXML
	public Label result;
   
    private long num1 = 0;
    private long num2 = 0;
    private String operator = "";
    
    private boolean start = true;
    private Calculation model = new Calculation();
    
	@FXML
	public void processNumbers(ActionEvent event) {
		if (start) 
		{
			result.setText("");
			start = false;
		}
		
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText() + value);
	}
	
	@FXML
	public void processOperators(ActionEvent event) 
	{
		
		String value = ((Button)event.getSource()).getText();
		
		if (!value.equals("=")) 
		{
			if (!operator.isEmpty()) 
				return;
			
			operator = value;
			num1 = Long.parseLong(result.getText());
			result.setText("");
			return;
			}
		else 
		{
			if (operator.isEmpty()) 
				return;
			num2 = Long.parseLong(result.getText());
			
			long output = model.calculate(num1, num2, operator);
		    result.setText(String.valueOf(output));
		    operator = "";
		    start = true;
		    
		}
	}
	
	@FXML
	public void Ac(ActionEvent event) {
		operator = "";
		start = true;
		result.setText("");	
	}

}

package model;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.FrmConversion;

public class ListSelectionHandler implements ListSelectionListener{

	public void valueChanged(ListSelectionEvent arg0) {
		//Clear output text box
		FrmConversion.txtOutput.setText("");
		//Input text
		String input = FrmConversion.txtInput.getText();

		//Test for no input
		if(input.length() == 0){
			FrmConversion.txtOutput.setText("Please input a number");
		}
		//Binary -> Hexadecimal
		else if(FrmConversion.lbSelection.getSelectedIndex() == 0){
			if(input.substring(0, 2).equals("0b") == false){
				FrmConversion.txtOutput.setText("Binary numbers must be prefixed with '0b'.");
			}
			else{
				String b = input.substring(2, input.length());
				try{
					int i = Integer.parseInt(b, 2);
					FrmConversion.txtOutput.setText("0x" + Integer.toHexString(i));
				}
				catch(Exception e){
					FrmConversion.txtOutput.setText("Please enter a valid binary number.");
				}
				
			}
			
		}
		//Binary -> Integer
		else if(FrmConversion.lbSelection.getSelectedIndex() == 1){
			if(input.substring(0, 2).equals("0b") == false){
				FrmConversion.txtOutput.setText("Binary numbers must be prefixed with '0b'.");
			}
			else{
				String b = input.substring(2, input.length());
				try{
					int i = Integer.parseInt(b, 2);
					FrmConversion.txtOutput.setText(Integer.toString(i));
				}
				catch(Exception e){
					FrmConversion.txtOutput.setText("Please enter a valid binary number.");
				}
				
			}
		}
		//Integer -> Binary
		else if(FrmConversion.lbSelection.getSelectedIndex() == 2){
	
		}
		//Integer -> Hexadecimal
		else if(FrmConversion.lbSelection.getSelectedIndex() == 3){
	
		}
		//Hexadecimal -> Binary
		else if(FrmConversion.lbSelection.getSelectedIndex() == 4){
	
		}
		//Hexadecimal -> Integer
		else{
			
		}

		
	}

}

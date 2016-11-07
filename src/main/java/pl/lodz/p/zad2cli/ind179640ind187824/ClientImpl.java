package pl.lodz.p.zad2cli.ind179640ind187824;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.lodz.p.zad2.ind179640ind187824.QuestionCallback;

public class ClientImpl implements Client {
	
    private QuestionCallback callback;
	
	private JFrame inputDialog;
	
	public void showDialog(){
		init();
	}
	
	

	private void init() {
		inputDialog = new JFrame();

		JLabel fileNameLabel = new JLabel("File name:");
		JTextField fileNameText = new JTextField();
		
		JLabel correctTextLabel = new JLabel("Correct text:");
	    JTextField correctText = new JTextField();
	    
	    JLabel wrongTextLabel = new JLabel("Wrong text:");
	    JTextField wrongText = new JTextField();
	    


	    JPanel panel = new JPanel(new GridLayout(0, 1));
	    
	    panel.add(fileNameLabel);
	    panel.add(fileNameText);
	    
	    panel.add(correctTextLabel);
	    panel.add(correctText);
	    
	    panel.add(wrongTextLabel);
	    panel.add(wrongText);


	    
	    inputDialog.setContentPane(panel);
	    
	    inputDialog.setVisible(true);
		
	}



	public void setCallback(QuestionCallback callback) {
		
		this.callback = callback;
	}

	
	@Override
	public boolean canApplicationBeClosed(boolean success){
		
		boolean closeApplication = false;
		
		if(callback!=null){
			closeApplication = !callback.doRetry(success);
		}
		
		return closeApplication;
	}

	@Override
	public JFrame getJFrameInstance() {
		
		return inputDialog;
	}
	
	
}

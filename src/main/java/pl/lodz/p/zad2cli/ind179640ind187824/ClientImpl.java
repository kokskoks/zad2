package pl.lodz.p.zad2cli.ind179640ind187824;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import pl.lodz.p.zad2.ind179640ind187824.MainApplicationAccessorCallback;
import pl.lodz.p.zad2.ind179640ind187824.QuestionCallback;
import pl.lodz.p.zad2.ind179640ind187824.Root;

public class ClientImpl implements Client, MainApplicationAccessorCallback {
	
    private QuestionCallback callback;
	
	private JFrame inputDialog;

	private JTextField fileNameText;

	private JTextField correctText;

	private JTextField wrongText;
	
	private boolean success;
	
	public void showDialog(){
		init();
	}
	
	

	private void init() {
		inputDialog = new JFrame();

		JLabel fileNameLabel = new JLabel("File name:");
		fileNameText = new JTextField();
		
		JLabel correctTextLabel = new JLabel("Correct text:");
	    correctText = new JTextField();
	    
	    JLabel wrongTextLabel = new JLabel("Wrong text:");
	    wrongText = new JTextField();
	    


	    JPanel panel = new JPanel(new GridLayout(0, 1));
	    
	    panel.add(fileNameLabel);
	    panel.add(fileNameText);
	    
	    panel.add(correctTextLabel);
	    panel.add(correctText);
	    
	    panel.add(wrongTextLabel);
	    panel.add(wrongText);


	    
	    inputDialog.setContentPane(panel);
	    
	    inputDialog.setSize(200, 250);
	    
	    inputDialog.setResizable(false);
	    
	    inputDialog.setVisible(true);
		
	}



	public void setCallback(QuestionCallback callback) {
		
		this.callback = callback;
		
		inputDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
		WindowListener windowListener = createWindowClosingListener();
		
		inputDialog.addWindowListener(windowListener);
	}

	
	private WindowListener createWindowClosingListener() {
		
		WindowListener windowListener = new WindowAdapter(){
			

			@Override
			public void windowClosing(WindowEvent e) {
				
				success = Root.saveFile(fileNameText.getText(), correctText.getText(), wrongText.getText());
				
				boolean retry = callback.doRetry(success);
				
				if(!retry){
					inputDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} 
				
				super.windowClosing(e);
			}
		};
		
		
		return windowListener;
	}



	@Override
	public boolean canApplicationBeClosed(boolean success){
		
		boolean closeApplication = false;
		
		if(callback!=null){
			closeApplication = !callback.doRetry(success);
		}
		
		return closeApplication;
	}

	//@Override
	public JFrame getJFrameInstance() {
		
		return inputDialog;
	}



	@Override
	public String[] getInputData() {
		return new String[]{fileNameText.getText(), correctText.getText(), wrongText.getText()};
	}



	@Override
	public boolean getSaveResult() {
		return success;
	}
	
	
}

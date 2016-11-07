package pl.lodz.p.zad2cli.ind179640ind187824;

import pl.lodz.p.zad2.ind179640ind187824.CallbackInjector;
import pl.lodz.p.zad2.ind179640ind187824.QuestionCallback;
import pl.lodz.p.zad2.ind179640ind187824.Root;

public class Main {
	

	
	public static void main(String... args){
		
		Client client = new ClientImpl();
		
		CallbackInjector callbackInjector = Root.getCallbackInjector();
		QuestionCallback questionCallback = Root.getQuestionCallback();
		
		client.showDialog();
		
		callbackInjector.inject(questionCallback, client);
		
	}




	
	

}

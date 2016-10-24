package pl.lodz.p.zad2cli.ind179640ind187824;

import java.util.Scanner;

import pl.lodz.p.zad2.ind179640ind187824.CallbackInjectable;
import pl.lodz.p.zad2.ind179640ind187824.QuestionCallback;

public class Main implements Client{
	
	private QuestionCallback callback;
	
	public static void main(String... args){
		
		Client client = new Main();
		
	}

	public void setCallback(QuestionCallback callback) {
		
		this.callback = callback;
	}

	@Override
	public String[] getInfo() {
		String[] data = new String[3];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj nazwe");
		data[0] = scanner.nextLine();
		System.out.println("Podaj poprawny string:");
		data[1] = scanner.nextLine();
		System.out.println("Podaj niepoprawny string:");
		data[2] = scanner.nextLine();
		return data;
	}

}

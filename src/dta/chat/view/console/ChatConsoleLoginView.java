package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.controller.ChatAuthController;

public class ChatConsoleLoginView extends ViewComposite {
	
	private Scanner sc;
	private String saisie;
	private ChatAuthController authController;
	
	
	
	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
	}


	public ChatConsoleLoginView(Scanner sc) {
		
		this.sc = sc;
		
	}
	

	@Override
	public void printBefore() {
		System.out.println("=== Authentification ===");
		this.authController.authenticate();
//		System.out.println("Inserez votre pseudo");
//		this.saisie = this.sc.next();
//		System.out.println("Bienvenue " + saisie);
	}
	
	public String askLogin() {
		//System.out.println("=== Authentification ===");
		System.out.println("Entrez votre pseudo : ");
		this.saisie = this.sc.next();
		return saisie;
	}
	
	public void sayWelcome(String login) {
		
		System.out.println("Bienvenue " + saisie);
		
	}
	
	public void sayAccessDenied(String login) {
		
		System.out.println("Accès interdit : " + saisie);
		
	}

}

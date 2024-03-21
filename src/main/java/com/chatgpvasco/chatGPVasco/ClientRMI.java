package com.chatgpvasco.chatGPVasco;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientRMI {
	
	public ClientRMI() {}
	
	public static void main(String[] args) {

        try {
        	ChatGPVascoRMI chatGPVasco = (ChatGPVascoRMI) Naming.lookup("rmi://localhost:5001/chatGPVasco");
            System.out.println("* Conexão com chat GPVasco estabelecida com sucesso. *");
			System.out.println("* Digite tchau pra encerrá-la *");
            
			Scanner scanner = new Scanner(System.in);
            String message = "";
            
            while(!message.equals("tchau")) {
            	System.out.println("Digite sua mensagem : ");
				message = scanner.nextLine();
				
            	String response = chatGPVasco.sendResponse(message);
            	System.out.println("Chat GPVasco : " + response);
            }
            
            scanner.close();
            
            System.out.println("Conexão encerrada");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.chatgpvasco.chatGPVasco;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientRMI {
	
	public ClientRMI() {}
	
	public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            ChatGPVascoRMI stub = (ChatGPVascoRMI) registry.lookup("chatGPVasco");
            System.out.println("* Conexão com chat GPVasco estabelecida com sucesso. *");
			System.out.println("* Digite tchau pra encerrá-la *");
            
            String message = "";
            
            while(!message.equals("tchau")) {
            	System.out.println("Digite sua mensagem : ");
				Scanner scanner = new Scanner(System.in);
				message = scanner.nextLine();
				scanner.close();
				
            	String response = stub.sendResponse(message);
            	System.out.println("Chat GPVasco : " + response);
            }
            
            System.out.println("Conexão encerrada");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

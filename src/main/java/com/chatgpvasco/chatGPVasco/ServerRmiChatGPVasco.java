package com.chatgpvasco.chatGPVasco;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerRmiChatGPVasco extends UnicastRemoteObject implements ChatGPVascoRMI {

	public ServerRmiChatGPVasco() throws RemoteException{}
	
	@Override
	public String sendResponse(String messageSent) throws RemoteException {
		return ChatBot.generateResponse(messageSent);
	}
	
	public static void main(String args[]) {
        
        try {
        	// faz o bind do objeto da classe com o nome associado
            Registry registry = LocateRegistry.createRegistry(5001);
            registry.rebind("chatGPVasco", new ServerRmiChatGPVasco());

            System.out.println("servidor RMI chatGPVasco iniciado com sucesso");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

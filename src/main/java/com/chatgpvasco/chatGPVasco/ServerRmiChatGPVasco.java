package com.chatgpvasco.chatGPVasco;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerRmiChatGPVasco extends ChatBot implements ChatGPVascoRMI {

	public ServerRmiChatGPVasco() {}
	
	@Override
	public String sendResponse(String messageSent) throws RemoteException {
		return generateResponse(messageSent);
	}
	
	public static void main(String args[]) {
        
        try {
        	// instancia objeto e stub
        	ServerRmiChatGPVasco obj = new ServerRmiChatGPVasco();
        	ChatGPVascoRMI stub = (ChatGPVascoRMI) UnicastRemoteObject.exportObject(obj, 0);

            // faz o bind do objeto remoto com o registrador
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("chatGPVasco", stub);

            System.out.println("servidor RMI chatGPVasco iniciado com sucesso");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

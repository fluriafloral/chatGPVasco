package com.chatgpvasco.chatGPVasco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatGPVascoRMI extends Remote {
	String sendResponse(String messageSent) throws RemoteException;
}

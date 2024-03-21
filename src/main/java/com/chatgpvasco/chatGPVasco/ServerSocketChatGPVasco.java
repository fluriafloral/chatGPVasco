package com.chatgpvasco.chatGPVasco;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketChatGPVasco {
	
	public ServerSocketChatGPVasco(int port) {
		try {
			//inicia servidor
		    ServerSocket serverSocket = new ServerSocket(port	);
			System.out.println("* servidor socket chatGPVasco iniciado com sucesso *");

			System.out.println("aguardando conexões ...");

		    //estabelece conexão via socket
		    Socket socket = serverSocket.accept();
			System.out.println("pessoa conectada com sucesso");

			//instancia as stream de entrada e saída de texto
		    DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
					
			String messageSent = "";

			// continua a ler mensagens enviadas até que receba 'end'
			while (true) {
				do {
					
					messageSent = in.readUTF();
					out.writeUTF(ChatBot.generateResponse(messageSent));
					
				} while (!messageSent.trim().equals("tchau"));
				
				System.out.println("Fechando conexão");

				// fecha todas as conexões
				serverSocket.close();
				socket.close();
				in.close();
				out.close();
				
				System.out.println("Conexão encerrada com sucesso");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerSocketChatGPVasco server = new ServerSocketChatGPVasco(5001);
	}
}

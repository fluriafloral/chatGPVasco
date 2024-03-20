package com.chatgpvasco.chatGPVasco;// A Java program for a Client
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSocket {
    // construtor recebendo ip e porta
	public ClientSocket(String address, int port) {
		
		Scanner scanner = new Scanner(System.in);
		
        try {
			// inicializa socket
			Socket socket = new Socket(address, port);
			System.out.println("* Conexão com chat GPVasco estabelecida com sucesso. *");
			System.out.println("* Digite tchau pra encerrá-la *");

			// inicializa streams de entrada e saída de dados
			DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());

			String message = "";

			// mantém a conexão aberta até que mande 'tchau'
			while (!message.trim().equals("tchau")) {
				System.out.println("Digite sua mensagem : ");
				message = scanner.nextLine();
					
				out.writeUTF(message);
				
				if (!message.trim().equals("tchau")) {
					String response = in.readUTF();
					System.out.println("Chat GPVasco : " + response);
				}
			}
			
			System.out.println("Fechando conexão");
			
			// fecha conexões
			scanner.close();
			socket.close();
			in.close();
			out.close();
			
			System.out.println("Conexão encerrada com sucesso");
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

	public static void main(String[] args) {
		ClientSocket clientSocket = new ClientSocket("127.0.0.1", 5001);
	}
}


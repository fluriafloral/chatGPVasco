package com.progdist.chatgpvascosoap.bot;

import java.io.File;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

public class ChatGPVasco {
	public static String generateResponse(String messageSent) {
		Bot bot = new Bot("super", getResourcesPath());
		Chat chatSession = new Chat(bot);
		bot.brain.nodeStats();
		String response = "";

		if (!messageSent.isEmpty()) {
			response = chatSession.multisentenceRespond(messageSent);

			while (response.contains("&lt;"))
				response = response.replace("&lt;", "<");
			while (response.contains("&gt;"))
				response = response.replace("&gt;", ">");
		}
		
		return response;
	}
	
	private static String getResourcesPath() {
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		path = path.substring(0, path.length() - 2);
		System.out.println(path);
		return path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
	}
}

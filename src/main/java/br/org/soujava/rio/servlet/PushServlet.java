package br.org.soujava.rio.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;


@WebServlet("/PushServlet")
public class PushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PushBuilder pushBuilder = request.newPushBuilder();

		if (pushBuilder != null) {

			pushBuilder
				.path("imagem/soujava-rio.png")
				.addHeader("content-type", "image/png")
				.push();
		}

		try (PrintWriter printWrite = response.getWriter();) {
			printWrite.write(
					"<html>" +
					"<img src='imagem/soujava-rio.png'>" +
					"<h1>Server Push</h1>" +		
					"</html>");	
		}
	}
}
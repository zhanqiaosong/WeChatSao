package org.zqs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zqs.util.QrCodeImg;

public class ActionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		request.setCharacterEncoding("utf-8");
		String content = "BEGIN:VCARD";
		content += "\n\nVERSION:3.0";
		content += "\nFN:"+request.getParameter("name");
		content += "\nTEL;CELL;VOICE:"+request.getParameter("tel");
		content += "\nEMAIL;PREF;INTERNET:"+request.getParameter("email");
		content += "\norG:"+request.getParameter("org");
		content += "\nROLE:"+request.getParameter("role");
		content += "\nTITLE:"+request.getParameter("title");
		content += "\nADR;WORK;POSTAL:"+request.getParameter("address");
		content += "\n\nREV:"+new Date().toString();
		content += "\n\nEND:VCARD";
		String imgPath = this.getServletContext().getRealPath("/image");
		String imageName = QrCodeImg.getQrCodeImg(content, imgPath);
		request.setAttribute("path", imageName);
		System.out.println(imageName);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doGet(request, response);
	}

}

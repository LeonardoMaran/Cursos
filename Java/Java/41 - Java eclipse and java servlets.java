Setup Tomcat in Eclipse

In Eclipse click on Preferences in the top menu. Then click the following:

Click Server
Click Runtime Environments
Click Add
Select your version of Tomcat (Probably 7)
Locate the Tomcat directory on your computer
Create a Java Servlet in Eclipse

This is how you create a Java Servlet step-by-step:

Right click on your code directory in the Eclipse Project Explorer
Click New then Project
Click Dynamic Web Project
Give it a name (mine is Lesson41) then click Finish
Right click on the Java Resources directory
Select New and then Servlet
Enter a Package Name (mine is helloservlets)
Enter a Class Name (mine is Lesson41)
Click Next and Finish
Edit the doGet method (My Code is Below)
Change the web.xml file (My Code is Below)
Right click on the project and select Run on Server
Shut Off Serializable Errors in Eclipse

Click Preferences
Expand Java – Compiler – Errors/Warnings
Shutoff Serializable class without serialVersionUID
Setup Java Servlet Tooltips in Eclipse

Download the Tomcat Source Code Distribution Zip
Open the Java Resources Folder in your project in the Eclipse Project Explorer
Open the Libraries Folder
Expand the JRE System Library
Right click servlet-api.jar
Click Properties
Select Java Source Attachement
Click External File and locate the zip file above
Code From the Video

01
package helloservlets;
02
 
03
import java.io.IOException;
04
import java.io.PrintWriter;
05
import javax.servlet.ServletException;
06
import javax.servlet.annotation.WebServlet;
07
import javax.servlet.http.HttpServlet;
08
import javax.servlet.http.HttpServletRequest;
09
import javax.servlet.http.HttpServletResponse;
10
 
11
/**
12
 * Servlet implementation class Lesson41
13
 */
14
@WebServlet("/Lesson41")
15
public class Lesson41 extends HttpServlet {
16
    private static final long serialVersionUID = 1L;
17
 
18
    /**
19
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
20
     */
21
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
22
        response.setContentType("text/html");
23
         
24
        PrintWriter output = response.getWriter();
25
         
26
        output.println("<html><body><h3>Hello Servlets</h3></body></html>");
27
    }
28
 
29
    /**
30
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
31
     */
32
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
33
        // TODO Auto-generated method stub
34
    }
35
 
36
}
1
<?xml version="1.0" encoding="UTF-8"?>
2
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
3
  <display-name>Lesson41</display-name>
4
  <welcome-file-list>
5
    <welcome-file>Lesson41</welcome-file>
6
  </welcome-file-list>
7
</web-app>

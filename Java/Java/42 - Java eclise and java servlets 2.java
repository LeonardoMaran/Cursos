The Most Popular Requests

Always feel free to leave a request, but I’ve picked my next 3 tutorials based on your votes.

Design Patterns
Android App Development
More Java Tutorials
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
 
15
@WebServlet("/Lesson41")
16
public class Lesson41 extends HttpServlet {
17
    private static final long serialVersionUID = 1L;
18
 
19
    /**
20
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
21
     */
22
 
23
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
24
        String usersName = request.getParameter("yourname");
25
         
26
        String theLang = request.getParameter("Language");
27
         
28
        int firstNum = Integer.parseInt(request.getParameter("firstnum"));
29
        int secondNum = Integer.parseInt(request.getParameter("secondnum"));
30
        int sumONum = firstNum + secondNum;
31
         
32
        response.setContentType("text/html");
33
         
34
        PrintWriter output = response.getWriter();
35
         
36
        output.println("<html><body><h3>Hello " + usersName);
37
         
38
        output.println("</h3><br />" + firstNum + " + " + secondNum);
39
        output.println(" = " + sumONum + "<br />Speaks " + theLang + "</body></html>");
40
    }
41
 
42
    /**
43
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
44
     */
45
 
46
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
47
        doGet(request, response);
48
    }
49
 
50
}

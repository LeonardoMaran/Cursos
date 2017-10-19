	// The API for accessing and processing data stored in a database
02
 
03
import java.sql.*;
04
 
05
public class Lesson34 {
06
    public static void main(String[] args) {
07
         
08
        // A connection object is used to provide access to a database
09
         
10
        Connection conn = null;
11
         
12
        try {
13
            // The driver allows you to query the database with Java
14
            // forName dynamically loads the class for you
15
            
16
            Class.forName("com.mysql.jdbc.Driver");
17
             
18
            // DriverManager is used to handle a set of JDBC drivers
19
            // getConnection establishes a connection to the database
20
            // You must also pass the userid and password for the database
21
             
22
            conn = DriverManager.getConnection("jdbc:mysql://localhost/customer","mysqladm","turtledove");
23
             
24
            // Statement objects executes a SQL query
25
            // createStatement returns a Statement object
26
             
27
            Statement sqlState = conn.createStatement();
28
             
29
            // This is the query I'm sending to the database
30
             
31
            String selectStuff = "Select first_name from customer";
32
             
33
            // A ResultSet contains a table of data representing the
34
            // results of the query. It can not be changed and can
35
            // only be read in one direction
36
             
37
            ResultSet rows = sqlState.executeQuery(selectStuff);
38
             
39
            // next is used to iterate through the results of a query
40
             
41
            while(rows.next()){
42
                System.out.println(rows.getString("first_name"));
43
            }
44
        }
45
         
46
        catch (SQLException ex) {
47
             
48
            // String describing the error
49
             
50
            System.out.println("SQLException: " + ex.getMessage());
51
             
52
            // Vendor specific error code
53
             
54
            System.out.println("VendorError: " + ex.getErrorCode());
55
        }
56
         
57
        catch (ClassNotFoundException e) {
58
            // Executes if the driver can't be found
59
            e.printStackTrace();
60
        }
61
         
62
    }
63
}

torial 3C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpTutA.cs
{
    class Program
    {
        
        static void Main(string[] args)
        {
            // ----- CONDITIONALS -----
            // ----- IF / ELSE / -----
            // Relational Operators : > < >= <= == !=
            // Logical Operators : && || !

            int age = 17;

            if ((age >= 5) && (age <= 7))
            {
                Console.WriteLine("Go to elementary school");
            }
            else if ((age > 7) && (age < 13))
            {
                Console.WriteLine("Go to middle school");
            }
            else if ((age > 13) && (age < 19))
            {
                Console.WriteLine("Go to high school");
            }
            else
            {
                Console.WriteLine("Go to college");
            }

            if ((age < 14) || (age > 67))
            {
                Console.WriteLine("You shouldn't work");
            }

            Console.WriteLine("! true = " + (!true));

            // Ternary Operator
            // Assigns the 1st value if true and otherwise 
            // the 2nd
            bool canDrive = age >= 16 ? true : false;

            // Switch is used when you have limited options
            // The only way to use ranges is to stack 
            // the possible values
            switch (age)
            {
                case 1:
                case 2:
                    Console.WriteLine("Go to Day Care");
                    break;
                case 3:
                case 4:
                    Console.WriteLine("Go to Preschool");
                    break;
                case 5:
                    Console.WriteLine("Go to Kindergarten");
                    break;
                default:
                    Console.WriteLine("Go to another school");
                    // You can also jump out of a switch
                    // with goto
                    goto OtherSchool;
            }

            OtherSchool:
            Console.WriteLine("Elementary, Middle, High School");

            // To compare strings use Equals
            string name = "Derek";
            string name2 = "Derek";

            if (name.Equals(name2, StringComparison.Ordinal))
            {
                Console.WriteLine("Names are Equal");
            }

            // ----- WHILE LOOP -----
            // You use the while loop when you want to execute
            // as long as a condition is true

            // This while loop will print odd numbers between
            // 1 and 10
            int i = 1;
            while (i <= 10)
            {
                // % (Modulus) returns the remainder of a
                // division. If it returns 0 that means the
                // value is even
                if (i % 2 == 0)
                {
                    i++;

                    // Continue skips the rest of the code and 
                    // starts execution back at the top of the 
                    // while
                    continue;
                }

                // Break jumps completely out of the loop
                if (i == 9) break;

                Console.WriteLine(i);
                i++;
            }

            // ----- DO WHILE LOOP -----
            // Use do while when you must execute the code
            // at least once

            // Generate a random number
            Random rnd = new Random();
            int secretNumber = rnd.Next(1, 11);
            int numberGuessed = 0;

            do
            {
                Console.Write("Enter a number between 1 & 10 : ");

                // Use Convert to switch the string into an int
                numberGuessed = Convert.ToInt32(Console.ReadLine());

            } while (secretNumber != numberGuessed);

            Console.WriteLine("You guessed it is was {0}",
                secretNumber);

            // Other Convert options : ToBoolean, ToByte,
            // ToChar, ToDecimal, ToDouble, ToInt64,
            // ToString, and they can convert from any 
            // type to any other type

            // ----- EXCEPTION HANDLING -----
            // We use exception handling to catch errors
            // that could crash our program
            double num1 = 5;
            double num2 = 0;

            // Code that could cause an error is surrounded
            // by a try block
            try { 
            Console.WriteLine("5 / 0 = {0}", 
                DoDivision(num1, num2));
            }

            // We catch the error and warn the user 
            // rather then crash the program
            catch (DivideByZeroException ex)
            {
                Console.WriteLine("You can't Divide by Zero");

                // Get additonal info on the exception
                Console.WriteLine(ex.GetType().Name);
                Console.WriteLine(ex.Message);

            }

            // This is the default catch all for exceptions
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred");
                Console.WriteLine(ex.GetType().Name);
                Console.WriteLine(ex.Message);
            }

            // finally always runs and provides for clean up
            finally
            {
                Console.WriteLine("Cleaning Up");
            }

            // Well cover more about exception handling 
            // with some real examples soon

            Console.ReadLine();

        }

        static double DoDivision(double x, double y)
        {
            if(y == 0)
            {
                // We are throwing an exception because
                // you can't divide by zero
                throw new System.DivideByZeroException();
            }
            return x / y;
        }

    }
}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
101
102
103
104
105
106
107
108
109
110
111
112
113
114
115
116
117
118
119
120
121
122
123
124
125
126
127
128
129
130
131
132
133
134
135
136
137
138
139
140
141
142
143
144
145
146
147
148
149
150
151
152
153
154
155
156
157
158
159
160
161
162
163
164
165
166
167
168
169
170
171
172
173
174
175
176
177
178
179
180
181
182
183
184
185
186
187
188
189
190
191
192
193
194
195
196
197
198
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
 
namespace CSharpTutA.cs
{
    class Program
    {
        
        static void Main(string[] args)
        {
            // ----- CONDITIONALS -----
            // ----- IF / ELSE / -----
            // Relational Operators : > < >= <= == !=
            // Logical Operators : && || !
 
            int age = 17;
 
            if ((age >= 5) && (age <= 7))
            {
                Console.WriteLine("Go to elementary school");
            }
            else if ((age > 7) && (age < 13))
            {
                Console.WriteLine("Go to middle school");
            }
            else if ((age > 13) && (age < 19))
            {
                Console.WriteLine("Go to high school");
            }
            else
            {
                Console.WriteLine("Go to college");
            }
 
            if ((age < 14) || (age > 67))
            {
                Console.WriteLine("You shouldn't work");
            }
 
            Console.WriteLine("! true = " + (!true));
 
            // Ternary Operator
            // Assigns the 1st value if true and otherwise 
            // the 2nd
            bool canDrive = age >= 16 ? true : false;
 
            // Switch is used when you have limited options
            // The only way to use ranges is to stack 
            // the possible values
            switch (age)
            {
                case 1:
                case 2:
                    Console.WriteLine("Go to Day Care");
                    break;
                case 3:
                case 4:
                    Console.WriteLine("Go to Preschool");
                    break;
                case 5:
                    Console.WriteLine("Go to Kindergarten");
                    break;
                default:
                    Console.WriteLine("Go to another school");
                    // You can also jump out of a switch
                    // with goto
                    goto OtherSchool;
            }
 
            OtherSchool:
            Console.WriteLine("Elementary, Middle, High School");
 
            // To compare strings use Equals
            string name = "Derek";
            string name2 = "Derek";
 
            if (name.Equals(name2, StringComparison.Ordinal))
            {
                Console.WriteLine("Names are Equal");
            }
 
            // ----- WHILE LOOP -----
            // You use the while loop when you want to execute
            // as long as a condition is true
 
            // This while loop will print odd numbers between
            // 1 and 10
            int i = 1;
            while (i <= 10)
            {
                // % (Modulus) returns the remainder of a
                // division. If it returns 0 that means the
                // value is even
                if (i % 2 == 0)
                {
                    i++;
 
                    // Continue skips the rest of the code and 
                    // starts execution back at the top of the 
                    // while
                    continue;
                }
 
                // Break jumps completely out of the loop
                if (i == 9) break;
 
                Console.WriteLine(i);
                i++;
            }
 
            // ----- DO WHILE LOOP -----
            // Use do while when you must execute the code
            // at least once
 
            // Generate a random number
            Random rnd = new Random();
            int secretNumber = rnd.Next(1, 11);
            int numberGuessed = 0;
 
            do
            {
                Console.Write("Enter a number between 1 & 10 : ");
 
                // Use Convert to switch the string into an int
                numberGuessed = Convert.ToInt32(Console.ReadLine());
 
            } while (secretNumber != numberGuessed);
 
            Console.WriteLine("You guessed it is was {0}",
                secretNumber);
 
            // Other Convert options : ToBoolean, ToByte,
            // ToChar, ToDecimal, ToDouble, ToInt64,
            // ToString, and they can convert from any 
            // type to any other type
 
            // ----- EXCEPTION HANDLING -----
            // We use exception handling to catch errors
            // that could crash our program
            double num1 = 5;
            double num2 = 0;
 
            // Code that could cause an error is surrounded
            // by a try block
            try { 
            Console.WriteLine("5 / 0 = {0}", 
                DoDivision(num1, num2));
            }
 
            // We catch the error and warn the user 
            // rather then crash the program
            catch (DivideByZeroException ex)
            {
                Console.WriteLine("You can't Divide by Zero");
 
                // Get additonal info on the exception
                Console.WriteLine(ex.GetType().Name);
                Console.WriteLine(ex.Message);
 
            }
 
            // This is the default catch all for exceptions
            catch (Exception ex)
            {
                Console.WriteLine("An error occurred");
                Console.WriteLine(ex.GetType().Name);
                Console.WriteLine(ex.Message);
            }
 
            // finally always runs and provides for clean up
            finally
            {
                Console.WriteLine("Cleaning Up");
            }
 
            // Well cover more about exception handling 
            // with some real examples soon
 
            Console.ReadLine();
 
        }
 
        static double DoDivision(double x, double y)
        {
            if(y == 0)
            {
                // We are throwing an exception because
                // you can't divide by zero
                throw new System.DivideByZeroException();
            }
            return x / y;
        }
 
    }
}
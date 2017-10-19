C# Tutorial 4C#

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
            // ----- PASSING BY VALUE -----
            double x = 5;
            double y = 4;

            Console.WriteLine("5 + 4 = {0}",
                GetSum(x, y));

            // Even though the value for x changed in 
            // method it remains unchanged here
            Console.WriteLine("x = {0}",
                x);

            // ----- OUT PARAMETER -----
            // You can pass a variable as an output 
            // variable even without assigning a
            // value to it
            int solution;

            // A parameter passed with out has its
            // value assigned in the method
            DoubleIt(15, out solution);

            Console.WriteLine("15 * 2 = {0}",
                solution);

            // ----- PASS BY REFERENCE -----
            int num1 = 10;
            int num2 = 20;

            Console.WriteLine("Before Swap num1 : {0} num2 : {1}", num1, num2);

            Swap(ref num1, ref num2);

            Console.WriteLine("After Swap num1 : {0} num2 : {1}", num1, num2);

            // ----- PARAMS -----
            // You are able to pass a variable amount
            // of data of the same data type into a 
            // method using params. You can also pass
            // in an array. 
            Console.WriteLine("1 + 2 + 3 = {0}",
                GetSumMore(1, 2, 3));

            // ----- NAMED PARAMETERS -----
            // You can pass values in any order if
            // you used named parameters
            PrintInfo(zipCode: 15147,
                name: "Derek Banas");

            // ----- METHOD OVERLOADING -----
            // You can define methods with the same 
            // name that will be called depending on
            // what data is sent automatically
            Console.WriteLine("5.0 + 4.0 = {0}",
                GetSum(5.0, 4.5));

            Console.WriteLine("5 + 4 = {0}",
                GetSum(5, 4));

            Console.WriteLine("5 + 4 = {0}",
                GetSum("5", "4"));

            // ----- ENUM -----
            CarColor car1 = CarColor.Blue;
            PaintCar(car1);


            Console.ReadLine();

        }

        // ----- PASS BY VALUE -----
        // By default values are passed into a method
        // and not a reference to the variable passed
        // Changes made to those values do not effect the
        // variables outside of the method

        // If you assign a value then it is optional to 
        // pass
        static double GetSum(double x = 1, double y = 1)
        {
            double temp = x;
            x = y;
            y = temp;
            return x + y;
        }

        // ----- OUT PARAMETER -----
        // A parameter marked with out must be assigned 
        // a value in the method
        static void DoubleIt(int x, out int solution)
        {
            solution = x * 2;
        }

        // ----- PASS BY REFERENCE -----
        // If a variable is passed by reference changes
        // to its value in the method effect it outside
        // of the method
        public static void Swap(ref int num1, ref int num2)
        {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // ----- PARAMS -----
        // The params array must be the last parameter
        // in the list
        static double GetSumMore(params double[] nums)
        {
            double sum = 0;
            foreach (int i in nums)
            {
                sum += i;
            }
            return sum;
        }

        // ----- NAMED PARAMETERS -----
        static void PrintInfo(string name, int zipCode)
        {
            Console.WriteLine("{0} lives in the zip code {1}", name, zipCode);
        }

        // ----- METHOD OVERLOADING -----
        static double GetSum(double x = 1, double y = 1)
        {
            return x + y;
        }

        static double GetSum(string x = "1", string y = "1")
        {
            double dblX = Convert.ToDouble(x);
            double dblY = Convert.ToDouble(y);
            return dblX + dblY;
        }

        // ----- ENUM -----
        // ----- ENUM -----
        // An enum is a custom data type with
        // key value pairs. They allow you to
        // use symbolic names to represent data
        // The first number is 0 by default unless
        // you change it
        // You can define the underlying type
        // or leave it as int as default

        enum CarColor : byte
        {
            Orange = 1,
            Blue,
            Green,
            Red,
            Yellow
        }

        static void PaintCar(CarColor cc)
        {
            Console.WriteLine("The car was painted {0} with the code {1}",
                cc, (int)cc);
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
            // ----- PASSING BY VALUE -----
            double x = 5;
            double y = 4;
 
            Console.WriteLine("5 + 4 = {0}",
                GetSum(x, y));
 
            // Even though the value for x changed in 
            // method it remains unchanged here
            Console.WriteLine("x = {0}",
                x);
 
            // ----- OUT PARAMETER -----
            // You can pass a variable as an output 
            // variable even without assigning a
            // value to it
            int solution;
 
            // A parameter passed with out has its
            // value assigned in the method
            DoubleIt(15, out solution);
 
            Console.WriteLine("15 * 2 = {0}",
                solution);
 
            // ----- PASS BY REFERENCE -----
            int num1 = 10;
            int num2 = 20;
 
            Console.WriteLine("Before Swap num1 : {0} num2 : {1}", num1, num2);
 
            Swap(ref num1, ref num2);
 
            Console.WriteLine("After Swap num1 : {0} num2 : {1}", num1, num2);
 
            // ----- PARAMS -----
            // You are able to pass a variable amount
            // of data of the same data type into a 
            // method using params. You can also pass
            // in an array. 
            Console.WriteLine("1 + 2 + 3 = {0}",
                GetSumMore(1, 2, 3));
 
            // ----- NAMED PARAMETERS -----
            // You can pass values in any order if
            // you used named parameters
            PrintInfo(zipCode: 15147,
                name: "Derek Banas");
 
            // ----- METHOD OVERLOADING -----
            // You can define methods with the same 
            // name that will be called depending on
            // what data is sent automatically
            Console.WriteLine("5.0 + 4.0 = {0}",
                GetSum(5.0, 4.5));
 
            Console.WriteLine("5 + 4 = {0}",
                GetSum(5, 4));
 
            Console.WriteLine("5 + 4 = {0}",
                GetSum("5", "4"));
 
            // ----- ENUM -----
            CarColor car1 = CarColor.Blue;
            PaintCar(car1);
 
 
            Console.ReadLine();
 
        }
 
        // ----- PASS BY VALUE -----
        // By default values are passed into a method
        // and not a reference to the variable passed
        // Changes made to those values do not effect the
        // variables outside of the method
 
        // If you assign a value then it is optional to 
        // pass
        static double GetSum(double x = 1, double y = 1)
        {
            double temp = x;
            x = y;
            y = temp;
            return x + y;
        }
 
        // ----- OUT PARAMETER -----
        // A parameter marked with out must be assigned 
        // a value in the method
        static void DoubleIt(int x, out int solution)
        {
            solution = x * 2;
        }
 
        // ----- PASS BY REFERENCE -----
        // If a variable is passed by reference changes
        // to its value in the method effect it outside
        // of the method
        public static void Swap(ref int num1, ref int num2)
        {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
 
        // ----- PARAMS -----
        // The params array must be the last parameter
        // in the list
        static double GetSumMore(params double[] nums)
        {
            double sum = 0;
            foreach (int i in nums)
            {
                sum += i;
            }
            return sum;
        }
 
        // ----- NAMED PARAMETERS -----
        static void PrintInfo(string name, int zipCode)
        {
            Console.WriteLine("{0} lives in the zip code {1}", name, zipCode);
        }
 
        // ----- METHOD OVERLOADING -----
        static double GetSum(double x = 1, double y = 1)
        {
            return x + y;
        }
 
        static double GetSum(string x = "1", string y = "1")
        {
            double dblX = Convert.ToDouble(x);
            double dblY = Convert.ToDouble(y);
            return dblX + dblY;
        }
 
        // ----- ENUM -----
        // ----- ENUM -----
        // An enum is a custom data type with
        // key value pairs. They allow you to
        // use symbolic names to represent data
        // The first number is 0 by default unless
        // you change it
        // You can define the underlying type
        // or leave it as int as default
 
        enum CarColor : byte
        {
            Orange = 1,
            Blue,
            Green,
            Red,
            Yellow
        }
 
        static void PaintCar(CarColor cc)
        {
            Console.WriteLine("The car was painted {0} with the code {1}",
                cc, (int)cc);
        }
 
    }
}
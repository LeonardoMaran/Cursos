4 ROW TREE
02
 
03
_______1
04
___1_______1
05
_1___1___1___1
06
1_1_1_1_1_1_1_1
07
 
08
1st Row Indent 7 Spaces 0
09
2nd Row Indent 3 Spaces 7
10
3rd Row Indent 1 Spaces 3
11
4th Row Indent 0 Spaces 1
12
 
13
Indent : -2^-n * (-16+2^n) start with 1
14
Spaces : 0 and then whatever Indent was
15
 
16
First Index Per Row
17
0
18
1 2
19
3 4 5 6
20
7 8 9 10 11 12 13 14
21
.5 * (-2 + (Math.pow(2, iteration)))
22
 
23
Items Per Row
24
1, 2, 4, 8
25
Math.pow(2, iteration - 1)
26
 
27
Max Index Per Row
28
indexToPrint + itemsPerRow
29
 
30
Indent Number
31
Indent Number Space Number
32
Indent Number Space Number Space...
33
 
34
I need 1 index followed by multiple numbers & spaces every time
01
public void printTree(int rows) {
02
 
03
        int spaces = 0;
04
 
05
        int iteration = 1;
06
 
07
        while (iteration <= rows) {
08
 
09
            int indent = (int) Math
10
                    .abs(((Math.pow(-2, -iteration)) * (-16 + (Math.pow(2,
11
                            iteration)))));
12
 
13
            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));
14
 
15
            int itemsPerRow = (int) (Math.pow(2, iteration - 1));
16
 
17
            int maxIndexToPrint = indexToPrint + itemsPerRow;
18
 
19
            for (int j = 0; j < indent; j++)
20
                System.out.print(" ");
21
 
22
            for (int l = indexToPrint; l < maxIndexToPrint; l++) {
23
 
24
                System.out.print(theHeap[l].key);
25
 
26
                for (int k = 0; k < spaces; k++)
27
                    System.out.print(" ");
28
 
29
            }
30
 
31
            spaces = indent;
32
 
33
            iteration++;
34
 
35
            System.out.println();
36
 
37
        }
38
 
39
    }

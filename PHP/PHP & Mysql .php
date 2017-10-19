mysqli_connect.php

view sourceprint?
01
<?php
02
// Opens a connection to the database
03
// Since it is a php file it won't open in a browser
04
// It should be saved outside of the main web documents folder
05
// and imported when needed
06
 
07
/*
08
Command that gives the database user the least amount of power
09
as is needed.
10
GRANT INSERT, SELECT, DELETE, UPDATE ON test3.*
11
TO 'studentweb'@'localhost'
12
IDENTIFIED BY 'turtledove';
13
SELECT : Select rows in tables
14
INSERT : Insert new rows into tables
15
UPDATE : Change data in rows
16
DELETE : Delete existing rows (Remove privilege if not required)
17
*/
18
 
19
// Defined as constants so that they can't be changed
20
DEFINE ('DB_USER', 'studentweb');
21
DEFINE ('DB_PASSWORD', 'turtledove');
22
DEFINE ('DB_HOST', 'localhost');
23
DEFINE ('DB_NAME', 'test3');
24
 
25
// $dbc will contain a resource link to the database
26
// @ keeps the error from showing in the browser
27
 
28
$dbc = @mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME)
29
OR die('Could not connect to MySQL: ' .
30
mysqli_connect_error());
31
?>
getstudentinfo.php

01
<?php
02
// Get a connection for the database
03
require_once('../mysqli_connect.php');
04
 
05
// Create a query for the database
06
$query = "SELECT first_name, last_name, email, street, city, state, zip,
07
phone, birth_date FROM students";
08
 
09
// Get a response from the database by sending the connection
10
// and the query
11
$response = @mysqli_query($dbc, $query);
12
 
13
// If the query executed properly proceed
14
if($response){
15
 
16
echo '<table align="left"
17
cellspacing="5" cellpadding="8">
18
 
19
<tr><td align="left"><b>First Name</b></td>
20
<td align="left"><b>Last Name</b></td>
21
<td align="left"><b>Email</b></td>
22
<td align="left"><b>Street</b></td>
23
<td align="left"><b>City</b></td>
24
<td align="left"><b>State</b></td>
25
<td align="left"><b>Zip</b></td>
26
<td align="left"><b>Phone</b></td>
27
<td align="left"><b>Birth Day</b></td></tr>';
28
 
29
// mysqli_fetch_array will return a row of data from the query
30
// until no further data is available
31
while($row = mysqli_fetch_array($response)){
32
 
33
echo '<tr><td align="left">' .
34
$row['first_name'] . '</td><td align="left">' .
35
$row['last_name'] . '</td><td align="left">' .
36
$row['email'] . '</td><td align="left">' .
37
$row['street'] . '</td><td align="left">' .
38
$row['city'] . '</td><td align="left">' .
39
$row['state'] . '</td><td align="left">' .
40
$row['zip'] . '</td><td align="left">' .
41
$row['phone'] . '</td><td align="left">' .
42
$row['birth_date'] . '</td><td align="left">';
43
 
44
echo '</tr>';
45
}
46
 
47
echo '</table>';
48
 
49
} else {
50
 
51
echo "Couldn't issue database query<br />";
52
 
53
echo mysqli_error($dbc);
54
 
55
}
56
 
57
// Close connection to the database
58
mysqli_close($dbc);
59
 
60
?>
addstudent.php

01
<html>
02
<head>
03
<title>Add Student</title>
04
</head>
05
<body>
06
<form action="http://localhost/studentadded.php" method="post">
07
 
08
<b>Add a New Student</b>
09
 
10
<p>First Name:
11
<input type="text" name="first_name" size="30" value="" />
12
</p>
13
 
14
<p>Last Name:
15
<input type="text" name="last_name" size="30" value="" />
16
</p>
17
 
18
<p>Email:
19
<input type="text" name="email" size="30" value="" />
20
</p>
21
 
22
<p>Street:
23
<input type="text" name="street" size="30" value="" />
24
</p>
25
 
26
<p>City:
27
<input type="text" name="city" size="30" value="" />
28
</p>
29
 
30
<p>State (2 Characters):
31
<input type="text" name="state" size="30" maxlength="2" value="" />
32
</p>
33
 
34
<p>Zip Code:
35
<input type="text" name="zip" size="30" maxlength="5" value="" />
36
</p>
37
 
38
<p>Phone Number:
39
<input type="text" name="phone" size="30" value="" />
40
</p>
41
 
42
<p>Birth Date (YYYY-MM-DD):
43
<input type="text" name="birth_date" size="30" value="" />
44
</p>
45
 
46
<p>Sex (M or F):
47
<input type="text" name="sex" size="30" maxlength="1" value="" />
48
</p>
49
 
50
<p>Lunch Cost:
51
<input type="text" name="lunch" size="30" value="" />
52
</p>
53
 
54
<p>
55
<input type="submit" name="submit" value="Send" />
56
</p>
57
 
58
</form>
59
</body>
60
</html>
studentadded.php

001
<html>
002
<head>
003
<title>Add Student</title>
004
</head>
005
<body>
006
<?php
007
 
008
if(isset($_POST['submit'])){
009
     
010
    $data_missing = array();
011
     
012
    if(empty($_POST['first_name'])){
013
 
014
        // Adds name to array
015
        $data_missing[] = 'First Name';
016
 
017
    } else {
018
 
019
        // Trim white space from the name and store the name
020
        $f_name = trim($_POST['first_name']);
021
 
022
    }
023
 
024
    if(empty($_POST['last_name'])){
025
 
026
        // Adds name to array
027
        $data_missing[] = 'Last Name';
028
 
029
    } else{
030
 
031
        // Trim white space from the name and store the name
032
        $l_name = trim($_POST['last_name']);
033
 
034
    }
035
 
036
    if(empty($_POST['email'])){
037
 
038
        // Adds name to array
039
        $data_missing[] = 'Email';
040
 
041
    } else {
042
 
043
        // Trim white space from the name and store the name
044
        $email = trim($_POST['email']);
045
 
046
    }
047
 
048
    if(empty($_POST['street'])){
049
 
050
        // Adds name to array
051
        $data_missing[] = 'Street';
052
 
053
    } else {
054
 
055
        // Trim white space from the name and store the name
056
        $street = trim($_POST['street']);
057
 
058
    }
059
 
060
    if(empty($_POST['city'])){
061
 
062
        // Adds name to array
063
        $data_missing[] = 'City';
064
 
065
    } else {
066
 
067
        // Trim white space from the name and store the name
068
        $city = trim($_POST['city']);
069
 
070
    }
071
 
072
    if(empty($_POST['state'])){
073
 
074
        // Adds name to array
075
        $data_missing[] = 'State';
076
 
077
    } else {
078
 
079
        // Trim white space from the name and store the name
080
        $state = trim($_POST['state']);
081
 
082
    }
083
 
084
    if(empty($_POST['zip'])){
085
 
086
        // Adds name to array
087
        $data_missing[] = 'Zip Code';
088
 
089
    } else {
090
 
091
        // Trim white space from the name and store the name
092
        $zip = trim($_POST['zip']);
093
 
094
    }
095
 
096
    if(empty($_POST['phone'])){
097
 
098
        // Adds name to array
099
        $data_missing[] = 'Phone Number';
100
 
101
    } else {
102
 
103
        // Trim white space from the name and store the name
104
        $phone = trim($_POST['phone']);
105
 
106
    }
107
 
108
    if(empty($_POST['birth_date'])){
109
 
110
        // Adds name to array
111
        $data_missing[] = 'Birth Date';
112
 
113
    } else {
114
 
115
        // Trim white space from the name and store the name
116
        $b_date = trim($_POST['birth_date']);
117
 
118
    }
119
 
120
    if(empty($_POST['sex'])){
121
 
122
        // Adds name to array
123
        $data_missing[] = 'Sex';
124
 
125
    } else {
126
 
127
        // Trim white space from the name and store the name
128
        $sex = trim($_POST['sex']);
129
 
130
    }
131
 
132
    if(empty($_POST['lunch'])){
133
 
134
        // Adds name to array
135
        $data_missing[] = 'Lunch Cost';
136
 
137
    } else {
138
 
139
        // Trim white space from the name and store the name
140
        $lunch = trim($_POST['lunch']);
141
 
142
    }
143
     
144
    if(empty($data_missing)){
145
         
146
        require_once('../mysqli_connect.php');
147
         
148
        $query = "INSERT INTO students (first_name, last_name, email,
149
        street, city, state, zip, phone, birth_date, sex, date_entered,
150
        lunch_cost, student_id) VALUES (?, ?, ?,
151
        ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NULL)";
152
         
153
        $stmt = mysqli_prepare($dbc, $query);
154
         
155
        i Integers
156
        d Doubles
157
        b Blobs
158
        s Everything Else
159
         
160
        mysqli_stmt_bind_param($stmt, "ssssssisssd", $f_name,
161
                               $l_name, $email, $street, $city,
162
                               $state, $zip, $phone, $b_date,
163
                               $sex, $lunch);
164
         
165
        mysqli_stmt_execute($stmt);
166
         
167
        $affected_rows = mysqli_stmt_affected_rows($stmt);
168
         
169
        if($affected_rows == 1){
170
             
171
            echo 'Student Entered';
172
             
173
            mysqli_stmt_close($stmt);
174
             
175
            mysqli_close($dbc);
176
             
177
        } else {
178
             
179
            echo 'Error Occurred<br />';
180
            echo mysqli_error();
181
             
182
            mysqli_stmt_close($stmt);
183
             
184
            mysqli_close($dbc);
185
             
186
        }
187
         
188
    } else {
189
         
190
        echo 'You need to enter the following data<br />';
191
         
192
        foreach($data_missing as $missing){
193
             
194
            echo "$missing<br />";
195
             
196
        }
197
         
198
    }
199
     
200
}
201
 
202
?>
203
 
204
<form action="http://localhost/studentadded.php" method="post">
205
     
206
    <b>Add a New Student</b>
207
     
208
    <p>First Name:
209
<input type="text" name="first_name" size="30" value="" />
210
</p>
211
 
212
<p>Last Name:
213
<input type="text" name="last_name" size="30" value="" />
214
</p>
215
 
216
<p>Email:
217
<input type="text" name="email" size="30" value="" />
218
</p>
219
 
220
<p>Street:
221
<input type="text" name="street" size="30" value="" />
222
</p>
223
 
224
<p>City:
225
<input type="text" name="city" size="30" value="" />
226
</p>
227
 
228
<p>State (2 Characters):
229
<input type="text" name="state" size="30" maxlength="2" value="" />
230
</p>
231
 
232
<p>Zip Code:
233
<input type="text" name="zip" size="30" maxlength="5" value="" />
234
</p>
235
 
236
<p>Phone Number:
237
<input type="text" name="phone" size="30" value="" />
238
</p>
239
 
240
<p>Birth Date (YYYY-MM-DD):
241
<input type="text" name="birth_date" size="30" value="" />
242
</p>
243
 
244
<p>Sex (M or F):
245
<input type="text" name="sex" size="30" maxlength="1" value="" />
246
</p>
247
 
248
<p>Lunch Cost:
249
<input type="text" name="lunch" size="30" value="" />
250
</p>
251
 
252
<p>
253
    <input type="submit" name="submit" value="Send" />
254
</p>
255
     
256
</form>
257
</body>
258
</html>

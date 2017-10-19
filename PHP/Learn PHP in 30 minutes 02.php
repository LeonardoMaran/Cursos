001
<html>
002
 
003
    <head>
004
        <title>Information Gathered</title>
005
    </head>
006
     
007
    <body>
008
         
009
        <!--
010
            You embed PHP code between tags
011
            echo puts what ever is between quotes in the browser
012
             
013
            php code doesn't show if a user tries to view source
014
             
015
            A semicolon has to finish every php statement
016
             
017
            Single quotes : Print what is between them and ignore
018
                escape sequences except for \' and \\
019
             
020
            Double quotes : Print many escape sequences, the values
021
                for variables, and more
022
        -->
023
         
024
        <?php
025
         
026
            /* Multiline
027
                comment */
028
                 
029
            // Single line comment
030
             
031
            # Another single line comment
032
         
033
            echo "<p>Data Processed at </p>";
034
             
035
            // Define the time zone based on the coordinated universal time
036
            date_default_timezone_set('UTC');
037
             
038
            /* Echos the date
039
                h : 12 hr format
040
                H : 24 hr format
041
                i : Minutes
042
                s : Seconds
043
                u : Microseconds
044
                a : Lowercase am or pm
045
                l : Full text for the day
046
                F : Full text for the month
047
                j : Day of the month
048
                S : Suffix for the day st, nd, rd, etc.
049
                Y : 4 digit year
050
            */
051
            echo date('h:i:s:u a, l F jS Y e');
052
            echo "</p>";
053
             
054
            /*
055
                You store values in variables that have a name
056
                that starts with a $
057
                 
058
                Variables can be of any length and contain letters,
059
                numbers, or underscores
060
                 
061
                They can't begin with a digit adnd are case sensitive.
062
                numOfCats is not equal to numofcats
063
                 
064
                A variable is created and given a data type when it
065
                receives a value. That data type can change based on
066
                if the data is changed.
067
                 
068
                a. Integer : Whole Numbers
069
                b. Float : Decimal Numbers
070
                c. String : Strings or characters
071
                d. Boolean : true or false
072
                e. Array : Multiple Items
073
                f. Object : A Object defined by a class
074
                 
075
                A variable by default gets the value NULL
076
                 
077
                You can access values from the html that called
078
                this php script to execute by putting the name
079
                assigned in the html in single quotes
080
                 
081
                The data is stored in an array which is named
082
                $_POST
083
            */
084
             
085
            $usersName = $_POST['username'];
086
            $streetAddress = $_POST['streetaddress'];
087
            $cityAddress = $_POST['cityaddress'];
088
             
089
            echo '<p>Your Information</p>';
090
             
091
            // You can combine variables with text using a .
092
             
093
            echo $usersName. ' lives at </br>';
094
            echo $streetAddress. ' in </br>';
095
            echo $cityAddress. '</br></br>';
096
             
097
            /*
098
                You can define text using heredoc syntax in the
099
                same way you use double quotes.
100
                Starts with <<< and an identifier that can't be
101
                used any place else in the text.
102
                It ends with the identifier and a semicolon
103
                without any white space or anything else.
104
            */
105
            $str = <<<EOD
106
            The customers name is
107
            $usersName and they
108
            live at $streetAddress
109
            in $cityAddress</br></br>
110
EOD;
111
             
112
            echo $str;
113
             
114
            /*
115
                You can define constants thats value can't change
116
                When we call for a constant we don't use a $ and
117
                they are normally uppercase
118
            */
119
            define('PI', 3.1415926);
120
             
121
            echo "The value of PI is " . PI;
122
             
123
            // Arithmetic operators
124
            echo "</br></br>5 + 2 = " . (5 + 2);
125
            echo "</br>5 - 2 = " . (5 - 2);
126
            echo "</br>5 * 2 = " . (5 * 2);
127
             
128
            // You can cast from 1 type to another like this
129
            echo "</br>5 / 2 = " . (integer) (5 / 2);
130
            echo "</br>5 % 2 = " . (5 % 2) . "</br></br>";
131
             
132
            // Use this shortcut when performing an operation using
133
            // the same variable +=, -=, *=, /=, %=, .=
134
             
135
            $randNum = 5;
136
            echo $randNum += 5;
137
             
138
            echo "</br></br>";
139
             
140
            // You can increment and decrement with this shortcut
141
             
142
            echo "++randNum = " . ++$randNum . "</br>";
143
            echo "randNum++ = " . $randNum++;
144
             
145
            echo "</br></br>";
146
             
147
            /*
148
                The reference operator (ampersan / &) can create a
149
                reference to a variable so if one changes so does the
150
                other
151
            */
152
            $refToNum = &$randNum;
153
            $randNum = 100;
154
            echo '$refToNum = ' . $refToNum;
155
             
156
            echo "</br></br>";
157
             
158
            // Comparison Operators : ==, !=, <, >, <=, >=
159
            // === (Equal & Same Type), !== (Not Equal or Same Type)
160
            // An if block will perform one action or another depending
161
            // on conditions
162
            if(5 == 10){
163
             
164
                echo '5 = 10';
165
             
166
            } else {
167
             
168
                echo '5 != 10';
169
             
170
            }
171
             
172
            echo "</br></br>";
173
             
174
            /*
175
                elseif is used when you have more conditions to check
176
            */
177
            $numOfOranges = 4;
178
            $numOfBananas = 36;
179
             
180
            if(($numOfOranges > 25) && ($numOfBananas > 30)){
181
             
182
                echo '25% Discount';
183
             
184
            } elseif (($numOfOranges > 30) || ($numOfBananas > 35)){
185
             
186
                echo '15% Discount';
187
             
188
            } elseif (!(($numOfOranges < 5)) || (!($numOfBananas < 5))){
189
             
190
                echo '5% Discount';
191
             
192
            } else {
193
             
194
                echo 'No Discount For You';
195
             
196
            }
197
             
198
            echo "</br></br>";
199
             
200
            // The ternary operator assigns one or another value
201
            // depending on the condition
202
            // condition ? value if true : value if false
203
             
204
            $biggestNum = (15 > 10) ? 15 : 10;
205
             
206
            echo 'Biggest Number is ' . $biggestNum;
207
             
208
            echo "</br></br>";
209
             
210
            // Switch provides different actions depending upon values
211
             
212
            switch($usersName) {
213
             
214
                case "Derek" :
215
                    echo "Hello Derek";
216
                    break;
217
                     
218
                case "Sally" :
219
                    echo "Hello Sally";
220
                    break;
221
                     
222
                default :
223
                    echo "Hello Valued Customer";
224
                    break;         
225
            }
226
             
227
            echo "</br></br>";
228
             
229
            // The while loop performs actions until a condition is met
230
             
231
            $num = 0;
232
             
233
            while($num < 20){
234
             
235
                echo ++$num . ', ';
236
             
237
            }
238
             
239
            echo "</br></br>";
240
             
241
            // The for loop performs actions until a condition is met
242
            // like the while, but it a compact way
243
             
244
            for($num = 1; $num <= 20; $num++){
245
             
246
                echo $num;
247
                 
248
                if($num != 20){
249
                    echo ', ';
250
                } else {
251
                    break; // or exit() to leave the whole script
252
                }
253
             
254
            }
255
             
256
            echo "</br></br>";
257
             
258
            // An array can store multiple values
259
             
260
            $bestFriends = array('Joy', 'Willow', 'Ivy');
261
             
262
            // You can access an item by index starting with 0
263
             
264
            echo 'My wife ' . $bestFriends[0];
265
             
266
            echo "</br></br>";
267
             
268
            // You can add an item by storing in a unused index
269
             
270
            $bestFriends[4] = 'Steve';
271
             
272
            echo 'My friend ' . $bestFriends[4];
273
             
274
            echo "</br></br>";
275
             
276
            // You could cycle through the array with for or foreach
277
             
278
            foreach($bestFriends as $friend){
279
                 
280
                echo $friend . ', ';
281
             
282
            }
283
             
284
            echo "</br></br>";
285
             
286
            // You can create key value pairs in arrays
287
             
288
            $customer = array('Name'=>$usersName, 'Street'=>$streetAddress, 'City'=>$cityAddress);
289
             
290
            foreach($customer as $key => $value){
291
             
292
                echo $key . ' : ' . $value . '</br>';
293
             
294
            }
295
             
296
            echo "</br></br>";
297
             
298
            // You can combine arrays with +
299
             
300
            $bestFriends = $bestFriends + $customer;
301
             
302
            foreach($bestFriends as $friend){
303
                 
304
                echo $friend . ', ';
305
             
306
            }
307
             
308
            // Other common array operators
309
            // == : Returns true of false if arrays are equal
310
            // != : Returns if not equal
311
            // === : Returns if the same items, same order and data type
312
             
313
            echo "</br></br>";
314
             
315
            // Multidimensional arrays are arrays in arrays
316
             
317
            $customers = array(array('Derek', '123 Main', '15212'),
318
                               array('Sue', '124 Main', '15222'),
319
                               array('Bob', '125 Main', '15212'));
320
                                
321
            for($row = 0; $row < 3; $row++){
322
             
323
                for($col = 0; $col < 3; $col++){
324
                 
325
                    echo $customers[$row][$col] . ', ';
326
                 
327
                }
328
                echo '</br>';
329
             
330
            }
331
             
332
            // Common Array Functions
333
            // sort($yourArray) : Sorts in ascending alphabetical order or
334
            // if you add , SORT_NUMERIC or , SORT_STRING
335
            // asort($yourArray) : sorts arrays with keys
336
            // ksort($yourArray) : sorts by the key
337
            // Put a r infront of the above to sort in reverse order
338
             
339
            echo "</br></br>";
340
             
341
            // Strings store a series of characters
342
             
343
            $randString = "         Random String       ";
344
             
345
            // You can trim white space with ltrim, rtrim, or trim
346
             
347
            echo strlen($randString) . "</br>";
348
            echo strlen(ltrim($randString)) . "</br>";
349
            echo strlen(rtrim($randString)) . "</br>";
350
            echo strlen(trim($randString)) . "</br>";
351
             
352
            echo "</br></br>";
353
             
354
            // printf allows you to print formatted Strings to the screen
355
             
356
            echo "The randomString is $randString </br>";
357
             
358
            printf ("The randomString is %s </br>", $randString);
359
             
360
            // Coversion codes are useful with decimals
361
             
362
            $decimalNum = 2.3456;
363
             
364
            printf ("decimal num = %.2f </br>", $decimalNum);
365
             
366
            // Other conversion codes
367
            // b : integer to binary
368
            // c : integer to character
369
            // d : integer to decimal
370
            // f : double to float
371
            // o : integer to octal
372
            // s : string to string
373
            // x : integer to hexadecimal
374
             
375
            printf ("10 to binary %b </br>", 10);
376
             
377
            echo "</br></br>";
378
             
379
            // String case functions
380
             
381
            echo strtoupper($randString) . "</br>";
382
            echo strtolower($randString) . "</br>";
383
            echo ucfirst($randString) . "</br>";
384
             
385
            echo "</br></br>";
386
             
387
            // Turning strings into arrays and vice versa
388
             
389
            $arrayForString = explode(' ', $randString, 2);
390
             
391
            $stringToArray = implode(' ', $arrayForString);
392
             
393
            echo "</br></br>";
394
             
395
            // Get part of a string
396
             
397
            $partOfString = substr("Random String", 0, 6);
398
             
399
            echo "Part of String $partOfString </br>";
400
             
401
            echo "</br></br>";
402
             
403
            // Comparing Strings
404
             
405
            $man = "Man";
406
            $manhole = "Manhole";
407
             
408
            // Returns 0 is equal
409
            // Returns positive if str1 is greater then str2
410
            // Returns negative if str1 is less than then str2
411
            // strcasecmp() isn't case sensitive
412
             
413
            echo strcmp($man, $manhole) . "</br>";
414
             
415
            echo "</br></br>";
416
             
417
            // strstr() returns every character after the sting to look for
418
            // stristr() isn't case sensitive
419
             
420
            echo "The String " . strstr($randString, "String") . "</br>";
421
             
422
            echo "</br></br>";
423
             
424
            // strpos() returns the location for the match
425
             
426
            echo "Loc of String " . strpos($randString, "String") . "</br>";
427
             
428
            echo "</br></br>";
429
             
430
            // str_replace() replaces a string with another
431
             
432
            $newString = str_replace("String", "Stuff", $randString)  . "</br>";
433
             
434
            echo "New string " . $newString . "</br>";
435
             
436
            echo "</br></br>";
437
             
438
            // Escaping characters
439
             
440
            $dbString = '"Random quotes"';
441
             
442
            echo addslashes($dbString) . "</br>";
443
            echo stripslashes($dbString) . "</br>";
444
             
445
            echo "</br></br>";
446
             
447
            // Get the data type for a variable
448
             
449
            echo 'Data Type for $biggestNum is ' . gettype($biggestNum);
450
             
451
            echo "</br></br>";
452
             
453
            /* You can check for other types of data with
454
                is_array : is_bool : is_double : is_int : is_null :
455
                is_numeric : is_string
456
            */
457
             
458
            // empty() returns true or false if a var has a non-zero value
459
             
460
            echo 'Does $biggestNum exist ';
461
            echo empty($biggestNum) ? 'false' : 'true';
462
             
463
            echo "</br></br>";
464
             
465
            // isset() returns true or false if a variable exists
466
             
467
            echo 'Does $biggestNum exist ';
468
            echo isset($biggestNum) ? 'true' : 'false';
469
             
470
            echo "</br></br>";
471
             
472
            // You can execute unix commands by surrounding with `s
473
            echo `ls -la`; // Unix or OSX
474
             
475
            // echo `dir /w`; WINDOWS
476
             
477
            echo "</br></br>";
478
             
479
            /*
480
                Functions allow you to reuse code
481
                A function must begin with a letter, but can contain
482
                numbers and underscores
483
            */
484
             
485
            function addNumbers($num1, $num2){
486
             
487
                return $num1 + $num2;
488
             
489
            }
490
             
491
            echo "3 + 4 = " . addNumbers(3, 4);
492
             
493
        ?>
494
         
495
    </body>
496
     
497
</html>

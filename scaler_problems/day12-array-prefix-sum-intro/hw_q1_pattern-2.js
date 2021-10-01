/**
 * Pattern Printing -2
Problem Description
Print a Pattern According to The Given Value of A.
Example: For A = 3 pattern looks like:
    1
  2 1
3 2 1

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is an integer denoting A.

Output Format
Return a two-dimensional array where each row in the returned array represents a row in the pattern.

Example Input
Input 1:
 A = 3
Input 2:
 A = 4

Example Output
Output :1
 [
   [0, 0, 1]
   [0, 2, 1]
   [3, 2, 1]
 ]
Output 2:
 [
   [0, 0, 0, 1]
   [0, 0, 2, 1]
   [0, 3, 2, 1]
   [4, 3, 2, 1]
 ]

Example Explanation
Explanation 2:
 For A = 4 pattern looks like:
                                   1
                                 2 1
                               3 2 1
                             4 3 2 1
 So we will return it as two-dimensional array.
 Row 1 contains 3 spaces and 1 integer so spaces will be considered as 0 in the output.
 */

const pattern2 = (A) => {
    let output = [];
    for (let i = 1; i <= A; i++) {
        let innerArray = [];
        for (let j = A; j >= 1; j--) {
            if (j > i) {
                innerArray.push(0);
            }
            else {
                innerArray.push(j);
            }
        }
        output.push(innerArray);
    }
    console.log(output);
}

pattern2(4);
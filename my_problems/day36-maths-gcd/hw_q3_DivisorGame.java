/**
Divisor game

Problem Description
Scooby has 3 three integers A, B and C.
Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell number of special integers less than or equal to A.

Problem Constraints
1 <= A, B, C <= 10^9

Input Format
First argument is a positive integer A
Second argument is a positive integer B
Third argument is a positive integer C

Output Format
One integer corresponding to the number of special integers less than or equal to A.

Example Input
Input 1:
 A = 12
 B = 3
 C = 2
Input 2:
 A = 6
 B = 1
 C = 4

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
Explanation 2:
 Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
 */
 public class hw_q3_DivisorGame {

    //  gcd function
    public int myGcd(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(a > 0) {
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int temp = a;
            a = b % a;   
            b = temp;         
        }
        return b;
    }

    public int solve(int A, int B, int C) {

        // Make use of property =>  lcm(a,b) * gcd(a,b) = a*b
        long lcm = (long)B * (long)C / (long)myGcd(B,C);
        long ans = (long)A / lcm;
        return (int)ans;
    }
}

/* Replicating Substring */

/* Problem Description

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
If it is possible, return 1, else return -1.


Problem Constraints
1 <= Length of string B <= 1000
1 <= A <= 1000
All the alphabets of S are lower case (a - z)

Input Format
First argument is an integer A.
Second argument is a string B.

Output Format
Your function should return 1 if it is possible to re-arrange the characters of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.

Example Input
Input 1:
 A = 2
 B = "bbaabb"
Input 2:
 A = 1
 B = "bc"

Example Output
Output 1:
 1
Output 2:
 1

Example Explanation
Explanation 1:
 We can re-order the given string into "abbabb".
Explanation 2:
 String "bc" is already arranged. */

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(N) where N = length of string B
 * SC: O(N) for HashMap of frequency
 */
public class q3_ReplicatingSubstring {
    public static int canReplicateSubString(int A, String B) {

        // prepare Hashmap of frequency for each Character
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < B.length(); i++) {
            char currentChar = B.charAt(i);
            if (map.containsKey(currentChar)) {
                int currentFreq = map.get(currentChar);
                map.put(currentChar, currentFreq + 1);
            } else {
                map.put(currentChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            // System.out.print(entry.getKey() + "->");
            // System.out.print(entry.getValue() + "\n");

            // read current frequency
            int value = entry.getValue();
            // check if frequency count can be divided into A buckets
            if (value % A != 0) {
                // if not, return -1
                return -1;
            }
        }
        // the string can be rearranged into A substrings as frequency count can be
        // split into A buckets
        return 1;

    }

    public static void main(String[] args) {
        int A1 = 2;
        String B1 = "bbaabb";
        System.out.println("answer -> " + canReplicateSubString(A1, B1));

        int A2 = 1;
        String B2 = "bc";
        System.out.println("answer -> " + canReplicateSubString(A2, B2));

        int A3 = 3;
        String B3 = "bcbcbcb";
        System.out.println("answer -> " + canReplicateSubString(A3, B3));
    }

}

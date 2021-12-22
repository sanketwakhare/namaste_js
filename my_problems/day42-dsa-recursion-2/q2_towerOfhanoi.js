/******
 * Tower of Hanoi
 * 
 * Problem Description
In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
You have the following constraints:
Only one disk can be moved at a time.
A disk is slid off the top of one tower onto another tower.
A disk cannot be placed on top of a smaller disk.
You have to find the solution to the Tower of Hanoi problem.
You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
In each row, there should be 3 integers (disk, start, end), where:

disk - number of disk being moved
start - number of the tower from which the disk is being moved
stop - number of the tower to which the disk is being moved


Problem Constraints
1 <= A <= 18

Input Format
The first argument is the integer A.

Output Format
Return a 2D array with dimensions M x 3 as mentioned above in the description.

Example Input
Input 1:
A = 2
Input 2:
A = 3

Example Output
Output 1:
[1 1 2 ] [2 1 3 ] [1 2 3 ]
Output 2:
[1 1 3 ] [2 1 2 ] [1 3 2 ] [3 1 3 ] [1 2 1 ] [2 2 3 ] [1 1 3 ] 

Example Explanation

Explanation 1:
We shift the first disk to the middle tower.
We shift the second disk to the last tower.
We, finally, shift the first disk from the middle tower to the last tower.

Explanation 2:
We can see that this the only unique path with minimal moves to move all disks from the first to the third tower.
 */

/**
 * 
 * @param {Number} N no of disks
 * @param {Number} s source
 * @param {Number} t temp
 * @param {Number} d destination
 * @param {Array} output output array
 * @returns 
 */
const toh = (N, s, t, d, output) => {

    // base condition: if there are no more disks, return
    if (N === 0) {
        return;
    }
    // move n-1 disks from source to temp using destination
    toh(N - 1, s, d, t, output);
    output.push([N, s, d]);
    // move N-1 disks from temp to destination using source
    toh(N - 1, t, s, d, output);
}

/***
 * 
 * @param {Number} N no of disks
 * @returns an array of array of integers
 */
const towerOfHanoi = function(N) {
    let output = [];
    toh(N, 1, 2, 3, output);
    console.log(`For Disk Size: ${N}, output :`);
    console.log(output);
    return output;
}

towerOfHanoi(2);
towerOfHanoi(1);
towerOfHanoi(3);
towerOfHanoi(5);
towerOfHanoi(8);
towerOfHanoi(13);
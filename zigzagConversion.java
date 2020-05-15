/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

 class Solution {
    String rows[];
    public String convert(String s, int numRows) {
        rows = new String[numRows];
        Arrays.fill(rows, "");
        if (s.length() <= numRows || numRows <= 1) return s;
        for (int i=0; i<numRows; i++) {
            if (i == 0) {
                for (int j=0; j < s.length(); j += numRows*2-2) {
                    rows[i] += s.substring(j, j+1);
                }
            }
            else if (i == numRows-1) {
                for (int j=numRows-1; j < s.length(); j += numRows*2-2) {
                    rows[i] += s.substring(j, j+1);
                }
            }
            else buildStr(s, i, numRows);
        }
        String ret = "";
        for (int i=0; i<numRows; i++) {
            System.out.println(rows[i]);
            ret += rows[i];
        }
        return ret;
    }
    private void buildStr(String s, int r, int numRows) {
        int offset = r;
        while (offset < s.length()) {
            rows[r] += s.substring(offset, offset+1);
            if (rows[r].length() % 2 == 1) {
                offset += (numRows-r)*2 -2;
            }
            else {
                offset += numRows*2 - (numRows-r)*2 ;
            }
        }
    }
}
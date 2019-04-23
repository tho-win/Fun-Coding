/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

import java.util.*;
public class WordBreakwithTST {
    public boolean wordBreak(String s, List<String> wordDict) {
        TST wb= new TST();
        boolean dp[]= new boolean[s.length()+1];
        dp[0]= true;
        for (String key:wordDict) wb.put(key);

        for (int i= 1; i <= s.length(); i++){
            for (int j= 0; j < i; j++){

                if (dp[j] && wb.get(s.substring(j, i))){
                    //System.out.println(s.substring(j, i));
                    dp[i]= true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    private class TST{
        private Node root;

        private class Node{
            private boolean val;
            private char c;
            private Node smaller, equal, larger;
        }
        private void put(String key){
            root= put(root, key, 0);
        }
        private Node put(Node x, String key, int d){
            if (x == null){
                x= new Node();
                x.c= key.charAt(d);
            }
            //System.out.println("x "+x.c+" key "+key+" d "+d+" val "+x.val);
            if (key.charAt(d) < x.c) x.smaller= put(x.smaller, key, d);
            else if (key.charAt(d) > x.c) x.larger= put(x.larger, key, d);
            else if (d < key.length() - 1) x.equal= put(x.equal, key, d+1);
            else x.val= true;
            return x;
        }
        private boolean get(String key){
            return get(root, key, 0);
        }
        private boolean get(Node x, String key, int d){
            //System.out.println("x "+x.c+" key "+key+" d "+d+" val "+x.val);
            if (x == null) return false;
            if (x.val && x.c == key.charAt(d) && d == key.length()-1) return true;
            if (key.charAt(d) < x.c) return get(x.smaller, key, d);
            else if (key.charAt(d) > x.c) return get(x.larger, key, d);
            else if (d < key.length() - 1) return get(x.equal, key, d+1);
            else return false;
        }
    }
    public static void main(String args[]){
        WordBreakwithTST w= new WordBreakwithTST();
        //String s= "applepenapple";
        List<String> wd= new ArrayList<>();
        //wd.add("apple");
        //wd.add("pen");
        //s = "catsandog", wordDict = ["cats", "dog", "sand", "sand", "cat"]
/*
        String s= "catsandog";
        wd.add("cats");
        wd.add("dog");
        wd.add("sand");
        wd.add("cat");
*/

        String s= "abcd";
        wd.add("a");
        wd.add("abc");
        wd.add("b");
        wd.add("cd");

        System.out.println(w.wordBreak(s, wd));
    }
}

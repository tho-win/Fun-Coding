import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WorkBreakwithHash {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wd= new HashSet<>(wordDict);
        boolean dp[]= new boolean[s.length()+1];
        dp[0]= true;

        for (int i= 1; i <= s.length(); i++){
            for (int j= 0; j < i; j++){

                if (dp[j] && wd.contains(s.substring(j, i))){
                    //System.out.println(s.substring(j, i));
                    dp[i]= true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
    public static void main(String args[]){
        WordBreakwithTST w= new WordBreakwithTST();
        //String s= "applepenapple";
        List<String> wd= new ArrayList<>();
        //wd.add("apple");
        //wd.add("pen");
        //s = "catsandog", wordDict = ["cats", "dog", "sand", "sand", "cat"]

        String s= "catsandog";
        wd.add("cats");
        wd.add("dog");
        wd.add("sand");
        wd.add("cat");

/*
        String s= "abcd";
        wd.add("a");
        wd.add("abc");
        wd.add("b");
        wd.add("cd");
*/
        System.out.println(w.wordBreak(s, wd));
    }
}

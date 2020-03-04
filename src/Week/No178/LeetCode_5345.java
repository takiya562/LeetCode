package Week.No178;

import java.util.Arrays;

public class LeetCode_5345 {
    public static String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] ranks = new int[26][len];
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); ++i) {
                int c = vote.charAt(i) - 'A';
                ranks[c][i]++;
            }
        }
        Integer[] index = new Integer[26];
        for (int i = 0; i < 26; ++i)
            index[i] = i;
        Arrays.sort(index, (i, j) -> {
            int n = 0;
            while (n < len && ranks[i][n] == ranks[j][n]) n++;
            if (n == len)   return 0;
            return ranks[j][n] - ranks[i][n];
        });
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; ++i)
            str.append((char)(index[i] + 'A'));
        return str.toString();
    }
    public static void main(String args[]) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        rankTeams(votes);
    }
}

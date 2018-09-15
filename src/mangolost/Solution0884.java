package mangolost;

//We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
//
//        A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
//        Return a list of all uncommon words.
//
//        You may return the list in any order.
//
//
//
//        Example 1:
//
//        Input: A = "this apple is sweet", B = "this apple is sour"
//        Output: ["sweet","sour"]
//        Example 2:
//
//        Input: A = "apple apple", B = "banana"
//        Output: ["banana"]
//
//
//        Note:
//
//        0 <= A.length <= 200
//        0 <= B.length <= 200
//        A and B both contain only spaces and lowercase letters.

import java.util.*;

/**
 *
 */
public class Solution0884 {

    /**
     *
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: A.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word: B.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> list = new LinkedList<>();
        for (String word: count.keySet()) {
            if (count.get(word) == 1) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution0884 solution = new Solution0884();
        String A1 = "this apple is sweet", B1 = "this apple is sour";
        String A2 = "apple apple", B2 = "banana";
        String A3 = "happy everyday reainll", B3 = "reainll is so lovely";
        System.out.println(Arrays.toString(solution.uncommonFromSentences(A1, B1)));
        System.out.println(Arrays.toString(solution.uncommonFromSentences(A2, B2)));
        System.out.println(Arrays.toString(solution.uncommonFromSentences(A3, B3)));
    }
}
package mangolost;

//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//		Only one letter can be changed at a time.
//		Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//		Note:
//
//		Return 0 if there is no such transformation sequence.
//		All words have the same length.
//		All words contain only lowercase alphabetic characters.
//		You may assume no duplicates in the word list.
//		You may assume beginWord and endWord are non-empty and are not the same.
//		Example 1:
//
//		Input:
//		beginWord = "hit",
//		endWord = "cog",
//		wordList = ["hot","dot","dog","lot","log","cog"]
//
//		Output: 5
//
//		Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//		return its length 5.
//		Example 2:
//
//		Input:
//		beginWord = "hit"
//		endWord = "cog"
//		wordList = ["hot","dot","dog","lot","log"]
//
//		Output: 0
//
//		Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

import java.util.*;

/**
 *
 */
public class Solution0127 {

    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(",");
        Map<String, Integer> map = new HashMap<>();
        for (String s : wordList) {
            map.put(s, 1);
        }
        while (!queue.isEmpty()) {
            String wordString = queue.poll();
            StringBuilder word = new StringBuilder(wordString);
            if (!wordString.equals(",")) {
                for (int i = 0, len = word.length(); i < len; i++) {
                    char tmp = word.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i)) {
                            continue;
                        }
                        word.setCharAt(i, c);
                        if (map.getOrDefault(word.toString(), 0) != 0) {
                            queue.offer(word.toString());
                            map.put(word.toString(), 0);
                            if (word.toString().equals(endWord)) {
                                result++;
                                return result;
                            }
                        }
                    }
                    word.setCharAt(i, tmp);
                }
            } else if (!queue.isEmpty()) {
                queue.offer(",");
                result++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution0127 solution = new Solution0127();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>() {
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
                add("cog");
            }
        };
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}

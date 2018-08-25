package mangolost;

//Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
//
//        The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
//
//        Example 1:
//        Input: "UD"
//        Output: true
//        Example 2:
//        Input: "LL"
//        Output: false

/**
 *
 */
public class Solution0657 {

    /**
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int len = moves.length();
        if (len == 0) {
            return true;
        }
        if (len % 2 != 0) {
            return false;
        }
        int xPos = 0, yPos = 0;
        for (int i = 0; i < len; i++) {
            char ch = moves.charAt(i);
            switch (ch) {
                case 'U':
                    yPos++;
                    break;
                case 'D':
                    yPos--;
                    break;
                case 'L':
                    xPos--;
                    break;
                case 'R':
                    xPos++;
                    break;
                default:
            }
        }
        return xPos == 0 && yPos == 0;
    }

    public static void main(String[] args) {
        Solution0657 solution = new Solution0657();
        System.out.println(solution.judgeCircle("UD"));
        System.out.println(solution.judgeCircle("LL"));


    }
}
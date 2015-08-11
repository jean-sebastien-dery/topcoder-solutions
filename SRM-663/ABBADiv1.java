import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ABBADiv1 is the Div-1 Level-1 problem of the SRM-663.
 * 
 * Problem Statement: http://community.topcoder.com/stat?c=problem_statement&pm=13922&rd=16512
 * 
 * @author Jean-Sebastien Dery
 *
 */
public class ABBADiv1 {

    private static final String VALID_INITIAL_VALUE = "Possible";
    private static final String INVALID_INITIAL_VALUE = "Impossible";

    public String canObtain(String initial, String target) {

        Queue<Move> validMoves = new LinkedBlockingQueue<Move>();
        validMoves.add(new Move(initial, target));

        while (!validMoves.isEmpty()) {
            Move aMove = validMoves.poll();
            if (aMove.isLengthSmallerThanTarget()) {
                validMoves.addAll(aMove.generateMoves());
            } else {
                if (aMove.isTarget()) {
                    return VALID_INITIAL_VALUE;
                }
            }
        }

        return INVALID_INITIAL_VALUE;
    }

    /**
     * Represents a possible value.
     * 
     * @author Jean-Sebastien Dery
     *
     */
    private class Move {

        private static final char RIGHT_MOVE_CHAR = 'A';
        private static final char LETF_MOVE_CHAR = 'B';
        private String value;
        private String target;

        Move(String value, String target) {
            this.value = value;
            this.target = target;
        }

        /**
         * Generates up to two valid moves. i.e. Moves that are contained in the target value.
         * 
         * @return A List of valid moves.
         */
        List<Move> generateMoves() {
            List<Move> listOfMoves = new ArrayList<Move>();
            Move leftMove = generateLeftMove();
            if (leftMove.isContainedInTarget()) {
                listOfMoves.add(leftMove);
            }
            Move rightMove = generateRightMove();
            if (rightMove.isContainedInTarget()) {
                listOfMoves.add(rightMove);
            }
            listOfMoves.add(generateRightMove());
            return listOfMoves;
        }

        /**
         * 
         * @return True if value is equal to the target, false otherwise.
         */
        boolean isTarget() {
            return value.equals(target);
        }

        /**
         * 
         * @return True if value's length is smaller than the target, false otherwise.
         */
        boolean isLengthSmallerThanTarget() {
            return value.length() < target.length();
        }

        /**
         * 
         * @return True if value is contained in target, false otherwise.
         */
        boolean isContainedInTarget() {
            String reversedValue = new StringBuilder(value)
                .reverse()
                .toString();
            return target.contains(value) || target.contains(reversedValue);
        }

        /**
         * 
         * @return The resulting right move. i.e. adding 'A' to the current value.
         */
        private Move generateRightMove() {
            return new Move(value + RIGHT_MOVE_CHAR, target);
        }

        /**
         * 
         * @return The resulting left move. i.e. adding 'B' to the current value, and reversing the String.
         */
        private Move generateLeftMove() {
            String transformedValue = new StringBuilder(value)
                .append(LETF_MOVE_CHAR)
                .reverse()
                .toString();
            return new Move(transformedValue, target);
        }
    }
}

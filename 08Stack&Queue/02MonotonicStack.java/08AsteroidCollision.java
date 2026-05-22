import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens only when:
            // top moving right (+) and current moving left (-)
            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                // top asteroid smaller -> destroy top
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                }

                // equal size -> both destroy
                else if (stack.peek() == -asteroid) {
                    stack.pop();
                }

                // current asteroid destroyed
                destroyed = true;
                break;
            }

            // if current asteroid survives
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
import java.util.*;

class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                    currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    //Time optimal but not space (uses extra space for pse and nse array)
    public int largestRectangleAreaII(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        //PSE
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            pse[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        //NSE
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            nse[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        for(int i = 0; i < n; i++){
            int breadth = nse[i] - pse[i] - 1;

            maxArea = Math.max(maxArea, breadth*heights[i]);
        }

        return maxArea;
    }
}
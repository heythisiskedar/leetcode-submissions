class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean survived = true;

            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (stack.peek() < Math.abs(ast)) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == Math.abs(ast)) {
                    stack.pop();
                    survived = false;
                } else {
                    survived = false;
                }
                break;
            }

            if (survived) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
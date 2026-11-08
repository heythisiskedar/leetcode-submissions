class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(new int[] {asteroids[i], i});
                continue;
            }

            
            while (!stack.isEmpty() && stack.peek()[0] < Math.abs(asteroids[i])) {
                asteroids[stack.peek()[1]] = 0;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek()[0] == Math.abs(asteroids[i])) {
                asteroids[stack.peek()[1]] = 0;
                asteroids[i] = 0;
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek()[0] > Math.abs(asteroids[i])) {
                asteroids[i] = 0;
            }            
        }

        int index = 0;
        
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] != 0) {
                asteroids[index] = asteroids[i];
                index++;
            }
        }

        return Arrays.copyOf(asteroids, index);
    }
}
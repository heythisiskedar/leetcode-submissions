class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < fruits.length; j++) {
            basket.put(fruits[j], basket.getOrDefault(fruits[j], 0) + 1);

            if (basket.size() > 2) {
                int leftFruit = fruits[i];
                basket.put(leftFruit, basket.getOrDefault(leftFruit, 0) - 1);
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                i++;
            }
        }

        return fruits.length - i;
    }
}
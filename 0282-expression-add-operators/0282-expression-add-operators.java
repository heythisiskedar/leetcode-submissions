class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(0, num, target, new StringBuilder(), 0, 0, result);
        return result;
    }

    private void backtrack(int index, String num, int target, StringBuilder exp, long currValue, long prevValue, List<String> result) {
        if (index == num.length()) {
            if (currValue == target) {
                result.add(exp.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break;
            }

            String partStr = num.substring(index, i + 1);
            long currNum = Long.parseLong(partStr);
            int len = exp.length();

            if (index == 0) {
                exp.append(partStr);
                backtrack(i + 1, num, target, exp, currNum, currNum, result);
                exp.setLength(len);
            } else {
                exp.append('+').append(partStr);
               backtrack(i + 1, num, target, exp, currValue + currNum, currNum, result); 
                exp.setLength(len);

                exp.append('-').append(partStr);
               backtrack(i + 1, num, target, exp, currValue - currNum, -currNum, result); 
                exp.setLength(len);

                exp.append('*').append(partStr);
                long nextValue = (currValue - prevValue) + (prevValue * currNum);
               backtrack(i + 1, num, target, exp, nextValue,  prevValue * currNum, result); 
                exp.setLength(len);
            }
        }
    }
}
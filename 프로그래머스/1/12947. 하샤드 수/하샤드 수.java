class Solution {
    public boolean solution(int x) {
        int sum = String.valueOf(x)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum();
        return x % sum == 0;
    }
}

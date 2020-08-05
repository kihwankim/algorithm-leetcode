class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int fullBottle = numBottles;
        int emptyBottle = 0;
        int drink = 0;
        while (fullBottle > 0) {
            drink += fullBottle;
            emptyBottle += fullBottle;
            fullBottle = emptyBottle / numExchange;
            emptyBottle %= numExchange;
        }
        return drink + fullBottle;
    }
}
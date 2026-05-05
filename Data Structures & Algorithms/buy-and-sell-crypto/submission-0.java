class Solution {
    public int maxProfit(int[] prices) {
        int MaxProfit=0;
        int minbuy=prices[0];
        for(int sell:prices){
            MaxProfit=Math.max(MaxProfit,sell-minbuy);
            minbuy=Math.min(minbuy,sell);
        }
        return MaxProfit;
    }
}

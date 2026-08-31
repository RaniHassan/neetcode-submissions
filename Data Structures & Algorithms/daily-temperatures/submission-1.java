class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]>s=new Stack<>();
        int[]output=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!s.isEmpty()&&s.peek()[0]<temperatures[i]){
                int[]pair=s.pop();
                output[pair[1]]=i-pair[1];
            }
            s.push(new int[]{temperatures[i],i});
        }
        return output;
    }
}

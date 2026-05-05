class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int[] leftMost=new int[heights.length];
        int[] rightMost=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            leftMost[i]=-1;
            while(!stack.isEmpty()&& heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                leftMost[i]=stack.peek();
            }
            stack.push(i);

        }
        stack.clear();
        for(int i=heights.length-1;i>=0;i--){
            rightMost[i]=heights.length;
            while(!stack.isEmpty()&& heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                rightMost[i]=stack.peek();
            }
            stack.push(i);
        }
        int maxres=0;
        for(int i=0;i<heights.length;i++){
            leftMost[i]+=1;
            rightMost[i]-=1;
            maxres=Math.max(maxres,heights[i]*(rightMost[i]-leftMost[i]+1));
        }
        return maxres;

    }
}

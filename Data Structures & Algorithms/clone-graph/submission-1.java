/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> oldTonew=new HashMap<>();
        if(node==null)return null;
        Queue<Node> q=new LinkedList<>();
        oldTonew.put(node,new Node(node.val));
        q.add(node);
        while(!q.isEmpty()){
            Node cur=q.poll();
            for(Node neig:cur.neighbors){
                if(!oldTonew.containsKey(neig)){
                   oldTonew.put(neig,new Node(neig.val));
                   q.add(neig);
                }
                oldTonew.get(cur).neighbors.add(oldTonew.get(neig));
            }
        }
        return oldTonew.get(node);
    }
}
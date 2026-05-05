/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node copyRandomList(Node head) {
       Map<Node,Node> map =new HashMap<>();
       map.put(null,null);
       Node cur=head;
       while(cur!=null){
        if(!map.containsKey(cur)){
            Node copy =new Node(cur.val);
            map.put(cur,copy);
        }
        cur=cur.next;
       }
       cur=head;
       while(cur!=null){
        map.get(cur).next=map.get(cur.next);
        map.get(cur).random=map.get(cur.random);
        cur=cur.next;
       }
       return map.get(head);
    }
}

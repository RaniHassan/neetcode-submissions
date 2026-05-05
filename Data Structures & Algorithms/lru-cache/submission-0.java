class LRUCache {
 public class Node{
    private int value;
    private int key;
    private Node next;
    private Node prev;
    
    
    public Node(int key,int value){
        this.value=value;
        this.key=key;
        this.next=null;
        this.prev=null;
    }
 }
    private Map<Integer,Node> cache;
    private Node right;
    private Node left;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.right=new Node(0,0);
        this.left=new Node(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;
    }
    public void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public void insert(Node node){
        node.next=this.right;
        this.right.prev.next=node;
        node.prev=this.right.prev;
        this.right.prev=node;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node =cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node =cache.get(key);
            remove(node);
        }
        Node node=new Node(key,value);
        cache.put(key,node);
        insert(node);
        
        if(cache.size()>this.capacity){
            Node remove= this.left.next;
            remove(remove);
            cache.remove(remove.key);
        }
        
        
    }
}

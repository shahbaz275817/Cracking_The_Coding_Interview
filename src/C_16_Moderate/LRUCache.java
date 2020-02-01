package C_16_Moderate;

import javax.print.DocFlavor;
import java.util.Hashtable;
import java.util.Set;

public class LRUCache {

    public static void main(String[] args) {
        int cache_size = 5;
        Cache cache = new Cache(cache_size);

        cache.setKeyValue(1, "1");
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(2, "2");
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(3, "3");
        System.out.println(cache.getCacheAsString());
        cache.getValue(1);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(4, "4");
        System.out.println(cache.getCacheAsString());
        cache.getValue(2);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(5, "5");
        System.out.println(cache.getCacheAsString());
        cache.getValue(5);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(6,  "6");
        System.out.println(cache.getCacheAsString());
        cache.getValue(1);
        System.out.println(cache.getCacheAsString());
        cache.setKeyValue(5, "5");
        System.out.println(cache.getCacheAsString());
        cache.getValue(3);
        System.out.println(cache.getCacheAsString());
        // 6->5->2->4->1
    }
}

class Cache {
    int maxSize;
    Hashtable<Integer, LinkedListNode> cache = new Hashtable<>(maxSize);
    LinkedListNode headNode = null;
    LinkedListNode tailNode = null;
    public Cache(int size){
        maxSize = size;
    }

    void removeKey(int key){
        LinkedListNode node = cache.get(key);
        cache.remove(key);
        removeFromLinkedList(node);
    }

    void setKeyValue(int key, String value) {
        removeKey(key);

        if (cache.size() >= maxSize && tailNode != null) {
            removeKey(tailNode.key);
        }
        //create a LL node
        LinkedListNode node = new LinkedListNode(key,value);
        cache.put(key,node);
        insertAtFrontOfLinkedList(node);


    }

    String getValue(int key){
        LinkedListNode node = cache.get(key);
        if(node == null)
            return null;
        else{
            //remove tail;
            //move the node to the head;
            if(node != headNode){
                removeFromLinkedList(node);
                insertAtFrontOfLinkedList(node);
            }
        }
        return node.value;
    }


    public void insertAtFrontOfLinkedList(LinkedListNode node){
        if(headNode == null){
           headNode = node;
           tailNode = node;
        }
        else{
            node.next = headNode;
            headNode.prev = node;
            headNode = node;
            headNode.prev = null;
        }

    }

    public void removeFromLinkedList(LinkedListNode node){
        if (node == null){
            return;
        }
        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        if(node == tailNode){
            tailNode = node.prev;
        }
        if(node  == headNode){
            headNode = node.next;
        }
    }

    String getCacheAsString(){
        /*StringBuilder cacheValues = new StringBuilder();
        for(Integer key: cache.keySet()){
            cacheValues.append(cache.get(key)).append(" ->");
        }
        cacheValues.replace(cacheValues.length()-3,cacheValues.length()-1,"");
        return cacheValues.toString();*/
        if (headNode == null) return "";
        return headNode.printForward();
    }

    private class LinkedListNode {
        private LinkedListNode next;
        private LinkedListNode prev;
        public int key;
        public String value;
        public LinkedListNode(int k, String value){
            key = k;
            this.value = value;
        }

        public String printForward(){
            String s = "("+key+": "+value+")";
            if(next != null){
                return s + " ->" + next.printForward();
            }
            else
                return s;
        }

    }
}

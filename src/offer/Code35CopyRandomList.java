package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiXxuan
 * @date 2020/7/27 10:18
 */
// Definition for a Node.

public class Code35CopyRandomList {
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
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        Node p=head;
        Node q=null;
        Node newHead=null;
        Map<Node, Node> map = new HashMap<>();
        while (p!=null){
            if (newHead==null){
                newHead = new Node(head.val);
                q=newHead;
                map.put(head,newHead);
            }else {
                if(p.next!=null&&map.containsKey(p.next)){
                    q.next=map.get(p.next);
                }else{
                    if (p.next!=null){
                        Node temp=new Node(p.next.val);
                        map.put(p.next, temp);
                        q.next=temp;
                    }
                }
                if(p.random!=null&&map.containsKey(p.random)){
                    q.random=map.get(p.random);
                }else {
                    if(p.random!=null){
                        Node temp=new Node(p.random.val);
                        map.put(p.random, temp);
                        q.random=temp;
                    }
                }
                p=p.next;
                q=q.next;
            }

        }
        return newHead;
    }
}

package letcode.linked;

/**
 * 题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null；
 * 快慢指针，判断是否有环，相遇的点判断方法。
 *
 * 快慢指针处于相遇点的时候，环的起点.......
  *
 */
public class DetectedCycle {

    public Linked detected(Linked node){
        Linked slow = node;
        Linked fast = node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                // 相遇了，找相遇点；
                Linked index1 = node;
                Linked index2 = slow;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Linked linked1 = new Linked(3);
        Linked linked2 = new Linked(2);
        Linked linked3 = new Linked(0);
        Linked linked4 = new Linked(-4);
        linked1.next = linked2;
        linked2.next = linked3;
        linked3.next = linked4;
        linked4.next = linked2;

        Linked meet = new DetectedCycle().detected(linked1);
        if (meet != null){
            System.out.println(meet.value);
        }
    }
}

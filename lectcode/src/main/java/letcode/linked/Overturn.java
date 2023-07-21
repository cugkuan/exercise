package letcode.linked;

/**
 * 链表翻转
 */
public class Overturn {


    public  Linked  recursion(Linked current){
        if (current.next == null){
            return current;
        }
        Linked last = recursion(current.next);
        current.next.next = current;
        current.next = null;
        return last;
    }

    public Linked overturn(Linked node){
        Linked pre = null;
        Linked cur = node;
        Linked temp = null;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public static void main(String[] args){
        Linked linked1 = new Linked(1);
        Linked linked2 = new Linked(2);
        Linked linked3 = new Linked(3);
        Linked linked4 = new Linked(4);
        Linked linked5 = new Linked(5);
        linked1.next = linked2;
        linked2.next = linked3;
        linked3.next = linked4;
        linked4.next = linked5;
        linked5.next = null;
        linked1.print();
      //  new Overturn().overturn(linked1);

        Overturn overturn = new Overturn();
        Linked node =  overturn.recursion(linked1);
        node.print();

         Linked node2 = overturn.overturn(node);
         node2.print();

     //   new Overturn().overturn2(linked1);

        // 进行翻转






    }
}

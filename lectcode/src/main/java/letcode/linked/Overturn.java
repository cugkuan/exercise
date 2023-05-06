package letcode.linked;

/**
 * 链表翻转
 */
public class Overturn {
    public void overturn(Linked node){
        Linked result =  turn2(null,node);
        result.print();
    }

    public void overturn2(Linked node){
        Linked pre = null;
        Linked cur = node;
        Linked temp = null;
        while (cur.next != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        pre.print();
    }
    private Linked turn(Linked pre,Linked current){
        if (current == null) return pre;
        Linked temp = current.next;
        current.next = pre;
        return turn(current,temp);
    }
    private Linked turn2(Linked current,Linked next){
        if (next == null) return  current;
        Linked temp = next.next;
        next.next = current;
        return turn2(next,temp);

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
        linked1.print();
      //  new Overturn().overturn(linked1);
        new Overturn().overturn2(linked1);

        // 进行翻转






    }
}

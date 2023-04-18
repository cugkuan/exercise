package letcode.linked;

/**
 * 单链表结构
 */
public class Linked {
    public int value;
    public Linked next = null;

    public Linked(int value ){
        this.value = value;
    }
    public Linked(Linked next,int value ){
        this.next = next;
        this.value = value;
    }

    public void print(){
        Linked node = this;
        StringBuilder builder = new StringBuilder();
        builder.append(node.value);
        builder.append(",");
        while (node.next != null){
            node = node.next;
            builder.append(node.value);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder);
    }
}

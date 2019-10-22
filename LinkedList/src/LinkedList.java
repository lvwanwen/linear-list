//创建节点类,节点中既有数据，也有下一个元素的位置（引用，低配指针）
class LinkedNode{
    public int data=0;
    public LinkedNode next=null;

    //要直接使用LinkedNode类时，其()中没有数据，所以需要一个LinkedNode的构造函数
    public LinkedNode(int data) {
        this.data = data;
    }
}
public class LinkedList {
    //链表的头结点，有了这个头结点之后，就可以根据next把所有的剩下的元素都获取到
    private LinkedNode head=null;
    public void addFirst(int elem){
        //先创建一个节点，让这个节点的值就是elem
        LinkedNode node=new LinkedNode(elem);
        if(this.head==null){
            //空链表的情况
            this.head=node;
            return;
        }
        //如果不是空链表，就需要把新的节点放到链表的开始位置上
        node.next=head;
        this.head=node;
        return;
    }
    public void addLast(int elem){
        LinkedNode node=new LinkedNode(elem);
        //如果是空链表，直接把这个节点放上去即可
        if(this.head==null) {
            this.head = node;
            return;
        }
        //非空的情况，需要先找到最后一个节点
        LinkedNode cur=this.head;
        //这个循环结束之后，cur势必就是最后一个节点
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    public void addIndex(int index,int elem){
        LinkedNode node=new LinkedNode(elem);
        //1.先对index进行合法性校验，需要知道链表的长度
        int len=size();
        if(index<0||index>len){
            return;
        }
        //2.处理头插的情况
        if(index==0){
            addFirst(elem);
            return;
        }
        //3.尾插
        if(index==len){
            addLast(elem);
            return;
        }
        //4.处理插入到中间位置的情况
        //prev这个引用就对应到index-1的位置
        LinkedNode prev=getIndexPos(index-1);
        node.next=prev.next;
        prev.next=node;
    }
    private LinkedNode getIndexPos(int index){
        LinkedNode cur=this.head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }
    public int size(){
        int size=0;
        for(LinkedNode cur=this.head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }
    public boolean contains(int toFind){
        //直接遍历链表，依次比较每个元素就行了
        for(LinkedNode cur=this.head;cur!=null;cur=cur.next){
            if(cur.data==toFind){
                return true;
            }
        }
        return false;
    }
    public void remove(int toRemove){
        //1.先单独处理下空链表的情况
        if(head==null){
            return;
        }
        //2.先考虑是否要删除的是头结点
        if(head.data==toRemove){
            this.head=this.head.next;
            return;
        }
        //3.删除中间的节点，找到要删除元素的前一个元素
        LinkedNode prev=searchPrev(toRemove);
        if(prev==null){
            return;
        }
        LinkedNode nodeToRemove=prev.next;
        prev.next=nodeToRemove.next;
    }
    public void removeAllKey(int toRemove){
        if(head==null){
            return;
        }
        //先处理后续的节点，最后处理头结点的情况
        LinkedNode prev=head;
        LinkedNode cur=head.next;
        while(cur!=null){
            if(cur.data==toRemove){
                //cur对应的节点就应该删掉
                prev.next=cur.next;//删除cur指向的节点
                cur=prev.next;//让cur继续指向prev的下一个节点
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        //头结点的情况
        if(this.head.data==toRemove){
            this.head=this.head.next;
        }
        return;
    }
    private LinkedNode searchPrev(int toRemove){
        //找到要删除元素的前一个元素
        if(head==null){
            return null;
        }
        LinkedNode prev=this.head;
        while(prev.next!=null){
            if(prev.next.data==toRemove){
                return prev;
            }
            prev=prev.next;
        }
        //返回null表示没找到
        return null;
    }
    public void display(){
        //打印链表中的所有元素
        System.out.print("[");
        for(LinkedNode node=this.head;node!=null;node=node.next){
            System.out.print(node.data);
            if(node.next!=null){
                //如果不是最后一个元素就加，否则不加
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    public void clear(){
        //Java垃圾回收，后续的所有节点，只要这个节点没有引用指向它，就会被JVM判定成垃圾，就会被自动回收掉
        this.head=null;
    }
}

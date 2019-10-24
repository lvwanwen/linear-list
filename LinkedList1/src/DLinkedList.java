class DLinkedNode{
    public int val=0;
    public DLinkedNode prev=null;
    public DLinkedNode next=null;

    public DLinkedNode(int val) {
        this.val = val;
    }
}
public class DLinkedList {
private DLinkedNode head=null;

    public DLinkedList() {
        //创建傀儡节点
        head = new DLinkedNode(-1);
        //带环
        head.next=head;
        head.prev=head;
    }
    public void addFirst(int data){
        DLinkedNode newNode=new DLinkedNode(data);
        DLinkedNode next=head.next;
        head.next=newNode;
        newNode.next=next;
        next.prev=newNode;
        newNode.prev=head;
    }
    public void addLast(int data){
        DLinkedNode newNode=new DLinkedNode(data);
        DLinkedNode prev=head.prev;
        prev.next=newNode;
        newNode.prev=prev;
        head.prev=newNode;
        newNode.next=head;
    }
    public void addIndex(int index,int data) {
        int size = size();
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        DLinkedNode next=getPos(index);
        DLinkedNode prev=next.prev;
        DLinkedNode newNode=new DLinkedNode(data);
        prev.next=newNode;
        newNode.prev=prev;
        newNode.next=next;
        next.prev=newNode;
    }
    private DLinkedNode getPos(int index){
        //找到下标为index对应的节点
        DLinkedNode cur=head.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }
    public int size(){
        int size=0;
        for(DLinkedNode cur=head.next;cur!=head;cur=cur.next){
            size++;
        }
        return size;
    }
    public boolean contains(int key){
        for(DLinkedNode cur=head.next;cur!=head;cur=cur.next){
            if(cur.val==key){
                return true;
            }
        }
        return false;
    }
    public void remove(int key){
        //先根据key找到要删除的元素的位置
        DLinkedNode toRemove=find(key);
        if(toRemove==null){
            //没有找到要删除的节点
            return;
        }
        DLinkedNode prev=toRemove.prev;
        DLinkedNode next=toRemove.next;
        prev.next=next;
        next.prev=prev;
    }
    public void removeAllKey(int key){
        while(true){
            DLinkedNode toRemove=find(key);
            if(toRemove==null){
                //没有找到要删除的节点
                return;
            }
            DLinkedNode prev=toRemove.prev;
            DLinkedNode next=toRemove.next;
            prev.next=next;
            next.prev=prev;
        }
    }
    private DLinkedNode find(int key){
        for(DLinkedNode cur=head.next;cur!=head;cur=cur.next){
            if(cur.val==key){
                return cur;
            }
        }
        return null;
    }
    public void display(){
        System.out.print("正向:[");
        for(DLinkedNode cur=head.next;cur!=head;cur=cur.next){
            System.out.print(cur.val);
            if(cur.next!=head){
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.print("反向:[");
        for(DLinkedNode cur=head.prev;cur!=head;cur=cur.prev){
            System.out.print(cur.val);
            if(cur.prev!=head){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    public void clear(){
        //clear预期得到的是一个初始状态下的空链表
        //初始状态带有一个傀儡节点，傀儡节点prev和next指向自身
        head.next=head;
        head.prev=head;
    }
}

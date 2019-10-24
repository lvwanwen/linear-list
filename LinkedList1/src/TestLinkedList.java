public class TestLinkedList {
    public static void main(String[] args){
        testAddFirst();
        testAddLast();
        testAddIndex();
        testContains();
        testRemove();
        testRemoveAllKey();
    }
    public static void testAddFirst(){
        System.out.println("测试头插：");
        LinkedList list=new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
    }
    public static void testAddLast(){
        System.out.println("测试尾插：");
        LinkedList list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
    }
    public static void testAddIndex(){
        System.out.println("测试插入到任意位置：");
        LinkedList list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
        list.addIndex(2,5);
        list.display();
    }
    public static void testContains(){
        System.out.println("测试是否在链表中存在：");
        LinkedList list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        boolean result=list.contains(3);
        System.out.println("result预期值是true,实际值是"+result);
    }
    public static void testRemove() {
        System.out.println("测试删除链表中第一次出现的节点：");
        //要测试的点：1.空链表；2.删除头结点；3.删除普通节点；4.删除一个不存在的元素；5.删除重复元素
        LinkedList list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.remove(3);
        list.display();
    }
    public static void testRemoveAllKey(){
        System.out.println("测试删除链表中所有出现的节点：");
        LinkedList list=new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(3);
        list.addLast(1);
        list.addLast(4);
        list.removeAllKey(1);
        list.display();
    }
}

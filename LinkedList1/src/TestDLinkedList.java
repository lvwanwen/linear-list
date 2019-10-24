public class TestDLinkedList {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
        testContains();
        testRemove();
        testRemoveAllKey();
    }
    public static void testAddFirst(){
        System.out.println("测试双向链表的头插：");
        DLinkedList dLinkedList=new DLinkedList();
        dLinkedList.addFirst(1);
        dLinkedList.addFirst(2);
        dLinkedList.addFirst(3);
        dLinkedList.addFirst(4);
        dLinkedList.display();
    }
    public static void testAddLast(){
        System.out.println("测试双向链表的尾插：");
        DLinkedList dLinkedList=new DLinkedList();
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.display();
    }
    public static void testAddIndex(){
        System.out.println("测试双向链表指定位置插入：");
        DLinkedList dLinkedList=new DLinkedList();
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.addIndex(2,5);
        dLinkedList.display();
    }
    public static void testContains(){
        System.out.println("测试双向链表是否包含指定元素：");
        DLinkedList dLinkedList=new DLinkedList();
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        boolean ret=dLinkedList.contains(3);
        System.out.println("ret="+ret);
    }
    public static void testRemove(){
        System.out.println("测试双向链表删除第一个指定元素：");
        DLinkedList dLinkedList=new DLinkedList();
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(2);
        dLinkedList.addLast(4);
        dLinkedList.remove(2);
        dLinkedList.display();
    }
    public static void testRemoveAllKey(){
        System.out.println("测试双向链表删除所有指定元素：");
        DLinkedList dLinkedList=new DLinkedList();
        dLinkedList.addLast(2);
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(2);
        dLinkedList.removeAllKey(2);
        dLinkedList.display();
    }
}

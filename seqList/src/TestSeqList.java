public class TestSeqList {
    public static void main(String[] args){
        TestAdd();
        TestContains();
        TestSearch();
        TestRemove();
    }
    public static void TestAdd(){
        System.out.println("测试add方法：");
        SeqList seqlist=new SeqList();
        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.add(2,5);
        seqlist.display();
    }
    public static void TestContains(){
        System.out.println("测试contains方法：");
        SeqList seqlist=new SeqList();
        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.add(2,5);
        boolean result=seqlist.contains(5);
        System.out.println("result="+result);
    }
    public static void TestSearch(){
        System.out.println("测试search方法：");
        SeqList seqlist=new SeqList();
        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.add(2,5);
        int result=seqlist.search(5);
        System.out.println("result="+result);
    }
    public static void TestRemove(){
        System.out.println("测试remove方法：");
        SeqList seqlist=new SeqList();
        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.add(2,5);
        seqlist.remove(3);
        System.out.println("预期值是：[1,2,5,4]");
        System.out.println("实际值是:");
        seqlist.display();
    }
}

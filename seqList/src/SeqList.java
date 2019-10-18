import java.util.Arrays;
public class SeqList {
    //创建一个类，一般先考虑这个类要支持哪些操作（分析需求）
    //结合这些操作来考虑要保存什么样的数据
    //初始情况下，这个数组的最大容量是10，这10个元素并不都是有效元素
    //执行插入操作之后，被插入的元素才是有效元素
    private int[] data=new int[10];
    //size表示当前数组中有多少个有效元素
    private int size=0;
    //打印顺序表
    public void display(){
        System.out.print("[");
        for(int i=0;i<size;i++){
            System.out.print(data[i]);
            if(i!=size-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    //在pos位置新增元素
    //pos把元素放到哪个下标上，elem表示插入的元素是啥
    public void add(int pos,int elem){
        //pos=size也允许插入，此时相当于尾插
        if(pos<0||pos>size){
            //pos位置无效
            return;
        }
        if(this.size>=this.data.length){
            //当前容量不够了，需要扩容
            //申请一块更大的空间，把原有数据拷贝过去
            realloc();
        }
        if(pos==size){
            //尾插的情况，直接把新元素放到size下标的位置
            data[pos]=elem;
            size++;
            return;
        }
        //处理插入在中间位置的情况，进行搬运，把后面的元素依次往后移一个，再把elem插到pos位置
        for(int i=size;i>pos;i--){
            data[i]=data[i-1];
        }
        data[pos]=elem;
        size++;
    }
    private void realloc(){
        //扩容的策略很灵活，根据实际问题场景的特点
        //来决定具体是线性增长还是指数增长还是其他啥方式
        //原则是扩容是比较大的开销，尽量应该根据实际场景，让扩容的次数尽量少
        int[] newData=new int[data.length*2];
        for(int i=0;i<data.length;i++){
            newData[i]=data[i];
        }
        this.data=newData;
    }
    //判定是否包含某个元素
    public boolean contains(int toFind){
        return this.search(toFind)!=-1;
    }
    //查找某个元素对应的位置
    public int search(int toFind){
        for(int i=0;i<size;i++){
            if(data[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    //setpos和getpos有可能会越界，抛异常，目前先不管
    //获取pos位置的元素
    public int getpos(int pos){
        return this.data[pos];
    }
    //给pos位置的元素设为elem
    public void setpos(int pos,int elem){
        this.data[pos]=elem;
    }
    //删除第一次出现的关键字
    public void remove(int toRemove){
        int pos=search(toRemove);
        if(pos==-1){
            //这个值不存在，不必删除
            return;
        }
        if(pos==size-1){
            //尾删，直接size--即可，size描述了有效元素的个数
            size--;
            return;
        }
        //如果删除的是一个普通的位置，也需要进行搬运
        for(int i=pos;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
    }
    //获取顺序表长度
    public int size(){
        return this.size;
    }
    //清空顺序表
    public void clear(){
        this.size=0;
        //缩容
        this.data=new int[10];
    }
}

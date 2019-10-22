public class Demo1 {
    // 删除链表中等于给定值val的所有节点
    public ListNode removeElements(ListNode head, int val){
        if(head==null){
            return null;
        }
        //先删除非头结点
        ListNode prev=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.val==val){
                //要删除的节点
                prev.next=cur.next;
                cur=prev.next;
            }else{
                //跳过找下一个节点
                prev=cur;
                cur=cur.next;
            }
        }
        //处理头结点
        if(head.val==val){
            head=head.next;
        }
        return head;
    }
    //反转一个单链表
    public ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        //只有头结点
        if(head.next==null){
            return head;
        }
        //有多个节点
        ListNode newHead=null;
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            if(next==null){
                newHead=cur;
            }
            //翻转指针的指向
            cur.next=prev;
            //更新prev和cur
            prev=cur;
            cur=next;
        }
        return newHead;
    }
    // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    // 如果有两个中间结点，则返回第二个中间结点
    public ListNode middleNode(ListNode head){
        //得到链表的长度
        int steps=size(head)/2;
        //根据长度的一半移动cur的位置
        ListNode cur=head;
        for(int i=0;i<steps;i++){
            cur=cur.next;
        }
        return cur;
    }
    //输入一个链表，输出该链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head,int k){
        int length=size(head);
        if(head==null||k<=0||k>length){
            return null;
        }
        int offset=length-k;
        ListNode cur=head;
        for(int i=0;i<offset;i++){
            cur=cur.next;
        }
        return cur;
    }
    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode newHead=null;
        ListNode newTail=null;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                //就把cur1指向的节点插入到新链表的尾部
                if(newHead==null){
                    //新链表是空链表
                    newHead=cur1;
                    newTail=cur1;
                    cur1=cur1.next;
                }else{
                    //新链表不是空链表
                    newTail.next=cur1;
                    //更新尾部的指向
                    newTail=newTail.next;
                    cur1=cur1.next;
                }
            }else{
                //就把cur2指向的节点插入到新链表的尾部
                if(newHead==null){
                    newHead=cur2;
                    newTail=cur2;
                    cur2=cur2.next;
                }else{
                    newTail.next=cur2;
                    newTail=newTail.next;
                    cur2=cur2.next;
                }
            }
        }
        //判定哪个链表到达结尾，哪个链表还有剩余
        if(cur1==null){
            //cur2还有剩余
            newTail.next=cur2;
        }else{
            //cur1还有剩余
            newTail.next=cur1;
        }
        return newHead;
    }
    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(ListNode pHead, int x){
        if(pHead==null){
            return null;
        }
        if(pHead.next==null){
            return pHead;
        }
        ListNode smallHead=new ListNode(-1);
        ListNode smallTail=smallHead;
        ListNode bigHead=new ListNode(-1);
        ListNode bigTail=bigHead;
        for(ListNode cur=pHead;cur!=null;cur=cur.next){
            if(cur.val<x){
                //插入到smallTail之后
                smallTail.next=new ListNode(cur.val);
                smallTail=smallTail.next;
            }else{
                //插入到bigTail之后
                bigTail.next=new ListNode(cur.val);
                bigTail=bigTail.next;
            }
        }
        smallTail.next=bigHead.next;
        return smallHead.next;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(ListNode pHead){
        //创建一个新的链表，用来放置不重复的元素
        ListNode newHead=new ListNode(-1);
        ListNode newTail=newHead;
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                //说明cur指向的位置已经是重复的节点了
                //继续往后找cur，找到那个不重复的节点的位置
                //这样做是为了把若干个相同的节点都跳过去
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                //循环结束，cur指向的是这篇重复元素的最后一个
                //再多走一步，cur指向的就是不重复的元素了
                cur=cur.next;
            }else{
                //当前这个节点不是重复节点，就把这个节点插入到新链表中
                newTail.next=new ListNode(cur.val);
                newTail=newTail.next;
                cur=cur.next;
            }
        }
        return newHead.next;
    }
    //链表的回文结构
    public boolean chkPalindrome(ListNode A){
        if(A==null){
            //假设算回文
            return true;
        }
        if(A.next==null){
            //只有一个元素，就是回文
            return true;
        }
        //找中间节点
        int len=size(A);
        int steps=len/2;
        ListNode B=A;
        for(int i=0;i<steps;i++){
            B=B.next;
        }
        //分成奇数个情况和偶数个情况，不过可以用相同代码来表示
        //中间节点后面的部分进行逆置
        ListNode prev=null;
        ListNode cur=B;
        while(cur!=null){
            ListNode next=cur.next;
            if(next==null){
                B=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        //对比两个链表内容是否相同
        while(B!=null){
            if(A.val!=B.val){
                return false;
            }
            A=A.next;
            B=B.next;
        }
        return true;
    }
    //链表的回文结构第二种方法
    public boolean palindrome(ListNode A){
        ListNode B=null;
        if(A==null||A.next==null){
            return true;
        }
        ListNode cur=A;
        while(cur.next!=null){
            B=addFirst(cur);
            cur=cur.next;
        }
        while(B!=null){
            if(A.val!=B.val){
                return false;
            }
            A=A.next;
            B=B.next;
        }
        return true;
    }
    public static ListNode addFirst(ListNode head){
        ListNode node=new ListNode(head.val);
        if(head==null){
            return node;
        }
        node.next=head;
        head=node;
        return head;
    }
    public int size(ListNode head){
        int size=0;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            size++;
        }
        return size;
    }
    // 输入两个链表，找出它们的第一个公共结点
    public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        //分别求两个链表的长度
        int lenA = size(headA);
        int lenB = size(headB);
        //让长的链表先走长度的差值步
        if (lenA > lenB) {
            int offset = lenA - lenB;
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            int offset = lenB - lenA;
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        //分别让两个链表的节点同时移动，比较节点是否是相同节点
        while (headA != null && headB != null) {
            //比较对象的身份（地址）
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    // 给定一个链表，判断链表中是否有环
    public boolean hasCycle(ListNode head){
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
   // 给定一个链表，返回链表开始入环的第一个节点.如果链表无环，则返回null
    public ListNode detectCycle(ListNode head){
        //从链表头部出发，到入口点的距离，和从快慢指针的交汇处出发，到入口点的距离相等
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            //不带环
            return null;
        }
        //循环结束之后，fast和slow就已经重合了
        ListNode cur1=head;
        ListNode cur2=fast;
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
}
package demo02_TestNode.Entity;

/**
 * @ClassName HasHeadLinkNode
 * @Description 有头节点单链表
 * @Author zxl
 * @Date 2022/5/31 10:55
 * @Version 1.0
 */
public class HasHeadLinkNode<T> {
    //头结点
    Node head;
    //记录结点个数
    int size;
    public HasHeadLinkNode(){
        //初始化头结点。
        head = new Node<T>(null,null);
    }

    public class Node<T>{ //结点类
        T data;  //对象数值
        Node next;  //指向下一个结点地址
        Node(T data,Node next){ //每个结点都有一个数据域和地址域
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 每次新增都在头节点的下一个
     * @param t
     */
    public void addFirstNode(T t) {
        Node<T> newNode = new Node<T>(t,null);
        // 保存头结点
        Node last = head ;
        if(last.next==null) {
            //空链表直接插入
            last.next = newNode;
            size++;
            return ;
        }
        //不是空链表的情况
        //直接插入在头结点后面，但是要提前记录好头结点的尾指针指向哪里，不然会丢失的
        //保存头结点的指向
        newNode.next = last.next;
        //头结点指向新结点
        last.next = newNode;
        size++;
    }

    /**
     * 每次新增节点，都放到链表最后一个
     * @param t
     */
    public void addLastNode(T t) { //尾插法
        //将对象保存到结点中
        Node<T> newNode = new Node<T>(t,null);
        //保存头结点
        Node last = head;
        if(last.next == null) {
            //空链表直接插入
            last.next = newNode;
            size++;
            return ;
        }
        while(last.next!=null) {
            last = last.next;
        }
        last.next = newNode;
        size++;
    }

    /**
     * 打印链表
     */
    public void list() {
        Node last = head;
        if(last.next == null) {
            //空链表
            System.out.println("链表为空");
            return ;
        }

        while(last.next!=null) {
            System.out.println(last.next.data);
            last = last.next;
        }
    }

}

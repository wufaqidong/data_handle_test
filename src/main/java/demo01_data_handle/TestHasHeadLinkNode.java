package demo01_data_handle;

import Entity.HasHeadLinkNode;


/**
 * @ClassName TestNoHeadLinkNode
 * @Description TODO  测试有头节点单链表
 * @Author zxl
 * @Date 2022/5/31 11:04
 * @Version 1.0
 */
public class TestHasHeadLinkNode {

    public static void main(String[] args) {

        // 构造节点
        HasHeadLinkNode hasHeadLinkNode = new HasHeadLinkNode();
        int i = 1;
        int num = 7;
        while (i<num){
            hasHeadLinkNode.addFirstNode(i);
            i++;
       }
        hasHeadLinkNode.list();
    }

}

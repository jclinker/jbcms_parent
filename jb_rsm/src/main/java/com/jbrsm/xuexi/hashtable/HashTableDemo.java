package com.jbrsm.xuexi.hashtable;

import java.util.Scanner;

/**
 * @author Adminstrator
 * @description: 哈希散列表测试demo
 * @date 2020/11/22 18:35
 */
public class HashTableDemo {

    public static void main(String[] args){
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输出名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }



}
//创建Hashtab管理多条链表
class HashTab{
    private EmplinkedList[] emplinkedListArray;
    private int size;//表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        //初始化emplinkedListArray
        emplinkedListArray = new EmplinkedList[size];
        //初始化每一条链表
        for (int i = 0; i < size; i++) {
            emplinkedListArray[i] = new EmplinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        int emplinkedListNo = hashFun(emp.id);
        //将emp加入到对应的链表中
        emplinkedListArray[emplinkedListNo].add(emp);
    }
    //遍历所有的链表
    public void list(){
        for (int i = 0; i < size; i++) {
            emplinkedListArray[i].list();
        }
    }
    //编写一个散列函数，使用取模法
    public int hashFun(int id){
        return id%size;
    }
}
//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next; //下一个雇员（默认为空）

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//创建EmplinkedList，表示链表
class EmplinkedList{
    //头指针，指向第一个Emp,因此我们这个链表的head是直接指向第一个Emp
    private Emp head;//默认为null

    //添加到雇员链表
    //说明
    //1.假定，当添加雇员时，id是自增长的，即id分配是从小到大的
    //  因此我们将雇员直接加入到本链表最后即可
    public void add(Emp emp){
        //如果是第一个雇员是
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员时，使用辅助指针添加到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){//说明到最后了
                break;
            }
            curEmp = curEmp.next;//后裔
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }
    //遍历链表雇员信息
    public void list(){
        if (head == null){//说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表信息为:");
        Emp curEmp = head;//辅助指针
        while (true){
            System.out.println("=> id=" + curEmp.id + ", name=" + curEmp.name);
            if (curEmp.next == null){//说明已到最后节点
                break;
            }
            curEmp = curEmp.next;//后移
        }
        System.out.println();
    }
}
package parctice.linearDS_10;// Practice1
// ArrayList 를 이용한 데크 구현

import java.util.ArrayList;

class MyDeque1 {
    ArrayList list;

    MyDeque1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if(this.list.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    public void addFirst(int data) {
        this.list.add(0,data);
    }

    public void addLast(int data) {
        this.list.add(data);
    }

    public Integer removeFirst() {
        if(this.isEmpty()){
            System.out.println("Deque is empty!");
            return null;
        }

        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer removeLast() {
        if(this.isEmpty()){
            System.out.println("Deque is empty!");
            return null;
        }
        int data = (int)this.list.get(this.list.size() -1);
        this.list.remove(this.list.size() -1);
        return data;
    }

    public void printDeque() {
         System.out.println(this.list);
    }

}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyDeque1 myDeque = new MyDeque1();
        // Front 부분 입력
 
    }
}

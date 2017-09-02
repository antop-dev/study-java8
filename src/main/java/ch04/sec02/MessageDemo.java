package ch04.sec02;

public class MessageDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Message m1 = new Message("antop", "text");
        m1.addRecipient("jack");
        m1.addRecipient("bill");

        Message m2 = m1.clone(); // clone
        m1.addRecipient("apple");

        System.out.println(m1 == m2); // false
        System.out.println(m1.getRecipients()); // [jack, bill, apple]
        System.out.println(m2.getRecipients()); // [jack, bill, apple] ?
    }
}
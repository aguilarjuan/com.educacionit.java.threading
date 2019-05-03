
package com.educacionit.java.jms.basic;


public class StartupJMS {


    public static void main (String[] args) throws Exception {

        Producer producer = new Producer ();
        producer.create ("educacionit");

        Consumer consumer = new Consumer ();
        consumer.create ("educacionit");


        producer.send ("homer simpson");
        String msg = consumer.get ();


        System.out.println (String.format ("Message received %s", msg));


        producer.close ();
        consumer.close ();
    }
}
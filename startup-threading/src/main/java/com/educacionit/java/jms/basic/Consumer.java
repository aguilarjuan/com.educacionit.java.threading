
package com.educacionit.java.jms.basic;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;


public class Consumer {


    private static String NO_GREETING = "no greeting";

    private Connection connection;
    private MessageConsumer messageConsumer;


    public Consumer () {

        super ();
    }


    public void create (String destinationName) throws JMSException {

        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory (ActiveMQConnection.DEFAULT_BROKER_URL);

        connection = connectionFactory.createConnection ();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(destinationName);

        messageConsumer = session.createConsumer(destination);

        connection.start ();
    }

    public void close () throws JMSException {

        connection.close ();
    }

    public String get () throws JMSException {


        Message message = messageConsumer.receive ();

        String msg;

        if (message != null) {

            TextMessage textMessage = (TextMessage) message;

            msg = textMessage.getText ();

        } else {

            msg = "";
        }

        return msg;
    }
}

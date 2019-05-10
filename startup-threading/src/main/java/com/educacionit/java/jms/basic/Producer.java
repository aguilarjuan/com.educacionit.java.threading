
package com.educacionit.java.jms.basic;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;


public class Producer {


    private Connection connection;
    private Session session;
    private MessageProducer messageProducer;


    public Producer () {

        super ();
    }


    public void create (String destinationName) throws JMSException {


        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory (ActiveMQConnection.DEFAULT_BROKER_URL);

        connection = connectionFactory.createConnection ();

        session = connection.createSession (false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue (destinationName);

        messageProducer = session.createProducer(destination);
    }

    public void close () throws JMSException {

        connection.close ();
    }

    public void send (String customer) throws JMSException {


        TextMessage textMessage = session.createTextMessage (customer);

        messageProducer.send (textMessage);
    }
}
package indi.wsn.mytask.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * FileName: JMSProducer.java
 * jms生产者示例
 *
 * @author SharingWoo
 * @version 1.00
 * @Time 2017/4/18
 */
public class JMSProducer {
    //默认连接用户名
    private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASS_WORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String BROKE_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    //发送的消息数量
    private static final Integer SEND_COUNT = 10;
    //队列名称
    private static final String QUEUE_NAME = "MY_QUEUE";


    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(USER_NAME, PASS_WORD, BROKE_URL);
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;

        try {
            //创建连接
            connection = factory.createConnection();
            //连接
            connection.start();
            //创建session
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //创建destination
            destination = session.createQueue(QUEUE_NAME);
            //创建生产者
            producer = session.createProducer(destination);
            //发送消息
            sendMessage(session, producer);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 发送消息
     * @param session session
     * @param producer 生产者
     * @throws JMSException
     */
    private static void sendMessage(Session session, MessageProducer producer) throws JMSException {
        for (int i = 0; i < SEND_COUNT; i++) {
            //创建一条文本消息
            TextMessage message = session.createTextMessage("ActiveMQ 发送消息" + i);
            System.out.println("发送消息：Activemq 发送消息" + i);
            //通过消息生产者发出消息
            producer.send(message);
        }
    }
}

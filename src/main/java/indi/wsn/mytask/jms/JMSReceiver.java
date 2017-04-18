package indi.wsn.mytask.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * jms消费者示例
 *
 * @author Administrator
 * @version 1.00
 * @Time 2012-11-2014:49:01
 */
public class JMSReceiver {
    //默认连接用户名
    private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASS_WORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String BROKE_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    //队列名称
    private static final String QUEUE_NAME = "MY_QUEUE";
    //获取超时时间
    private static final Integer TIMEOUT = 30000;

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(USER_NAME, PASS_WORD, BROKE_URL);
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        try {
            connection = factory.createConnection();
            //连接
            connection.start();
            //创建session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建destination
            destination = session.createQueue(QUEUE_NAME);
            //创建消费者
            MessageConsumer consumer = session.createConsumer(destination);
            //消费
            getMessage(consumer);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    /**
     * 接收消息
     * @param consumer 消费者
     * @throws JMSException 异常
     */
    private static void getMessage(MessageConsumer consumer) throws JMSException {
        while (true) {
            TextMessage message = (TextMessage) consumer.receive(TIMEOUT);
            if (message != null) {
                System.out.println("收到的消息:" + message.getText());
            } else {
                break;
            }
        }
    }
}

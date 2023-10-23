package cn.lzy.domain8;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/21 16:43
 * @Version 1.0
 */
@Service
public class RabbitMQService {
    //qq接收的信息与日志
    @RabbitListener(bindings = @QueueBinding(value =@Queue("fanout_queue_qq"),exchange = @Exchange(value ="fanout_exchange_qq",
            type = "fanout")))
    public void psubConsumerqq(Message message){
        byte[] body=message.getBody();
        String q=new String(body);
        System.out.println("qq业务收到信息"+q);
    }
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("topic_queue_qq"), exchange =
    @Exchange(value = "topic_exchange", type = "topic"),
            key = "info.#.qq.#"))
    public void topicConsumerQq(String message) {
        System.out.println("接收到QQ订阅需求处理消息： " + message);
    }

    //wx接收的信息与日志
    @RabbitListener(bindings = @QueueBinding(value =@Queue("fanout_queue_wx"),exchange = @Exchange(value ="fanout_exchange_wx",
            type = "fanout")))
    public void psubConsumerwx(Message message){
        byte[] body=message.getBody();
        String q=new String(body);
        System.out.println("wx业务收到信息"+q);
    }
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("topic_queue_wx"), exchange =
    @Exchange(value = "topic_exchange", type = "topic"),
            key = "info.#.wx.#"))
    public void topicConsumerWx(String message) {
        System.out.println("接收到WX订阅需求处理消息： " + message);
    }

    //email接收的信息与日志
    @RabbitListener(bindings = @QueueBinding(value =@Queue("fanout_queue_email"),exchange = @Exchange(value ="fanout_exchange_email",
            type = "fanout")))
    public void psubConsumeremail(Message message){
        byte[] body=message.getBody();
        String q=new String(body);
        System.out.println("email业务收到信息"+q);
    }
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("topic_queue_email"), exchange =
    @Exchange(value = "topic_exchange", type = "topic"),
            key = "info.#.email.#"))
    public void topicConsumerEmail(String message) {
        System.out.println("接收到Email订阅需求处理消息： " + message);
    }

    //路由模式信息接收、处理error级别的日志信息
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("routing_queue_error"), exchange =
    @Exchange(value = "routing_exchange", type = "direct"),
            key = "error_routing_key"))
    public void routingConsumerError(String message) {
        System.out.println("接收到error级别日志消息： " + message);
    }
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("routing_queue_all"), exchange =
    @Exchange(value = "routing_exchange", type = "direct"),
            key = {"error_routing_key", "info_routing_key", "warning_routing_key"}))
    public void routingConsumerAll(String message) {
        System.out.println("接收到info、error、warning等级别日志消息： " + message);
    }
}

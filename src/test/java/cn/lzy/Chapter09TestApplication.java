package cn.lzy;
import cn.lzy.domain8.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/21 16:36
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter09TestApplication {
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void amqpAdmin(){
        amqpAdmin.declareExchange(new FanoutExchange("fanout_exchange"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_qq"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_wx"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));
        amqpAdmin.declareBinding(new Binding("fanout_queue_qq", Binding.DestinationType.QUEUE,
                "fanout_exchange","",null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_wx", Binding.DestinationType.QUEUE,
                        "fanout_exchange","",null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_email", Binding.DestinationType.QUEUE,
                        "fanout_exchange","",null));
    }
    @Test
    public void pusbPublisher1(){
        User user=new User();
        user.setId(1);
        user.setUsername("起舞");
        rabbitTemplate.convertAndSend("fanout_exchange_qq","",user);
        rabbitTemplate.convertAndSend("fanout_exchange_wx","",user);
        rabbitTemplate.convertAndSend("fanout_exchange_email","",user);
    }
    @Test
    public void pusbPublisher2(){
        User user=new User();
        user.setId(1);
        user.setUsername("人间");
        rabbitTemplate.convertAndSend("fanout_exchange_qq","",user);
    }
    @Test
    public void pusbPublisher3(){
        User user=new User();
        user.setId(1);
        user.setUsername("想念");
        rabbitTemplate.convertAndSend("fanout_exchange_wx","",user);
    }
    @Test
    public void pusbPublisher4(){
        User user=new User();
        user.setId(1);
        user.setUsername("如风");
        rabbitTemplate.convertAndSend("fanout_exchange_email","",user);
    }
    @Test
    public void routingPublisher(){
        rabbitTemplate.convertAndSend("routing_exchange",
                "error_routing_key","routing send error message");
    }
    @Test
    public void topicPublisher1(){
        rabbitTemplate.convertAndSend("topic_exchange","info.qq","topics send qq message");
    }
    @Test
    public void topicPublisher2(){
        rabbitTemplate.convertAndSend("topic_exchange","info.wx","topics send wx message");
    }
    @Test
    public void topicPublisher3(){
        rabbitTemplate.convertAndSend("topic_exchange","info.qq.wx","topics send qq and wx message");
    }
    @Test
    public void topicPublisher4(){
        rabbitTemplate.convertAndSend("topic_exchange","info.email","topics send email message");
    }
    @Test
    public void topicPublisher5(){
        rabbitTemplate.convertAndSend("topic_exchange","info.qq.wx.email","topics send qq and wx and email message");
    }
}

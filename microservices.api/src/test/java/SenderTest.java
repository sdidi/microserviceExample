
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class SenderTest  {
    String message = "Hello, test";
     
   
   @Test
   public void systemConnects() throws IOException, TimeoutException{
      ConnectionFactory factory = new ConnectionFactory();
       factory.setHost("localhost");
       factory.setPort(5672);
       factory.setUsername("guest");
       factory.setPassword("guest");
       factory.setVirtualHost("/");
       Connection connection = factory.newConnection();  
       Channel channel = connection.createChannel();
       assertThat(connection.getPort(),is(5672));
   }

                
}

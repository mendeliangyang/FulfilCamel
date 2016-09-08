
import java.util.Scanner;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.ProducerTemplate;

/**
 * Created by Administrator on 9/6/2016.
 */
public class main {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        //context.addRoutes(rb);
        //Camel有一套算法来选择调用bean里的什么方法(比如说message的header里是否通过CamelBeanMethodName设置了方法名称,
        //bean是否只有一个方法,某一个方法是否加了@Handler注解等等),这里的bean只有一个方法,Camel会调用这个方法.
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:bar").bean(new TranslateData()).to("http://218.93.33.59:84/zscx/Default.aspx");
            }
        });
        context.start();

        ProducerTemplate producerTemplate = context.createProducerTemplate();
        Object object = producerTemplate.requestBody("direct:bar", "ffffffff",String.class);
        System.out.println(object.toString());

//        MockEndpoint mockEndpoint = context.getEndpoint("mock:result", MockEndpoint.class);
//        mockEndpoint.assertIsSatisfied();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串，完成测试并退出。");
        context.stop();
        System.out.println("输入字符串：" + sc.next());
    }

}

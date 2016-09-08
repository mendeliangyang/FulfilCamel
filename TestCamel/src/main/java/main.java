
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
        //Camel��һ���㷨��ѡ�����bean���ʲô����(����˵message��header���Ƿ�ͨ��CamelBeanMethodName�����˷�������,
        //bean�Ƿ�ֻ��һ������,ĳһ�������Ƿ����@Handlerע��ȵ�),�����beanֻ��һ������,Camel������������.
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
        System.out.println("����һ���ַ�������ɲ��Բ��˳���");
        context.stop();
        System.out.println("�����ַ�����" + sc.next());
    }

}

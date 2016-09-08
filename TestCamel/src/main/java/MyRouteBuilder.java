
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    }

    RouteDefinition getRouteDefinition(String uri) {
       return from(uri + "?splitEntries=false&consumer.initialDelay=0").
                marshal().rss().
                to("mock:result").routeId("routeId");
    }
}

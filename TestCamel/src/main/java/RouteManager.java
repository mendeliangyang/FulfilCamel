
import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class RouteManager implements CamelContextAware {

    protected static CamelContext camelContext;

    public void setCamelContext(CamelContext cc) {
        RouteManager.camelContext = cc;  
    }

    public CamelContext getCamelContext() {
        return camelContext;  
    }

}

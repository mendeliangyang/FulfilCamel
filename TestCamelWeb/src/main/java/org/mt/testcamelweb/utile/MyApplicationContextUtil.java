/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mt.testcamelweb.utile;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Administrator
 */
public class MyApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    //声明一个静态变量保存
    @Override
    public void setApplicationContext(ApplicationContext contex) throws BeansException {
        MyApplicationContextUtil.context = contex;

    }

    public static ApplicationContext getContext() {

        return context;

    }

    public final static Object getBean(String beanName) {

        return context.getBean(beanName);

    }

    public final static <T> T getBean(String beanName, Class<T> requiredType) {

        return (T) context.getBean(beanName, requiredType);

    }

}

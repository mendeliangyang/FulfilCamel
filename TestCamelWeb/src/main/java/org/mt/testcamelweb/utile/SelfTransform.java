/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mt.testcamelweb.utile;

/**
 *
 * @author Administrator
 */
public class SelfTransform {

    public String toSelf(String param) throws Exception {
        String[] ps = param.split("|");
        if (ps.length < 2) {
            throw new Exception("mytransform tojson exception." + param);
        }
        return String.format("{\"UserId\":\"%s\",\"UserPwd\":\"%s\"}", ps[0], ps[1]);
    }
}

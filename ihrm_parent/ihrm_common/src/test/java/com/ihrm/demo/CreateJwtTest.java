package com.ihrm.demo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * 生成JwtToken
 */
public class CreateJwtTest {

    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder().setId("950218").setSubject("我爱编程")       //id,  内容
                .setIssuedAt(new Date())                            //时间
                .signWith(SignatureAlgorithm.HS256, "ihrm")     //签名方式
                .claim("companyId", "123456789")           //自定义claim
                .claim("companyName", "南昌市不动产登记中心");
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

}

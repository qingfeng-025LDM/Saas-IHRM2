package com.ihrm.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

@ConfigurationProperties("jwt.config")
public class JwtUtil {

    //签名私钥
    private String privateKey;

    //过期时间：毫秒
    private Long ttl;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    /**
     * 生成token
     * @param id
     * @param username
     * @param map
     * @return
     */
    public String createJwt(String id, String username, Map<String, Object> map){
        Long nowTime = System.currentTimeMillis();
        long expireTime = nowTime + ttl;
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(username)   //ID， 签名内容
                .setIssuedAt(new Date())                                        //token生成时间
                .setClaims(map)                                                 //自定义claims
                .signWith(SignatureAlgorithm.HS256, privateKey);                //签名方式，签名私钥
        jwtBuilder.setExpiration(new Date(expireTime));     //设置过期时间
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 解析token，返回claims对象
     * @param token
     * @return
     */
    public Claims parseJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token).getBody();
        return claims;
    }
}

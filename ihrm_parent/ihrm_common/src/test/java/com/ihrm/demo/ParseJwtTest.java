package com.ihrm.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.assertj.core.util.DateUtil;

/**
 * 解析JwtToken
 */
public class ParseJwtTest {

    public static void main(String[] args) {
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5NTAyMTgiLCJzdWIiOiLmiJHniLHnvJbnqIsiLCJpYXQiOjE2MDg5ODY1OTl9.wuOJmv1LwCFfBIKTOcwa45byhNKl22fkl6O-zwX6lno";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5NTAyMTgiLCJzdWIiOiLmiJHniLHnvJbnqIsiLCJpYXQiOjE2MDg5ODc3NjIsImNvbXBhbnlJZCI6IjEyMzQ1Njc4OSIsImNvbXBhbnlOYW1lIjoi5Y2X5piM5biC5LiN5Yqo5Lqn55m76K6w5Lit5b-DIn0.0dclC-_3XUMO1sqBWzfXxZ27mrO2w0mpsCxD_jSo038";
        Claims claims = Jwts.parser().setSigningKey("ihrm").parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(DateUtil.formatAsDatetime(claims.getIssuedAt()));
        System.out.println(claims.get("companyId"));
        System.out.println(claims.get("companyName"));
    }

}

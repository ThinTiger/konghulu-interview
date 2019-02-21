package com.konghulu.interview.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: za-lining
 * @date: 2019/2/21
 **/
@Slf4j
public class JWTTests extends BaseApplicationTest {

    @Test
    public void decode(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJsaW5pbmd0ZXN0MDAxIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.zKKsnA8LxQxYXWccJ9zis5BrHspNzTm9rDbdF1NyT7c";
        DecodedJWT jwt = JWT.decode(token);
    }
}

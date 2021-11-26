package org.tdd.logIn.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;



public class JwtUtil {
    final private static String  secret ="hojsan";


    public static String generateToken(String userName){
        String token = "";
        try{

            Algorithm algorithm = Algorithm.HMAC256(secret);

            token = JWT.create().withIssuer("auth0").withClaim("userName",userName).sign(algorithm);
        }catch(JWTCreationException e){
            e.printStackTrace();
        }
        return token;
    }



    public static boolean validateToken(String userName, String token){
        DecodedJWT jwt;
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withClaim("userName",userName)
                    .withIssuer("auth0").build();
            jwt = jwtVerifier.verify(token);
            if (jwt == null )return false;
            Claim claim = jwt.getClaim("userName");
            if (claim == null )return false;
            return true ;
        }catch (JWTVerificationException e){
            return false;
        }

    }


}




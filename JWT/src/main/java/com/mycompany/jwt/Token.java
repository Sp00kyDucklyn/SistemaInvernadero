/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 *
 * @author Marcos T.
 */
public class Token {

    private String crearToken(String usr) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create().withIssuer("auth0").withClaim("usr",usr).sign(algorithm);
        } catch (JWTCreationException e) {}
        return token;
    }
    
    private void verificarToken(String token){
        try {
          Algorithm algorithm = Algorithm.HMAC256("secret");
          JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
        } catch (JWTCreationException e) {
            //Firma Invalida jeje
        }
    }
}

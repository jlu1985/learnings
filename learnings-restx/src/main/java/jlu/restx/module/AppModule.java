/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlu.restx.module;

import restx.factory.Module;
import restx.factory.Provides;
import restx.security.SignatureKey;

/**
 *
 * @author jialu
 */
@Module
public class AppModule {
       
    @Provides
    public SignatureKey signatureKey(){
        return new SignatureKey("hi".getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}

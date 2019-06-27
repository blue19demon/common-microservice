package com.server.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.config.WebServiceConfig;
import com.server.core.ApplicationStartup;

@Import({WebServiceConfig.class,ApplicationStartup.class})
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface EnableRPCCxfRegister {

}

package com.client.core;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

public class MapperScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private ResourceLoader resourceLoader;
    /**
     * {@inheritDoc}
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
        if (resourceLoader != null) {
            scanner.setResourceLoader(resourceLoader);
        }
        Resource resource=resourceLoader.getResource("classpath:application.properties");
        Properties pro=new Properties();
        try {
        	pro.load(resource.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
        scanner.registerFilters();
        scanner.setUrl(pro.getProperty("cx.server.url"));
        scanner.doScan(pro.getProperty("cx.client.scan.pacakege").split(","));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

}
package org.mskcc.cbio.portal.swagger;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApiServiceSwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("org.mskcc.cbio.portal.web.api"))
            //.paths(PathSelectors.any())
            .build()
            .pathMapping("/api")
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "cBioPortal web API", 
            "A web service for supplying JSON formatted data to cBioPortal clients.", 
            "1.0 (beta)",
            "www.cbioportal.org",
            "cbioportal@googlegroups.com", 
            "License", 
            "https://github.com/cBioPortal/cbioportal/blob/master/LICENSE");
        return apiInfo;
    }
}

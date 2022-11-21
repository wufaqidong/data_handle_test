package cn.com.taiji.lawenforcement.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Swagger配置</p>
 *
 * @Author
 * @Date 2020/9/14 16:24
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swaggerEnable:false}")
    private boolean emableSwagger;

    @Bean
    public Docket createRestApi() {
        //添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder userPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("access-token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRhIjp7ImRlcHROYW1lIjoi6KW_5a6J5biC5Y2r55Sf55uR552j5omAIiwib2ZmaWNlTmFtZSI6Iuilv-WuieW4guWNq-eUn-WBpeW6t-WnlOWRmOS8miIsImNvbXBhbnlJZCI6IjYxMDEwMDAwMDAwMDAiLCJyb2xlIjoiUEVSU09OIiwib2ZmaWNlSWQiOiI2MTAxMDA3OSIsImNvbXBhbnlOYW1lIjoi6YOo6ZeoIiwiZGVwdElkIjoiNjEwMTAwMjQiLCJmdWxsTmFtZSI6Iuilv-WuieW4guWNq-eUn-ebkeedo-aJgOaJp-azleS6uuWRmCIsInVzZXJJZCI6IlVKNTk0ODcyNTU1Y2I2NDI4M2EwOGFmM2VmZWVjNTNhIiwidXNlcm5hbWUiOiJ4YVpmcnkifSwiaXNzIjoid3d3LnRhaWppLmNvbS5jbiIsInN1YiI6IlVKNTk0ODcyNTU1Y2I2NDI4M2EwOGFmM2VmZWVjNTNhIiwiaWF0IjoxNjIxNTA4MzMxLCJleHAiOjE2MjIxMDgzMzF9.Osut-zNXsyJDLnp9oKAn9t4L5ewrNBuR6519NuOjsbA").build();
        userPar.name("userInfo").description("用户信息").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("{\"userId\":\"UJe69ec63256924cd5a0a9dfb2238111\",\"deptId\":\"DJfb6ae1bac37744f7844de347b75599\",\"orgId\":\"DJfb6ae1bac37744f7844de347b75599\",\"districtCode\":\"610000\"}").build();
        pars.add(tokenPar.build());
//        pars.add(userPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(emableSwagger)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com.taiji.lawenforcement"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful APIs")
                .description("文档")
                .version("1.0")
                .build();
    }
}

package demo05_minio_wenjianfenbu;

import cn.com.taiji.lawenforcement.wlzt.entity.MinioProp;
import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: view
 * @description: minio核心配置类
 * @author: xiebinbin
 * @create: 2022-08-27 22:47
 **/
@Configuration
@EnableConfigurationProperties(MinioProp.class)
public class MinioConfig {
    @Autowired
    private MinioProp minioProp;

    /**
     * 获取 MinioClient
     *
     * @return
     * @throws InvalidPortException
     * @throws InvalidEndpointException
     */
    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(minioProp.getEndpoint(), minioProp.getAccesskey(), minioProp.getSecretKey());
    }
}

package demo05_minio_wenjianfenbu;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: view
 * @description: minio实体
 * @author: xiebinbin
 * @create: 2022-08-27 22:45
 **/

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProp {
    /**
     * 连接url
     */
    private String endpoint;
    /**
     * 用户名
     */
    private String accesskey;
    /**
     * 密码
     */
    private String secretKey;

}

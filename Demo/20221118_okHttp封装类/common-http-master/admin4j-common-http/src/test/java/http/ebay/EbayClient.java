package http.ebay;

import io.github.admin4j.http.ApiJsonClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @since 2022/11/8 17:30
 */
public class EbayClient extends ApiJsonClient {

    /**
     * 店铺配置
     *
     * @param storeId
     */
    public EbayClient(Long storeId) {

        //TODO 获取店铺配置
        Map<String, String> config = new HashMap<>();

        basePath = "https://api.ebay.com";
        defaultHeaderMap.put("Authorization", "Bearer " + config.get("accessToken"));
        defaultHeaderMap.put("X-EBAY-C-MARKETPLACE-ID", config.get("marketplaceId"));
    }
}

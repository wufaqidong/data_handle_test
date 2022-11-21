package cn.com.taiji.lawenforcement.wlzt.util;

import cn.com.taiji.lawenforcement.wlzt.common.HkwsUrl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestTemplateUtils {

    @Autowired
    private RestTemplate restTemplate;

    /* * post exchange带token访问方式
     *
     * @param url       请求路径
     * @param paramsMap 请求参数体
     * @param token     请求token
     * @return
     */
    public JSONObject exchange(String url, Map<String, Object> requestBody, String token, HttpMethod type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        String response = restTemplate.exchange(url, type, requestEntity, String.class).getBody();
         return JSONObject.parseObject(response);
    }

    /* * post exchange不带token访问方式
     *
     * @param url       请求路径
     * @param paramsMap 请求参数体
     * @param token     请求token
     * @return
     */
    public JSONObject exchangeNoToken(String url, Map<String, Object> requestBody, HttpMethod type) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        String response = restTemplate.exchange(url, type, requestEntity, String.class).getBody();
        return JSONObject.parseObject(response);
    }

    /* * post exchange不带token访问方式
     *
     * @param url       请求路径
     * @param paramsMap 请求参数体
     * @param token     请求token
     * @return
     */
    public JSONObject exchangeNoTokenHead(String url, Map<String, Object> requestBody, HttpMethod type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        String response = restTemplate.exchange(url, type, requestEntity, String.class).getBody();
        return JSONObject.parseObject(response);
    }


    /* * post postForEntity带token的访问方式
     *
     * @param url       请求路径
     * @param paramsMap 请求参数体
     * @param token     请求token
     * @return
     */
    public JSONObject postForEntity(String url, MultiValueMap<String, Object> requestBody, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        String response = restTemplate.postForEntity(url, requestEntity, String.class).getBody();
        return JSONObject.parseObject(response);
    }

    /**
     * get 带token的访问方式
     *
     * @return
     */
    public JSONObject exchangeGet(String token, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return JSONObject.parseObject(result.getBody());

    }


    /**
     * get 带token的访问方式请求路径后面加参数
     *
     * @return
     */
    public JSONObject get(String token, String deviceSerial) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> result = restTemplate.exchange(HkwsUrl.GET_CHANNEL_LIST + "?deviceSerial=" + deviceSerial, HttpMethod.GET, httpEntity, String.class);
        return JSONObject.parseObject(result.getBody());

    }

    /**
     * get 带token的访问方式请求路径后面加参数
     *
     * @return
     */
    public JSONObject getMethod(String token, Map<String, Object> paramMap, String url) {
        url = url + "?";
        StringBuilder urlBuilder = new StringBuilder(url);
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        url = urlBuilder.toString();
        url = url.substring(0, url.length() - 1);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return JSONObject.parseObject(result.getBody());
    }

}
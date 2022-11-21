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
public class RestTemplateTest {

  private JSONObject getJsonObjectDH(String token, int pageNum) {
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("pageSize", 200);
    requestBody.put("pageNum", pageNum);
    JSONObject jsonObject =
        restTemplateUtils.exchange(DHUrl.GET_DEV_INFO, requestBody, token, HttpMethod.POST);
    return jsonObject;
  }

  private JSONObject getJsonObjectFromJH(String key, String callerId, int pageIndex) {
    String requestUrl = getURL(JHUrl.GET_STORE_INFO, key, callerId);
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("lastModifyTime", "2022-09-01 00:00:00");
    requestBody.put("maxCount", 1000);
    requestBody.put("pageIndex", pageIndex);
    requestBody.put("pageSize", 10);
    JSONObject jsonObject =
        restTemplateUtils.exchangeNoToken(requestUrl, requestBody, HttpMethod.POST);
    return jsonObject;
  }

  public void alarmPush(String alarmId) {
    HashMap<String, Object> queryParams = new HashMap<>();
    queryParams.put("breakProof", "breakProof");
    String url = "http://www.baidu.com";
    if (StringUtils.isEmpty(breakProof)) {
      log.info("------上传图片证据返回值为空------");
    } else {
      JSONObject jsonObject =
          restTemplateUtils.exchangeNoTokenHead(url, queryParams, HttpMethod.POST);
      if ("提交成功".equals(jsonObject.getString("retMsg"))) {
        log.info("------" + zfAlarm.getAlarmId() + ":提交成功");
      }
    }
  }

  public JSONObject consumerMessages(String token, String consumerId) {
    MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<String, Object>();
    requestBody.add("autoCommit", false);
    requestBody.add("consumerId", consumerId);
    JSONObject apiResult = null;
    try {
      apiResult = restTemplateUtil.postForEntity(HkwsUrl.CONSUMER_MESSAGE, requestBody, token);
      log.info("apiResult:{}", apiResult);
      if (apiResult != null
          && apiResult.get("code") != null
          && 514002 == apiResult.getIntValue("code")) {
        log.error("pullMessages failed,apiResult:{}", apiResult);
        throw new InvalidConsumerException("无效的customerId");
      }
      if (apiResult == null
          || apiResult.get("code") == null
          || !apiResult.getBooleanValue("success")) {
        log.error("submitOffsets failed,apiResult:{}", apiResult);
        throw new ConsumeException("消费消息失败");
      }
    } catch (ConsumeException e) {
      e.printStackTrace();
    } catch (InvalidConsumerException e) {
      e.printStackTrace();
    }
    return apiResult;
  }

  private String findUniScId(String id, String token) {
    String url = DHUrl.GET_UNISCID_URL + "/" + id;
    JSONObject jsonObject = restTemplateUtils.exchangeGet(token, url);
    if (jsonObject == null) {
      return "未获取到值";
    }
    JSONObject data = jsonObject.getJSONObject("data");
    if (data == null) {
      return "未获取到值";
    }
    JSONObject extField = data.getJSONObject("extField");
    if (extField == null) {
      return "未获取到值";
    }
  }

  public JSONObject getChannelListByDecSn(String token, String deviceSerial) {
    MultiValueMap<String, Object> paramsMap = new LinkedMultiValueMap<>();
    paramsMap.add("deviceSerial", deviceSerial);
    JSONObject result = restTemplateUtil.get(token, deviceSerial);
    return result;
  }

  public void getCustomerTraffic() {
    List<Token> tokenList = tokenService.select();
    tokenList.forEach(
        tokenEntity -> {
          LocalDate currentDate = TimeUtils.paseFormatLocalDate(LocalDateTime.now(), "yyyy-MM-dd");
          Map<String, Object> paramMap = new HashMap<>();
          paramMap.put("dateTime", currentDate.toString());
          paramMap.put("pageNo", 1);
          paramMap.put("pageSize", 999);
          JSONObject requestResult =
              restTemplateUtils.getMethod(
                  tokenEntity.getToken(), paramMap, HkwsUrl.CUSTOMER_TRAFFIC);
          int num = requestResult.getJSONObject("data").getIntValue("total");
          if (num != 0) {
            CustomerTraffic customerTraffic =
                new CustomerTraffic()
                    .setClientId(tokenEntity.getClientId())
                    .setNum(num)
                    .setData(currentDate);
            customerTrafficDao.insert(customerTraffic);
          }
        });
  }
}

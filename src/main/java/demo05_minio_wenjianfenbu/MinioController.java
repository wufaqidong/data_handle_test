package demo05_minio_wenjianfenbu;

import cn.com.taiji.lawenforcement.wlzt.util.MinioUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: view
 * @description:
 * @author: xiebinbin
 * @create: 2022-08-27 22:51
 **/
@Controller
public class MinioController {
    @Autowired
    private MinioUtils minioUtils;


    /**
     * 上传
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request) {
        JSONObject res = null;
        try {
            res = minioUtils.uploadFile(file, "product");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("code", 0);
            res.put("msg", "上传失败");
        }
        return res.toJSONString();
    }
}

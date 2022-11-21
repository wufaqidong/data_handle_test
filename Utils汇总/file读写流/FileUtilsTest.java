package cn.com.taiji.lawenforcement.util;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileUtilsTest {

    File temp = File.createTempFile(System.currentTimeMillis()+new Random(100).nextInt()+"", ".pdf");
    // 将文件内容读取成二进制
    String aa = Base64.createBase64().encode(FileUtils.readFileTobytes(temp));


    Base64.createBase64().encode(FileUtils.readFileTobytes("D:\\code\\33333.pdf"));


    // 将二进制数据写入一个文件
    String fileBase64 = vo.getFileBase64();// base64内容
    byte[] fileData = Base64.createBase64().decode(fileBase64);
    filePath = filePath + File.separator + group;
    new File(filePath).mkdirs();
    filePath = filePath + fileName;
    FileUtils.write(fileData,filePath);


    // base64转inputStream
    InputStream input = FileUtils.baseToInputStream(pdfBase64.getBytes());
    PdfReader reader = new PdfReader(input);
    File temp = File.createTempFile(System.currentTimeMillis()+new Random(100).nextInt()+"", ".pdf");
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(temp));
    stamper.close();
    reader.close();

}

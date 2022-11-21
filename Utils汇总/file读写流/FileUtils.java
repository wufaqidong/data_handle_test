package cn.com.taiji.lawenforcement.util;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileUtils {

    /**
     * 将文件内容读取成二进制
     * @author
     * @since
     * @param filePath    文件的绝对路径
     * @return
     */
    public static byte[] readFileTobytes(File filePath)
    {
        InputStream in = null;

        try
        {
            in = new FileInputStream(filePath);
            return IOUtils.toByteArray(in);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != in)
                {
                    in.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return null;
    }
	
	/**
     * 将文件内容读取成二进制
     * @author       liandi
     * @since        esign, 2018年1月9日
     * @param filePath    文件的绝对路径
     * @return
     */
    public static byte[] readFileTobytes(String filePath)
    {
        InputStream in = null;
        
        try
        {
            in = new FileInputStream(filePath);
            return IOUtils.toByteArray(in);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != in)
                {
                    in.close();
                }
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
        }
        
        return null;
    }
    
    /**
     * 将二进制数据写入一个文件
     * @author       liandi
     * @since        esign, 2018年1月9日
     * @param data
     * @param filePath
     */
    public static void write(byte[] data, String filePath)
    {
        OutputStream out = null;
        try
        {
            out = new FileOutputStream(filePath);
            IOUtils.write(data, out);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != out)
                {
                    out.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * base64转inputStream
     * @param base64byte
     * @return
     */
    public static InputStream baseToInputStream(final byte[] base64byte){
        ByteArrayInputStream stream = null;
        try {
            byte[] bytes1 = org.apache.commons.codec.binary.Base64.decodeBase64(base64byte);
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return stream;
    }

}

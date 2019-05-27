package util;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.StringUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpURLConnectionTest {
    public static void main(String[] args) {
        getAreaLongAndDimen("河北省廊坊市广阳区张衡道52号");
    }
    public static Map getAreaLongAndDimen(String addr){
        try {
            addr = new String(addr.getBytes("UTF-8"),"GBK");
        }
        //因为高德地图用的是linux系统，所以其使用的是gbk的编码，所以在这里你用的是utf-8的话，就得转换成gbk的编码格式。
        catch (Exception e1)
        {
            e1.printStackTrace();
        }

    String str = "http://restapi.amap.com/v3/geocode/geo?address="+addr+"&output=JSON&key=83a94b317b6498e0d21c716011bca8f5";
    HashMap param = new HashMap();
    param.put("info", "erro");
    InputStream inputStream = null;
try {
    URL url = new URL(str);
    HttpURLConnection urlConnection =(HttpURLConnection)url.openConnection();
    urlConnection.setRequestMethod("GET");
    urlConnection.setConnectTimeout(5*1000);//超时时间
     urlConnection.setRequestProperty("contentType", "utf-8");//字符集
     urlConnection.connect();
     inputStream = urlConnection.getInputStream();
     JsonNode jsonNode = new ObjectMapper().readTree(inputStream);//jackson		   
     if(jsonNode.findValue("geocodes").size()>0)
     {
         String[] degree = jsonNode.findValue("geocodes").findValue("location").textValue().split(",");
         param.put("longitude", degree[0]);
         param.put("dimension", degree[1]);
         param.put("info", "success");
     }		}
    catch (Exception e) {
        param.put("info", "erro");
    }
    finally
    {
        try {
            if(null != inputStream ){
                inputStream.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
        return param;
    }
}

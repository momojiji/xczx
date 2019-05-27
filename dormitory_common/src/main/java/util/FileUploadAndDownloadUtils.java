package util;

import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @ClassName FileUploadAndDownloadUtils
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 16:28
 * @Version 1.0
 */
public class FileUploadAndDownloadUtils {

    private static String imageServerAddress = "http://60.10.60.195:9000";
    //private static String imageServerAddress = "http://39.106.108.39";



    public static  String upload(MultipartFile file) throws Exception{
        String fileId="";

            //加载配置文件（trackerserver地址）
            ClientGlobal.initByProperties("config/fastdfs-client.properties");

            //tracker client，请求tracker得到storage地址
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker server
            TrackerServer trackerServer = trackerClient.getConnection();
            ProtoCommon.activeTest(trackerServer.getSocket());
            //得到strorage的地址
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            //strage client用来上传文件
            //构造参数 TrackerServer trackerServer, StorageServer storageServer
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);

            StorageClient storageClient = new StorageClient(trackerServer,storageServer);
            //得到新文件字节
            byte[] bytes = file.getBytes();
            //得到文件扩展名
            String originalFilename = file.getOriginalFilename();//原始名称
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            if(StringUtils.isEmpty(imageServerAddress)){
                imageServerAddress="http://39.106.108.39";
            }
            fileId= imageServerAddress+ File.separator+storageClient1.upload_file1(bytes, ext, null);


        return  fileId;
    }

    public static  String uploadFile(File file) throws Exception {
        String fileId="";
        try {
            //加载配置文件（trackerserver地址）
            ClientGlobal.initByProperties("config/fastdfs-client.properties");

            //tracker client，请求tracker得到storage地址
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker server
            TrackerServer trackerServer = trackerClient.getConnection();
            ProtoCommon.activeTest(trackerServer.getSocket());
            //得到strorage的地址
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            //strage client用来上传文件
            //构造参数 TrackerServer trackerServer, StorageServer storageServer
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);
            //得到新文件字节
            byte[] bytes = getBytes(file) ;
            //得到文件扩展名
            String originalFilename = file.getName() ;//原始名称
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            if (imageServerAddress==null){
                imageServerAddress="http://39.106.108.39";
            }
            String  uploadFile=storageClient1.upload_file1(bytes, ext, null);
            fileId= imageServerAddress+ File.separator+uploadFile;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return  fileId;
    }

    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getBytes(File filePath){
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 根据byte数组，生成文件
     */
    public static void getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

package util;

public class QRTest {

    public static void main(String[] args) {
        /*生成二维码
        String content= "http://www.test.com/page/weizhi.html?devicesName=消防栓_WRbb&devicesNumber=2018092512094659f6aee7&hydrantId=d88219b0-c07e-11e8-87a3-2302a122c883&equipment=触发器01,撞到触发器;触发器02,开盖触发器;触发器03,漏水触发器;";
        String imgPath="";
        String destPath ="upload";
        System.out.println("imgPath=="+imgPath);
        System.out.println("destPath=="+destPath);
        try {
            System.out.println( QRCodeUtils.encode(content,imgPath,destPath, true));;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        */
        String [] a = {"a/b/","a/c/"}  ;// 能得出一个新的 String [] b = {"b","c"} 吗？
        String[] b=new String[a.length];
        for (int i=0;i<a.length;i++){
            String tem=a[i].replace("a","").replace("/","");
            System.out.println(tem);
            b[i]=tem;
        }
    }
}

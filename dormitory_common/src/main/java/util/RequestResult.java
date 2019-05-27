package util;

/**
 * @ClassName RequestResult
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/20 0:01
 * @Version 1.0
 */
public class RequestResult {
    /** 状态码 */
    private int code;

    /** 返回body */
    private  String body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

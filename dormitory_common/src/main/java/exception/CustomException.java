package exception;

/**
 * @Auther: wyan
 * @Date: 2019/1/28 15:19
 * @Description:
 */
public class CustomException extends  Exception {

    private Integer errorCode;
    private String errorMsg;

    public CustomException(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return this.getErrorMsg();
    }
}

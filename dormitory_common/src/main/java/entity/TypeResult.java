package entity;

/**
 * @ClassName TypeResult
 * @Description 返回类型信息
 * @Author Administrator
 * @Date 2019/2/22 10:21
 * @Version 1.0
 */
public class TypeResult {

    private String key;
    private String value;

    public TypeResult() {
    }
    public TypeResult(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

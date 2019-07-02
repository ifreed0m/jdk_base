package lamda;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/6/23 18:16
 */
public class Main {
    public static void main(String[] args) {
        Param<BaseParam> param = BaseParam::new;
        BaseParam a = Page.getObject(BaseParam::new, "searchValue", 9);
        BaseParam params = param.getBaseParam("searchValue", 0);
        System.out.println(a);
    }
}

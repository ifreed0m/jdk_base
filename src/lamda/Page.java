package lamda;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/6/23 18:11
 */
public class Page {

    public static <T> T getObject(Param<T> param, String searchValue, Integer currentPage) {
        return param.getBaseParam(searchValue, currentPage);
    }
}

package lamda;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/6/23 18:11
 */
@FunctionalInterface
public interface Param<T> {
    T getBaseParam(String searchValue, Integer currentPage);
}

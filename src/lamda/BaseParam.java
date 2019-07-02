package lamda;

/**
 * @author ifreed0m
 * @version 1.0
 * @date 2019/6/23 18:12
 */
public class BaseParam {
    private String searchValue;
    private Integer currentPage;

    public BaseParam(String searchValue, Integer currentPage) {
        this.searchValue = searchValue;
        this.currentPage = currentPage;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseParam{");
        sb.append("super=").append(super.toString());
        sb.append("searchValue='").append(searchValue).append('\'');
        sb.append(", currentPage=").append(currentPage);
        sb.append('}');
        return sb.toString();
    }
}

package com.init.common;

import com.init.common.constant.CommonConstant;
import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest {

    /**
     * 搜索关键词
     */
    private String searchText;

    /**
     * 当前页号
     */
    private long current = 1;

    /**
     * 页面大小（每页的数量）
     */
    private long pageSize = 10;

    /**
     * 总数
     */
    private long total;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;

}

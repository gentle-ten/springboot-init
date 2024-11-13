package com.init.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.init.common.exception.BusinessException;
import com.init.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ExcelUtils {

    /**
     * excel 转 csv 字符串文件
     *
     * @param multipartFile 文件流
     * @return csv 字符串
     */
    public static String excelToCsv(MultipartFile multipartFile) {
        List<Map<Integer, String>> list;
        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("读取文件失败：{}", e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        if (CollectionUtil.isEmpty(list)) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 转换数据为 csv
        StringBuilder stringBuilder = new StringBuilder();
        // 读取表头 （ObjectUtils.isNotEmpty 不会过滤 " " 字符串）
        LinkedHashMap<Integer, String> headerMap = (LinkedHashMap<Integer, String>) list.get(0);
        List<String> headerList = headerMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
        stringBuilder.append(StringUtils.join(headerList, ",")).append("\n");
        // 读取表数据
        for (int i = 1; i < list.size(); i++) {
            LinkedHashMap<Integer, String> dataMap = (LinkedHashMap<Integer, String>) list.get(i);
            List<String> dataList = dataMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            stringBuilder.append(StringUtils.join(dataList, ",")).append("\n");
        }
        return stringBuilder.toString();
    }


}

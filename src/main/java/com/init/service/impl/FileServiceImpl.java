package com.init.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.init.common.constant.CommonConstant;
import com.init.mapper.FileMapper;
import com.init.model.dto.file.FileQueryDTO;
import com.init.model.entity.File;
import com.init.model.vo.FileVO;
import com.init.service.FileService;
import com.init.utils.FileSizeUtil;
import com.init.utils.SqlUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Override
    public FileVO getFileVO(File file) {
        if (file == null) {
            return null;
        }
        FileVO fileVO = new FileVO();
        BeanUtils.copyProperties(file, fileVO);
        fileVO.setSize(FileSizeUtil.getFileSizeReadable(file.getSize()));
        return fileVO;
    }

    @Override
    public QueryWrapper<File> getQueryWrapper(FileQueryDTO fileQueryDTO) {
        QueryWrapper<File> queryWrapper = new QueryWrapper<>();
        if (fileQueryDTO == null) {
            return queryWrapper;
        }

        Long id = fileQueryDTO.getId();
        Integer size = fileQueryDTO.getSize();
        Integer type = fileQueryDTO.getType();
        Integer biz = fileQueryDTO.getBiz();
        Long userId = fileQueryDTO.getUserId();
        String searchText = fileQueryDTO.getSearchText();
        String sortField = fileQueryDTO.getSortField();
        String sortOrder = fileQueryDTO.getSortOrder();

        queryWrapper.and(ObjectUtils.isNotEmpty(searchText), search -> {
            search.or().like("name", searchText);
        });
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(size), "size", size);
        queryWrapper.eq(ObjectUtils.isNotEmpty(type), "type", type);
        queryWrapper.eq(ObjectUtils.isNotEmpty(biz), "biz", biz);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "user_id", userId);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public List<FileVO> getFileVOList(List<File> fileList) {
        if (CollectionUtil.isEmpty(fileList)) {
            return new ArrayList<>();
        }
        return fileList.stream().map(this::getFileVO).collect(Collectors.toList());
    }
}

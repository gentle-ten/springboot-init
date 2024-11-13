package com.init.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.init.model.dto.file.FileQueryDTO;
import com.init.model.entity.File;
import com.init.model.vo.FileVO;

import java.util.List;

/**
 * 文件信息
 */
public interface FileService extends IService<File> {


    /**
     * 获取脱敏文件信息
     *
     * @param file
     * @return
     */
    FileVO getFileVO(File file);

    /**
     * 构建分页查询参数
     *
     * @param fileQueryDTO
     * @return
     */
    QueryWrapper<File> getQueryWrapper(FileQueryDTO fileQueryDTO);


    /**
     * 获取脱敏文件列表
     *
     * @param fileList
     * @return
     */
    List<FileVO> getFileVOList(List<File> fileList);
}
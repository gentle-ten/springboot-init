package com.init.model.dto.file;

import com.baomidou.mybatisplus.annotation.TableField;
import com.init.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileQueryDTO extends PageRequest implements Serializable {


    /**
     * 主键 id
     */
    private Long id;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件大小
     */
    private Integer size;

    /**
     * 文件类型
     */
    private Integer type;

    /**
     * 归属业务
     */
    private Integer biz;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}

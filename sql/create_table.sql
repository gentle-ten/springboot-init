# 数据库初始化
-- 创建库
create database if not exists init;

-- 切换库
use init;

-- 用户表
create table if not exists user
(
    id            bigint auto_increment comment 'id' primary key comment '主键 id',
    user_account  varchar(256)                           not null comment '账号',
    user_password varchar(512)                           not null comment '密码',
    union_id      varchar(256)                           null comment '微信开放平台id',
    mp_open_id    varchar(256)                           null comment '公众号openId',
    user_name     varchar(256)                           null comment '用户昵称',
    user_avatar   varchar(1024)                          null comment '用户头像',
    user_profile  varchar(512)                           null comment '用户简介',
    user_role     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    create_time   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete     tinyint      default 0                 not null comment '是否删除',
    index idx_union_id (union_id)
) comment '用户' collate = utf8mb4_unicode_ci;

-- 文件存储表
create table if not exists file
(
    id                 bigint auto_increment comment 'id' primary key comment '主键 id',
    `name`             varchar(128)                       not null comment '文件名称',
    path               varchar(128)                       not null comment '文件路径',
    size               int                                not null comment '文件大小',
    type               tinyint                            not null comment '文件类型',
    belonging_business tinyint                            not null comment '归属业务',
    user_id            bigint                             not null comment '创建用户 id',
    create_time        datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time        datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete          tinyint  default 0                 not null comment '是否删除',
    index idx_name (`name`)
) comment '文件存储' collate = utf8mb4_unicode_ci;
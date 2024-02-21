use usercenter;

create table user
(
    id           bigint auto_increment comment 'id'
        primary key,
    username     varchar(256)                       null comment '用户名称',
    userAccount  varchar(256)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(512)                       not null comment '密码',
    profile      varchar(512)                       null comment '个人简介',
    phone        varchar(128)                       null comment '电话',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 not null comment '用户状态',
    userRole     tinyint  default 0                 not null comment '0普通用户，1管理员',
    creatTime    datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint  default 0                 null comment '是否删除',
    tags         varchar(1024)                      null comment '标签列表'
)
    comment '用户';

create table team
(
    id          bigint auto_increment comment 'id'
        primary key,
    name        varchar(256)                       null comment '队伍名称',
    description varchar(1024)                      null comment '描述',
    maxNum      int      default 1                 null comment '最大人数',
    expireTime  datetime default null comment '过期时间',
    userId      bigint                             null comment '用户id',
    status      int      default 0                 not null comment '0-公开,1-私有,2-加密',
    password    varchar(512)                       not null comment '密码',
    creatTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint  default 0                 null comment '是否删除',
)
    comment '队伍';

create table user_team
(
    id         bigint auto_increment comment 'id'
        primary key,

    userId     bigint                             null comment '用户id',
    teamId     bigint                             null comment '队伍id',
    joinTime   datetime                           null comment '创建时间',
    creatTime  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 null comment '是否删除'
)
    comment '用户队伍关系';


create table if not exists `sso_user`(
    `id` bigint(20) not null auto_increment,
    `username` varchar(20) default null,
    `password` varchar(200) default null comment 'MD5加密',
    `phone` varchar(20) default null,
    `email` varchar(50) default null,
    `created` datetime default null,
    `updated` datetime default null,
    primary key (id),
    unique key `phone`(phone),
    unique key `email`(email)
) engine=innodb default charset=utf8;
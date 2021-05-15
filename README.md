整个项目包括，商城的前端页面，前端的后台代码，以及管理系统的页面和后台代码
整个项目完成部分为商品部分，前台是各类查询，后台为商品查询，商品信息修改，商品状态修改，同时完成了卖家登录、登出、注册、信息修改

主要采用了商品信息表和卖家信息表，两张表
create table product_info(
product_id varchar(32) primary key comment '商品ID',
product_name varchar(64) not null comment '商品名称',
first_category varchar(64) not null comment '一级目录',
second_category varchar(64) not null comment '二级目录',
third_category varchar(64) not null comment '三级目录',
brand_name varchar(64) not null comment "品牌名称",
cost_price int(8) not null comment '原价',
discount_price int(8) not null comment '折扣价格',
sale_quantity int(16) not null default 0 comment '商品销量',
product_stock int(16) not null comment '库存',
product_description varchar(64) comment '描述',
product_title varchar(128) comment '标题',
product_icon varchar(512) comment '图片',
product_type int(8) not null comment '商品状态',
create_time timestamp not null default current_timestamp comment '创建时间',
update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间'	 
) comment '商品表';

create table cdf_seller(
user_id varchar(64) primary key comment '卖家ID',
username varchar(64) not null unique comment '用户名',
password varchar(16) not null comment '密码',
phone_number varchar(64) not null comment '电话号码',
email varchar(64) not null comment 'email',
create_time timestamp not null default current_timestamp comment '创建时间',
update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间'	 
) comment '卖家信息表'

这个项目最失败的一点可能就是商品信息表的设计，之前没有考虑的复杂，只是看前端需要什么字段就直接添加了字段，
后面想要分表，但是代价太大了，使用没有分，还望见谅！！！！
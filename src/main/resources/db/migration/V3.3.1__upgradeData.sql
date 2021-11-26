/*
 * LuckyFrame 自动化测试平台 SQL脚本初始化
 * Version   3.2.2
 * Author    lilei
 * Date      2020-09-09
 
 ************  WARNING  ************   
 此脚本属于应用自动升级数据库表结构以及数据脚本，无需手动执行，请慎重！！！！
*/
-- ----------------------------
-- 1、增加失败用例记录分析表
-- ----------------------------
create table if not exists task_fail_case_statistics
(
  id          int(8)         not null AUTO_INCREMENT  comment 'ID 主键',
  task_id               int(8)         not null                 comment '任务ID',
  project_id            int(8)         not null                 comment '项目ID',
  case_id               int(8)         not null                 comment '用例ID',
  task_case_id          int(8)         not null                 comment '用例执行ID',
  case_sign             varchar(20)    not null                 comment '用例标识',
  case_name             varchar(200)   not null                 comment '用例名称',
  fail_cause            varchar(200)   not null                 comment '失败原因 0bug 1数据 2需求变更 3环境 4脚本 5其它 6未处理',
  finish_time           datetime                                comment '用例结束时间',
  create_by             varchar(64)    default ''               comment '创建者',
  create_time 	        datetime                                comment '创建时间',
  update_by             varchar(64)    default ''               comment '更新者',
  update_time           datetime                                comment '更新时间',
  fail_remark  varchar(500) DEFAULT NULL COMMENT '失败说明',
  bug_link  varchar(500) DEFAULT NULL COMMENT '关联bug链接',
  is_deleted   bit(1)   NOT NULL DEFAULT b'0' COMMENT '是否删除',
  primary key (id),
  index (task_id),
  index (case_id)
) engine=innodb default charset=utf8 comment = '失败用例记录分析';
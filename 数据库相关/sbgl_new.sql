/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016-06-26 20:46:29                          */
/*==============================================================*/


alter table environment_attach
   drop constraint FK_ENVIRONM_HJ_REF1_ENVIRONM;

alter table environment_test_instrument
   drop constraint FK_ENVIRONM_HJ_REF3_ENVIRONM;

alter table environment_test_report
   drop constraint FK_ENVIRONM_HJ_REF2_ENVIRONM;

alter table pbs_attach
   drop constraint FK_PBS_ATTA_PBS_REF2_PBS_APPL;

alter table pbs_test_report
   drop constraint FK_PBS_TEST_PBS_REF1_PBS_APPL;

drop table environment_apply_info cascade constraints;

drop table environment_attach cascade constraints;

drop table environment_test_instrument cascade constraints;

drop table environment_test_report cascade constraints;

drop table pbs_apply_info cascade constraints;

drop table pbs_attach cascade constraints;

drop table pbs_test_report cascade constraints;

/*==============================================================*/
/* Table: environment_apply_info                                */
/*==============================================================*/
create table environment_apply_info 
(
   environment_apply_id VARCHAR(50)          not null,
   environment_apply_unit_id VARCHAR(20),
   environment_apply_user_id VARCHAR(8),
   environment_apply_tel VARCHAR(11),
   environment_apply_status CHAR(1 BYTE),
   constraint PK_ENVIRONMENT_APPLY_INFO primary key (environment_apply_id)
);

comment on column environment_apply_info.environment_apply_unit_id is
'申请单位编号';

comment on column environment_apply_info.environment_apply_user_id is
'申请人编号';

comment on column environment_apply_info.environment_apply_status is
'1.已提交 2.未提交';

/*==============================================================*/
/* Table: environment_attach                                    */
/*==============================================================*/
create table environment_attach 
(
   environment_attach_id VARCHAR(50)          not null,
   environment_apply_id VARCHAR(50),
   environment_attach_url VARCHAR(50),
   environment_attach_name VARCHAR(50),
   environment_attach_type CHAR(1 BYTE),
   environment_attach_date TIMESTAMP,
   constraint PK_ENVIRONMENT_ATTACH primary key (environment_attach_id)
);

comment on column environment_attach.environment_attach_type is
'1.申请书电子版 2.检测报告电子版';

/*==============================================================*/
/* Table: environment_test_instrument                           */
/*==============================================================*/
create table environment_test_instrument 
(
   eti_id               VARCHAR(50)          not null,
   environment_test_report_id VARCHAR(50),
   instrument_id        VARCHAR(50),
   constraint PK_ENVIRONMENT_TEST_INSTRUMENT primary key (eti_id)
);

/*==============================================================*/
/* Table: environment_test_report                               */
/*==============================================================*/
create table environment_test_report 
(
   environment_test_report_id VARCHAR(50)          not null,
   environment_apply_id VARCHAR(50),
   test_report_number   VARCHAR(50),
   test_user_name       VARCHAR(8),
   test_date            TIMESTAMP,
   test_unit_name       VARCHAR(20),
   test_status          CHAR(1 BYTE),
   constraint PK_ENVIRONMENT_TEST_REPORT primary key (environment_test_report_id)
);

/*==============================================================*/
/* Table: pbs_apply_info                                        */
/*==============================================================*/
create table pbs_apply_info 
(
   pbs_apply_id         VARCHAR(50)          not null,
   pbs_apply_unit_id    VARCHAR(50),
   pbs_apply_user_id    VARCHAR(50),
   pbs_apply_tel        VARCHAR(11),
   pbs_apply_date       TIMESTAMP,
   pbs_apply_status     CHAR(1 BYTE),
   constraint PK_PBS_APPLY_INFO primary key (pbs_apply_id)
);

comment on column pbs_apply_info.pbs_apply_id is
'屏蔽室申请编号UUID';

comment on column pbs_apply_info.pbs_apply_unit_id is
'申请单位编号';

comment on column pbs_apply_info.pbs_apply_user_id is
'申请人编号';

comment on column pbs_apply_info.pbs_apply_tel is
'联系方式';

comment on column pbs_apply_info.pbs_apply_status is
'1.未提交 2.已提交';

/*==============================================================*/
/* Table: pbs_attach                                            */
/*==============================================================*/
create table pbs_attach 
(
   pbs_attach_id        VARCHAR(50)          not null,
   pbs_apply_id         VARCHAR(50),
   pbs_attach_url       VARCHAR(50),
   pbs_attach_name      VARCHAR(50),
   pbs_attach_type      CHAR(1 BYTE),
   pbs_attach_date      TIMESTAMP,
   constraint PK_PBS_ATTACH primary key (pbs_attach_id)
);

comment on column pbs_attach.pbs_apply_id is
'屏蔽室申请编号UUID';

comment on column pbs_attach.pbs_attach_url is
'附件路径';

comment on column pbs_attach.pbs_attach_name is
'附件原名';

comment on column pbs_attach.pbs_attach_type is
'1,屏蔽室申请书   2. 屏蔽室监测证书';

comment on column pbs_attach.pbs_attach_date is
'上传日期';

/*==============================================================*/
/* Table: pbs_test_report                                       */
/*==============================================================*/
create table pbs_test_report 
(
   pbs_test_report_id   VARCHAR(50)          not null,
   pbs_apply_id         VARCHAR(50),
   test_report_number   VARCHAR(50),
   test_user_name       VARCHAR(8),
   test_date            TIMESTAMP,
   test_status          CHAR(1 BYTE),
   constraint PK_PBS_TEST_REPORT primary key (pbs_test_report_id)
);

comment on column pbs_test_report.pbs_test_report_id is
'主键';

comment on column pbs_test_report.pbs_apply_id is
'屏蔽室申请编号UUID';

comment on column pbs_test_report.test_report_number is
'监测报告的编号';

alter table environment_attach
   add constraint FK_ENVIRONM_HJ_REF1_ENVIRONM foreign key (environment_apply_id)
      references environment_apply_info (environment_apply_id);

alter table environment_test_instrument
   add constraint FK_ENVIRONM_HJ_REF3_ENVIRONM foreign key (environment_test_report_id)
      references environment_test_report (environment_test_report_id);

alter table environment_test_report
   add constraint FK_ENVIRONM_HJ_REF2_ENVIRONM foreign key (environment_apply_id)
      references environment_apply_info (environment_apply_id);

alter table pbs_attach
   add constraint FK_PBS_ATTA_PBS_REF2_PBS_APPL foreign key (pbs_apply_id)
      references pbs_apply_info (pbs_apply_id);

alter table pbs_test_report
   add constraint FK_PBS_TEST_PBS_REF1_PBS_APPL foreign key (pbs_apply_id)
      references pbs_apply_info (pbs_apply_id);


--删除环境检测相关表
DELETE FROM SBGL.en_pic;
delete from ENVIRONMENT_APPLY_AUDIT;
delete from  SBGL.environment_attach;
delete from ENVIRONMENT_TEST_INSTRUMENT;
delete from ENVIRONMENT_TEST_REPORT;
delete from ENVIRONMENT_APPLY_INFO;
--
delete from log_operate;
--删除设备检测
delete from nt_apply_device;
delete from nt_device_apply_audit;
delete from nt_device_test_report;
delete from nt_device_test_apply;
delete from t_device_base_info;

--useless table delete about PBS
delete from nt_pbs_apply_audit;
--
delete from nt_pbs_builder;
delete from nt_pbs_device;
--
delete from nt_pbs_test_rpt;
delete from nt_pbs_base_info;
delete from nt_pbs_test_apply;

delete from nt_report_instrument;
delete from nt_test_report_pic;
--删除屏蔽室信息
delete from pbs_attach;
delete from pbs_pic;
delete from pbs_test_report;
delete from pbs_apply_info;

--



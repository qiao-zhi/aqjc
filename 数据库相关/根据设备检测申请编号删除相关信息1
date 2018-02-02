select * from nt_apply_device where apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
select * from t_device_base_info where device_id in (select device_id from nt_apply_device where apply_id ='14687eb2-7641-40c2-8895-8cc7c0664f82');
select * from nt_device_test_apply where apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
select * from nt_device_apply_audit where apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
select * from nt_device_test_apply_attach where dev_apply_id = '14687eb2-7641-40c2-8895-8cc7c0664f82';
select * from nt_device_test_report where apply_id = '14687eb2-7641-40c2-8895-8cc7c0664f82';
select * from nt_test_report_pic where report_id='fff0f2f0-1493-4c31-8688-89748089f43f';

--根据apply_id 删除该申请的所有信息
--1、删除申请设备对应设备基本信息
delete from t_device_base_info where device_id in (select device_id from nt_apply_device where apply_id ='14687eb2-7641-40c2-8895-8cc7c0664f82');
--2、删除申请设备信息
delete from nt_apply_device where apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
--3、删除申请信息
delete from nt_device_test_apply where apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
--4 删除申请审批信息
delete from nt_device_apply_audit where apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
--5 删除申请表附件
delete from nt_device_test_apply_attach where dev_apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
--6 删除申请对应的检测报告的图片
delete from nt_test_report_pic where report_id='fff0f2f0-1493-4c31-8688-89748089f43f';
--7 删除申请对应的检测报告
delete from nt_device_test_report where apply_id='14687eb2-7641-40c2-8895-8cc7c0664f82';
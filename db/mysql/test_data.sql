INSERT INTO `sys_user` (`id`,`login_name`,`pwd`,`staff_no`,`acc_enabled`,`expire_date`,`ip_addr`,`mac_addr`,`comments`,`op_create`,`op_modify`,`gtm_create`,`gtm_modify`)
  VALUES (4,'test1','1234','test1',1,NULL,NULL,NULL,'test1','test','test','2017-07-12 00:00:00','2017-07-12 00:00:00');
INSERT INTO `sys_user` (`id`,`login_name`,`pwd`,`staff_no`,`acc_enabled`,`expire_date`,`ip_addr`,`mac_addr`,`comments`,`op_create`,`op_modify`,`gtm_create`,`gtm_modify`)
  VALUES (6,'aa','123','444',1,NULL,NULL,NULL,NULL,'test1','test1','2017-07-12 15:35:02','2017-07-12 15:35:02');
INSERT INTO `sys_user` (`id`,`login_name`,`pwd`,`staff_no`,`acc_enabled`,`expire_date`,`ip_addr`,`mac_addr`,`comments`,`op_create`,`op_modify`,`gtm_create`,`gtm_modify`)
  VALUES (8,'aa111','1234','123',1,'2017-01-01 00:00:00',NULL,NULL,NULL,'test1','test1','2017-07-12 16:03:33','2017-07-12 16:03:33');
INSERT INTO `sys_user` (`id`,`login_name`,`pwd`,`staff_no`,`acc_enabled`,`expire_date`,`ip_addr`,`mac_addr`,`comments`,`op_create`,`op_modify`,`gtm_create`,`gtm_modify`)
  VALUES (9,'asfasdf','asdfasdf','1231231fs',0,'2018-01-01 00:00:00','123123','234234','abcde','test1','test1','2017-07-12 16:05:16','2017-07-12 16:05:16');

INSERT INTO `sys_user_role` (`id`,`sys_user_id`,`sys_role`) VALUES (9,4,'ROLE_ADMIN');

INSERT INTO `bus_staff_info` (`id`,`staff_no`,`short_name`,`staff_name`,`staff_position`,`entry_date`,`leave_date`,`staff_type`,`card_no`,`bank_acc`,`ss_flag`,`card_front`,`card_oppo_side`,`tel_no`,`mobile_no`,`fax_no`,`email`,`staff_status`,`comments`) VALUES (7,'test1','test1','test1','position','2017-01-01','2017-01-01','CEO','10001','010101','1',NULL,NULL,'1231','456','789','111','aaa','aadfasf');

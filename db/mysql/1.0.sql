/*
用户信息表
 */
create TABLE sys_user(
  id INT NOT NULL AUTO_INCREMENT,
  login_name VARCHAR(20) UNIQUE NOT NULL ,
  pwd VARCHAR(100) NOT NULL ,
  staff_no VARCHAR(20) NOT NULL ,
  acc_enabled BOOL NOT NULL ,
  expire_date DATETIME,
  ip_addr VARCHAR(50),
  mac_addr VARCHAR(50),
  comments VARCHAR(200),
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL ,
  PRIMARY KEY (id)
);

/**
用户角色表
 */
create TABLE sys_user_role(
  id INT NOT NULL AUTO_INCREMENT,
  sys_user_id INT NOT NULL,
  sys_role VARCHAR(50) NOT NULL ,
  PRIMARY KEY (id)
);

/**
系统日志
 */
CREATE TABLE sys_log(
  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(10) NOT NULL ,
  log VARCHAR(1000),
  op_code VARCHAR(20) NOT NULL ,
  op_time DATETIME NOT NULL ,
  PRIMARY KEY (id)
);

/**
员工信息
 */
create TABLE  bus_staff_info(
  id INT NOT NULL AUTO_INCREMENT,
  staff_no VARCHAR(20) NOT NULL ,
  short_name VARCHAR(80),
  staff_name VARCHAR(80),
  staff_position VARCHAR(60),
  entry_date DATE ,
  leave_date DATE ,
  staff_type VARCHAR(5),
  card_no VARCHAR(50),
  bank_acc VARCHAR(50),
  ss_flag VARCHAR(10),
  card_front MEDIUMBLOB,
  card_oppo_side MEDIUMBLOB,
  tel_no VARCHAR(30),
  mobile_no VARCHAR(30),
  fax_no VARCHAR(30),
  email VARCHAR(30),
  staff_status VARCHAR(10),
  comments VARCHAR(100),
  PRIMARY KEY (id)
);

/**
客户
 */
create TABLE bus_customer_info(
  id INT NOT NULL AUTO_INCREMENT,
  customer_no VARCHAR(20) NOT NULL ,
  customer_level VARCHAR(10),
  customer_name VARCHAR(100),
  delivery_address VARCHAR(200),
  mobile_no VARCHAR(30),
  fax_no VARCHAR(30),
  link_man VARCHAR(30),
  link_mobile VARCHAR(30),
  link_address VARCHAR(200),
  receipt_address VARCHAR(200),
  tax_no VARCHAR(50),
  receipt_mobile VARCHAR(30),
  open_bank VARCHAR(100),
  account_no VARCHAR(50),
  PRIMARY KEY (id)
);

/**
合同
 */
create TABLE  bus_contract_info(
  id INT NOT NULL AUTO_INCREMENT,
  buyer varchar(100) NOT NULL  ,
  seller varchar(100) NOT NULL ,
  contract_date DATE,
  contract_no VARCHAR(20) NOT NULL ,
  customer_no VARCHAR(20) NOT NULL ,
  total DECIMAL,
  favour DECIMAL,
  standard VARCHAR(200),
  delivery_date DATE,
  delivery_place VARCHAR(200),
  delivery_address VARCHAR(200),
  pay_condition VARCHAR(200),
  contract_status VARCHAR(10),
  comments VARCHAR(200),
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE bus_contract_customer_rel(
  id INT NOT NULL AUTO_INCREMENT,
  contract_no VARCHAR(20) NOT NULL ,
  customer_no VARCHAR(20) NOT NULL ,
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL,
  PRIMARY KEY (id)
);

/**
合同付款
 */
CREATE TABLE bus_contract_pay(
  id INT NOT NULL AUTO_INCREMENT,
  customer_no VARCHAR(20) NOT NULL ,
  contract_no VARCHAR(20) NOT NULL ,
  pay_money DECIMAL NOT NULL ,
  pay_accept VARCHAR(50),
  pay_mode VARCHAR(10),
  pay_account VARCHAR(50),
  comments VARCHAR(200),
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL ,
  PRIMARY KEY (id)
);

/*
合同货品
 */
CREATE TABLE bus_goods_info(
  id INT NOT NULL AUTO_INCREMENT,
  goods_no VARCHAR(20) NOT NULL ,
  goods_name VARCHAR(100) NOT NULL ,
  goods_std VARCHAR(200),
  goods_num INT NOT NULL ,
  sum_price DECIMAL NOT NULL ,
  unit_price DECIMAL NOT NULL ,
  goods_type VARCHAR(20),
  comments VARCHAR(200),
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE bus_contract_goods_rel(
  id INT NOT NULL AUTO_INCREMENT,
  contract_no VARCHAR(20),
  goods_no VARCHAR(20),
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL ,
  PRIMARY KEY (id)
);


/**
货品图纸
 */
CREATE TABLE bus_contract_goods_file(
  id INT NOT NULL AUTO_INCREMENT,
  contract_no VARCHAR(20) NOT NULL ,
  goods_no int NOT NULL ,
  file_name VARCHAR(200),
  file MEDIUMBLOB,
  file_type VARCHAR(10),
  comments VARCHAR(200),
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL ,
  PRIMARY KEY (id)
);

/**
开票信息
 */
CREATE TABLE bus_receipt_info(
  id INT NOT NULL AUTO_INCREMENT,
  customer_no VARCHAR(20) NOT NULL ,
  contract_no VARCHAR(20),
  receipt_no VARCHAR(50) ,
  open_time DATE,
  open_sum DECIMAL,
  tax DECIMAL,
  send_time DATE,
  waybill_no VARCHAR(50),
  pay_accept VARCHAR(50),
  receipt_status VARCHAR(10),
  comments VARCHAR(200),
  op_create VARCHAR(20) NOT NULL ,
  op_modify VARCHAR(20) NOT NULL ,
  gtm_create DATETIME NOT NULL ,
  gtm_modify DATETIME NOT NULL ,
  PRIMARY KEY (id)
);


/*
用户信息表
 */
create TABLE sys_user(
  id int not null,
  creator_id int,
  create_time DATETIME,
  creator_name varchar(100),
  creator_ip varchar(50),
  updator_id int,
  update_time DATETIME,
  updator_name varchar(100),
  updator_ip varchar(50),

  login_name varchar(50) not null,
  password varchar(100) not null,
  name varchar(100) not null,
  account_enabled BOOL not null,
  expire_date DATETIME,
  PRIMARY KEY (id)
);

create TABLE sys_user_role(
  sys_user_id int not null,
  sys_role VARCHAR(50),
  sys_role_name VARCHAR(100),
  PRIMARY KEY (sys_user_id,sys_role)
);


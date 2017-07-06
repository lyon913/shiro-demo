/*
用户信息表
 */
create TABLE SysUser(
  id int not null,
  creatorId int,
  createTime DATETIME,
  creatorName varchar(100),
  creatorIp varchar(50),
  updatorId int,
  updateTime DATETIME,
  updatorName varchar(100),
  updatorIp varchar(50),

  loginName varchar(50) not null,
  password varchar(100) not null,
  name varchar(100) not null,
  accountEnabled BOOL not null,
  expireDate DATETIME,
  PRIMARY KEY (id)
);

create TABLE SysUserRole(
  sysUserId int not null,
  sysRole VARCHAR(50),
  sysRoleName VARCHAR(100),
  PRIMARY KEY (sysUserId,sysRole)
);


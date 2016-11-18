create table SysArea (
    id INT IDENTITY (1,1) PRIMARY KEY ,
    code VARCHAR (50),
    name VARCHAR (200)
);

create table SysPermission (
    id INT IDENTITY (1,1) PRIMARY KEY ,
    type VARCHAR (50),
    name VARCHAR (200),
    permission VARCHAR (200),
    desc VARCHAR (500)
);

create table SysRole (
    role VARCHAR (50),
    name VARCHAR (200),
    desc VARCHAR (500)
);

create table SysRolePermission (
    role VARCHAR (50),
    permissionId int
);

create table SysUser (
    id INT IDENTITY (1,1) PRIMARY KEY ,
    loginName VARCHAR (50),
    permissionId int
);
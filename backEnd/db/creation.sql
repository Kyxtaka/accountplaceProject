--creation 
CREATE TYPE perm AS ENUM ('admin','user');

-- creation tables compte utilisateur
CREATE TABLE ACCOUNT (
    id int PRIMARY KEY,
    password varchar(255),
    username varchar(255),
    mail varchar(255),
    privilges perm
);

--creation groupe
CREATE TABLE GROUPE (
    id int PRIMARY KEY,
    nom varchar(255),
    password varchar(255)
);

--creation plateform
CREATE TABLE PLATEFORM (
    id int PRIMARY KEY,
    nom varchar(255),
    url varchar(255),
    imgRef varchar(255)
);

CREATE TABLE CREDENTIAL (
    id int PRIMARY KEY,
    accountId varchar(255),
    password varchar(255),
    mail varchar(255),
    A2F int not null constraint chk_A2F CHECK (A2F in (0,1)),
    plateformId int references PLATEFORM (id),
    groupeId int references GROUPE (id)
);

CREATE TABLE MEMBRE (
    groupId int references GROUPE (id),
    accountId int references ACCOUNT (id),
    PRIMARY KEY (groupId,accountId)
);


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

--creation plateforme
CREATE TABLE PLATEFORME (
    id int PRIMARY KEY,
    nom varchar(255),
    url varchar(255),
    imgref varchar(255)
);

CREATE TABLE CREDENTIALS (
    id int PRIMARY KEY,
    accountid varchar(255),
    password varchar(255),
    mail varchar(255),
    A2F int not null constraint chk_A2F CHECK (A2F in (0,1)),
    plateformid int references PLATEFORME (id)
);

CREATE TABLE MEMBRE (
    idgroupe int references GROUPE (id),
    idaccount int references ACCOUNT (id),
    PRIMARY KEY (idgroupe,idaccount)
);

CREATE TABLE LINKED (
    idgroupe int references GROUPE (id),
    idcredential int references CREDENTIALS (id),
    PRIMARY KEY (idgroupe,idcredential)
);


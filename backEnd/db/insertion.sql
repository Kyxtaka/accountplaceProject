-- Insertion data test compte utilisateur et admin
INSERT INTO ACCOUNT VALUES (0,'test','user1','akiizsan@gmail.com','user');
INSERT INTO ACCOUNT VALUES (1,'test','admin1','nathangamersession@gmail.com','admin');

-- Insertion Groupe1 
INSERT INTO GROUPE VALUES (0,'groupe1','groupe1');

-- Insertion Plateforme
INSERT INTO PLATEFORM VALUES 
    (0,'Riot Games', 'https://www.riotgames.com/fr', null),
    (1,'steams', 'https://store.steampowered.com/', null);
    
-- Insertion 
INSERT INTO CREDENTIAL VALUES
    (0,'xxxxxxxx', 'xxxxxxxxx', 'akiizsan@gmail.com', 1,0,0),
    (1,'xxxxxxxx', 'xxxxxxxxx', 'akiizsan0@gmail.com', 1,0,0);

INSERT INTO MEMBRE VALUES
    (0,0),
    (0,1);

CREATE TABLE IF NOT EXISTS usuario(
    
    id BIGINT not NULL auto_increment,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
);
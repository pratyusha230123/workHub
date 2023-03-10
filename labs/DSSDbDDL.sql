-- Table dssdb.ADMIN
CREATE TABLE IF NOT EXISTS dssdb.ADMIN ( 
FIRST_NAME VARCHAR(45) NULL DEFAULT NULL, 
LAST_NAME VARCHAR(45) NULL DEFAULT NULL, 
PASSWORD VARCHAR(45) NULL DEFAULT NULL, 
ADMIN_ID INT NOT NULL, 

PRIMARY KEY (ADMIN_ID));

-- Table dssdb.ACTORS
CREATE TABLE IF NOT EXISTS dssdb.ACTORS (
 ACTOR_ID BIGINT NOT NULL, 
 FIRST_NAME VARCHAR(25) NULL DEFAULT NULL, 
 LAST_NAME VARCHAR(25) NULL DEFAULT NULL, 
 GENDER CHAR(1) NULL DEFAULT NULL, 
 AGE INT NULL DEFAULT NULL, 
 
 PRIMARY KEY (ACTOR_ID));
 
 -- Table dssdb.MOVIES
 CREATE TABLE IF NOT EXISTS dssdb.MOVIES (
 MOVIE_ID INT NOT NULL, 
 MOVIE_TITLE VARCHAR(50) NULL DEFAULT NULL, 
 MOVIE_COST INT NULL DEFAULT NULL, 
 MOVIE_YEAR INT NULL DEFAULT NULL, 
 
 PRIMARY KEY (MOVIE_ID));
 
 -- Table dssdb.MOVIEACTORS
 CREATE TABLE IF NOT EXISTS dssdb.MOVIEACTORS (
 ma_id BIGINT NOT NULL, 
 movie_id INT NULL DEFAULT NULL, 
 actor_id BIGINT NULL DEFAULT NULL, 
 PRIMARY KEY (ma_id), 
 INDEX movie_id (movie_id ASC) VISIBLE, 
 INDEX actor_id (actor_id ASC) VISIBLE, 
 
 CONSTRAINT movieactors_ibfk_1 FOREIGN KEY (movie_id) REFERENCES dssdb.movies (MOVIE_ID), 
 CONSTRAINT movieactors_ibfk_2 FOREIGN KEY (actor_id) REFERENCES dssdb.actors (ACTOR_ID));
 
 -- Table dssdb.REVIEW
 CREATE TABLE IF NOT EXISTS dssdb.REVIEW (
 REVIEW_ID INT NOT NULL, 
 DATE_POSTED DATETIME NULL DEFAULT NULL, 
 DESCRIPTION VARCHAR(45) NULL DEFAULT NULL,
 RATING INT NULL DEFAULT NULL, 
 MOVIE_ID INT NULL DEFAULT NULL, 
 PRIMARY KEY (REVIEW_ID), 
 INDEX MOVIE_ID (MOVIE_ID ASC) VISIBLE, 
 
 CONSTRAINT review_ibfk_1 FOREIGN KEY (MOVIE_ID) REFERENCES dssdb.movies (MOVIE_ID));
 
 
# mario-db-learn

INSERT INTO characters(name, homeland, favorite_color) 
VALUES ('Toadstool', 'Mushroom Kingdom', 'Red'),
('Bowser', 'Mushroom Kingdom', 'Green');

SELECT * FROM characters;

DELETE FROM characters WHERE name IN ('Toadstool','Bowser');

INSERT INTO characters(name, homeland, favorite_color) 
VALUES ('Daisy', 'Sarasaland', 'Yellow'),
('Yoshi', 'Dinosaur Land', 'Green');

UPDATE characters SET favorite_color='Orange' WHERE name='Daisy';

UPDATE characters SET name='Toad' WHERE favorite_color='Red';

UPDATE characters SET name='Mario' WHERE character_id=1;

UPDATE characters SET favorite_color='Blue' WHERE character_id=6;
UPDATE characters SET favorite_color='Yellow' WHERE character_id=7;
UPDATE characters SET homeland='Koopa Kingdom' WHERE character_id=7;

SELECT * FROM characters ORDER BY character_id;
SELECT character_id FROM characters;
SELECT character_id,name FROM characters WHERE name='Luigi';
SELECT character_id,name FROM characters WHERE name='Toad';
SELECT character_id,name FROM characters WHERE name='Bowser';
SELECT character_id,name FROM characters WHERE name='Daisy';
SELECT character_id,name FROM characters WHERE name='Yoshi';

ALTER TABLE characters ADD PRIMARY KEY(name);
-- 删除约束
ALTER TABLE characters DROP CONSTRAINT characters_pkey;
ALTER TABLE characters ADD PRIMARY KEY (character_id);


CREATE TABLE more_info();
ALTER TABLE more_info ADD COLUMN more_info_id SERIAL;
ALTER TABLE more_info ADD PRIMARY KEY (more_info_id);
ALTER TABLE more_info ADD COLUMN birthday DATE;
ALTER TABLE more_info ADD COLUMN height INT;
ALTER TABLE more_info ADD COLUMN weight NUMERIC(4,1);
-- 给表添加字段，并设置外键
ALTER TABLE more_info ADD COLUMN character_id INT REFERENCES characters(character_id);
-- 添加唯一键，表示 1v1 的关系
ALTER TABLE more_info ADD UNIQUE (character_id);
-- 设置字段不能为空
ALTER TABLE more_info ALTER COLUMN character_id SET NOT NULL;
-- 修改 column 名称
ALTER TABLE more_info RENAME COLUMN height TO height_in_cm;
ALTER TABLE more_info RENAME COLUMN weight TO weight_in_kg;

INSERT INTO more_info(birthday, height, weight, character_id) VALUES ('1981-07-09',155,64.5,1);
INSERT INTO more_info(birthday, height, weight, character_id) VALUES ('1983-07-14',175,48.8,2);
INSERT INTO more_info(birthday, height, weight, character_id) VALUES ('1985-10-18',173,52.2,3);
INSERT INTO more_info(birthday, height, weight, character_id) VALUES ('1950-01-10',66,35.6,6);
INSERT INTO more_info(birthday, height, weight, character_id) VALUES ('1990-10-29',258,300,7);
INSERT INTO more_info(birthday, height, weight, character_id) VALUES ('1989-07-31',NULL,NULL,8);
INSERT INTO more_info(birthday, height, weight, character_id) VALUES ('1990-04-13',162,59.1,9);

SELECT * FROM more_info ;
SELECT more_info_id,birthday,height AS height_in_cm,weight,character_id  FROM more_info ;


-- sounds
CREATE TABLE sounds (
    sound_id SERIAL PRIMARY KEY
);

ALTER TABLE sounds ADD COLUMN filename VARCHAR(40) NOT NULL UNIQUE;
ALTER TABLE sounds ADD COLUMN character_id INT NOT NULL REFERENCES characters(character_id);

INSERT INTO sounds(filename, character_id) VALUES ('its-a-me.wav',1);
INSERT INTO sounds(filename, character_id) VALUES ('yippee.wav',1);
INSERT INTO sounds(filename, character_id) VALUES ('ha-ha.wav',2);
INSERT INTO sounds(filename, character_id) VALUES ('oh-yeah.wav',2);
INSERT INTO sounds(filename, character_id) VALUES ('yay.wav',3),('woo-hoo.wav',3);
INSERT INTO sounds(filename, character_id) VALUES ('mm-hmm.wav',3),('yahoo.wav',1);

SELECT * FROM sounds;


-- actions
CREATE TABLE actions (
    action_id SERIAL PRIMARY KEY
);

ALTER TABLE actions ADD COLUMN action VARCHAR(20) NOT NULL UNIQUE;

INSERT INTO actions(action) VALUES ('run');
INSERT INTO actions(action) VALUES ('jump');
INSERT INTO actions(action) VALUES ('duck');

SELECT * FROM actions;

-- character_actions

CREATE TABLE character_actions ();
ALTER TABLE character_actions ADD COLUMN character_id INT NOT NULL;
ALTER TABLE character_actions ADD FOREIGN KEY (character_id) REFERENCES characters(character_id);
ALTER TABLE character_actions ADD COLUMN action_id INT NOT NULL;
ALTER TABLE character_actions ADD FOREIGN KEY (action_id) REFERENCES actions(action_id);

-- 添加联合主键
ALTER TABLE character_actions ADD PRIMARY KEY (character_id,action_id);

INSERT INTO character_actions VALUES (9,1),(9,2),(9,3);
INSERT INTO character_actions VALUES (8,1),(8,2),(8,3);
INSERT INTO character_actions VALUES (7,1),(7,2),(7,3);
INSERT INTO character_actions VALUES (6,1),(6,2),(6,3);
INSERT INTO character_actions VALUES (3,1),(3,2),(3,3);
INSERT INTO character_actions VALUES (2,1),(2,2),(2,3);
INSERT INTO character_actions VALUES (1,1),(1,2),(1,3);

SELECT * FROM character_actions;

-- 查询部分

SELECT * FROM characters t1 FULL JOIN more_info t2 ON t1.character_id = t2.character_id;
SELECT * FROM characters t1 FULL JOIN sounds t2 ON t1.character_id = t2.character_id;

SELECT * FROM character_actions t0 
  FULL JOIN characters t1 ON t0.character_id = t1.character_id
  FULL JOIN actions t2 ON t0.action_id = t2.action_id;
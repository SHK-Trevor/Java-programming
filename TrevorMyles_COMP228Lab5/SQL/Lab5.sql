CREATE TABLE Player (
    player_id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    email VARCHAR(100)
);

CREATE TABLE Game (
    game_id INT PRIMARY KEY,
    title VARCHAR(100)
);

CREATE TABLE PlayerGame (
    player_id INT REFERENCES Player(player_id),
    game_id INT REFERENCES Game(game_id),
    play_date DATE,
    PRIMARY KEY (player_id, game_id)
);

INSERT INTO Game (game_id, title) VALUES (1, 'Game 1'), (2, 'Game 2'), (3, 'Game 3');

SELECT * FROM Game;

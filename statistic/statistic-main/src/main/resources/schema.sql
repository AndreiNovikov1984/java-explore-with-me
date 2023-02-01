DROP TABLE IF EXISTS STATISTIC;

create table IF NOT EXISTS STATISTIC
(
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY
        primary key,
    APP CHARACTER VARYING(50),
    URI CHARACTER VARYING(100),
    IP CHARACTER VARYING(20),
    TIMESTAMP TIMESTAMP not null
);

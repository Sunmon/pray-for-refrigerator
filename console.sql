use pray_for_refrigerator;
show variables like 'c%';

#Database option change
ALTER DATABASE pray_for_refrigerator
CHARACTER SET = 'utf8mb4'
COLLATE = 'utf8mb4_general_ci';

#timezone 확인
select @@time_zone, now();

#한글 데이터 등록 확인
CREATE TABLE test(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    content varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE =InnoDB;

insert into test(content) values ('테스트');

select * from test;
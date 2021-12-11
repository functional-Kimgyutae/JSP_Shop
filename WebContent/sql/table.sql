-- user table 제작
drop table member;

create table member(
    m_id varchar2(100) primary key,
    m_psd varchar2(100),
    m_name varchar2(100),
    m_phone varchar2(20),
    m_email varchar2(100),
    m_emailCheck number default 1,-- 미인증 : 1, 인증 : 2 
    m_exit number default 1, -- 활동 : 1, 탈퇴 : 2
    m_date date default sysdate,
    m_gender number -- 선택안함 : 0 남자: 1, 여자 : 2 
);

SELECT * FROM member;
-- 집주소 가져오는 join
SELECT m.m_id "m_id",m.m_name "email",m.m_phone "phone",m_email "email", da.m_address1,da.m_address2,da.m_address3
    FROM member m
    JOIN detail_address da ON m.m_id = da.m_id;
-- 아이디 중복 비교
SELECT m_id from member where id= '';
    
-- insert 예시
INSERT INTO member(m_id,m_psd,m_name,m_phone,m_email,m_gender) 
 VALUES ('stop','1234','김규태','010-4621-9625','stoprabbit20@gmail.com','1') ;
INSERT INTO member(m_id,m_psd,m_name,m_phone,m_email,m_gender) 
 VALUES ('admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','관리자','010-1234-5678','y2010109@y-y.hs.kr','1'); 
 
 
-- detail_address table 제작
drop table detail_address;

create table detail_address(
    m_id varchar2(100) primary key,
    m_address1 varchar2(100),
    m_address2 varchar2(100),
    m_address3 varchar2(100),
    constraint detail_address_m_id_fk FOREIGN key(m_id) REFERENCES member(m_id) 
);
SELECT * FROM detail_address;
INSERT INTO detail_address(m_id,m_address1,m_address2,m_address3)
    VALUES ('admin','ㅇㅁㄹ','12222','101호');
INSERT INTO detail_address(m_id,m_address1,m_address2,m_address3)
    VALUES ('stop','경기도 광주','12222','101호');
    
drop table product;
create table product (
    p_id int primary key,
    p_name varchar2(100),
    p_l_name varchar2(100),
    p_tag number,
    p_price number,
    p_count number,
    p_cnt number,
    p_unit varchar2(100),
    p_packaging varchar2(100),
    p_text varchar2(3000),
    p_date date default sysdate,
    p_view number default 0,
    p_exit number default 1 -- 구매가능 : 1, 삭제 : 2
);
   
select count(*) as cnt from product;

select * from product where p_id = 0;

INSERT INTO product(p_id,p_name,p_l_name,p_tag,p_price,p_count,p_cnt,p_unit,p_packaging,p_text) values ('0','상품1','상품2','1','10000','10','1','1개','냉장','ㅁㄴㅇㄻㄴㅇㄻㄴㅇㄹ');

    
-- user table 占쏙옙占쏙옙
drop table member;

create table member(
    m_id varchar2(100) primary key,
    m_psd varchar2(100),
    m_name varchar2(100),
    m_phone varchar2(20),
    m_email varchar2(100),
    m_emailCheck number default 1,-- 占쏙옙占쏙옙占쏙옙 : 1, 占쏙옙占쏙옙 : 2 
    m_exit number default 1, -- 활占쏙옙 : 1, 탈占쏙옙 : 2
    m_date date default sysdate,
    m_gender number -- 占쏙옙占시억옙占쏙옙 : 0 占쏙옙占쏙옙: 1, 占쏙옙占쏙옙 : 2 
);

SELECT * FROM member;
-- 占쏙옙占쌍쇽옙 占쏙옙占쏙옙占쏙옙占쏙옙 join
SELECT m.m_id "m_id",m.m_name "name",m.m_phone "phone",m_email "email", da.m_address1,da.m_address2,da.m_address3 FROM member m JOIN detail_address da ON m.m_id = da.m_id where m.m_id = ? and m.m_psd = ?;
-- 占쏙옙占싱듸옙 占쌩븝옙 占쏙옙
SELECT m_id from member where id= '';
    
-- insert 占쏙옙占쏙옙
INSERT INTO member(m_id,m_psd,m_name,m_phone,m_email,m_gender) 
 VALUES ('stop','1234','占쏙옙占쏙옙占�','010-4621-9625','stoprabbit20@gmail.com','1') ;
INSERT INTO member(m_id,m_psd,m_name,m_phone,m_email,m_gender) 
 VALUES ('admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','占쏙옙占쏙옙占쏙옙','010-1234-5678','y2010109@y-y.hs.kr','1'); 
 
---------------------------------------------
-- detail_address table 占쏙옙占쏙옙
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
    VALUES ('admin','占쏙옙占쏙옙占쏙옙','12222','101호');
INSERT INTO detail_address(m_id,m_address1,m_address2,m_address3)
    VALUES ('stop','占쏙옙竪� 占쏙옙占쏙옙','12222','101호');
---------------------------------------------
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
    p_exit number default 1 -- 占쏙옙占신곤옙占쏙옙 : 1, 占쏙옙占쏙옙 : 2
);
select * from product;

select count(*) as cnt from product;

select ROW_NUMBER() over (ORDER BY p_id) num, p.* from product p where p_exit= 1
select * from(select ROW_NUMBER() over (ORDER BY p_id) num, p.* from product p where p_exit= 1)where num between 1 and 1;

select * from product where p_id = 0;

INSERT INTO product(p_id,p_name,p_l_name,p_tag,p_price,p_count,p_cnt,p_unit,p_packaging,p_text) values ('0','占쏙옙품1','占쏙옙품2','1','10000','10','1','1占쏙옙','占쏙옙占쏙옙','占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙');


---------------------------------------------
drop table detail_product;
create table detail_product (
    idx number primary key,
    p_id number,
    p_img VARCHAR2(1000),
    constraint detail_product_p_id_fk FOREIGN key(p_id) REFERENCES product(p_id) 
);
select * from detail_product;

select p_img from detail_product where p_id = 0;

drop sequence detail_idx;

CREATE SEQUENCE detail_idx START WITH 0 minvalue 0 INCREMENT BY 1 NOCACHE;
    
INSERT INTO DETAIL_PRODUCT (idx,p_id,p_img) values (detail_idx.NEXTVAL,'0','2');
---------------------------------------------
drop table cart;
create table cart (
	c_id number primary key,
	p_id number,
	m_id VARCHAR2(100),
	c_cnt number,
	constraint cart_p_id_fk FOREIGN key(p_id) REFERENCES product(p_id),
	constraint cart_m_id_fk FOREIGN key(m_id) REFERENCES member(m_id)
);
select * from cart;
CREATE SEQUENCE cart_idx START WITH 0 minvalue 0 INCREMENT BY 1 NOCACHE;

INSERT INTO cart (c_id,p_id,m_id,c_cnt) values (cart_idx.NEXTVAL,?,?,?);

SELECT c_id from cart where p_id = ? and m_id = ?; -- 占싱뱄옙 占쏙옙占쏙옙獵占쏙옙占� 확占쏙옙

DELETE FROM cart where c_id = ?; -- 占쏙옙占쏙옙占쏙옙

UPDATE cart SET c_cnt = ? WHERE c_id = ?; -- 占쏙옙占쏙옙占쌀띰옙 占쏙옙占쏙옙

SELECT c.c_id , p.p_id ,c.m_id , c.c_cnt ,p.p_price,dp.p_img 
	FROM cart c
	JOIN product p on c.p_id = p.p_id
	INNER JOIN detail_product dp on p.p_id = dp.p_id
	where c.m_id = 'admin';


create table orderList (
	o_id number primary key,
	m_id VARCHAR2 (100),
	o_price number,
	o_date date
)
CREATE SEQUENCE order_idx START WITH 0 minvalue 0 INCREMENT BY 1 NOCACHE;




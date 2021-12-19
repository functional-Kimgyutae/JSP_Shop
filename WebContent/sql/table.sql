drop table member;

create table member(
    mId varchar2(100) primary key,
    mPsd varchar2(100),
    mName varchar2(100),
    mPhone varchar2(20),
    mEmail varchar2(100),
    mEmailCheck number default 1,
    mExit number default 1, 
    mDate date default sysdate,
    mGender number 
);

SELECT * FROM member;

SELECT m.mId "mId",m.mName "name",m.mPhone "phone",mEmail "email", da.mAddress1,da.mAddress2,da.mAddress3 FROM member m JOIN detailAddress da ON m.mId = da.mId where m.mId = ? and m.mPsd = ?;

SELECT mId from member where id= '';
    
INSERT INTO member(mId,mPsd,mName,mPhone,mEmail,mGender) 
 VALUES ('admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','관리자','010-1234-5678','y2010109@y-y.hs.kr','1'); 
 


drop table detailAddress;

create table detailAddress(
    mId varchar2(100) primary key,
    mAddress1 varchar2(100),
    mAddress2 varchar2(100),
    mAddress3 varchar2(100),
    constraint detailAddress_mId_fk FOREIGN key(mId) REFERENCES member(mId) 
);
SELECT * FROM detailAddress;
INSERT INTO detailAddress(mId,mAddress1,mAddress2,mAddress3)
    VALUES ('admin','경기도 어딘','12222','101호');
INSERT INTO detailAddress(mId,mAddress1,mAddress2,mAddress3)
    VALUES ('stop','','12222','101호');

drop table product;
create table product (
    pId number primary key,
    pName varchar2(100),
    pLName varchar2(100),
    pTag number,
    pPrice number,
    pCnt number,
    pUnit varchar2(100),
    pPackaging varchar2(100),
    pText varchar2(3000),
    pDate date default sysdate,
    pView number default 0,
    pExit number default 1 
);
select * from product;
select * from product where pId = 0 and pExit = 1;
select count(*) as cnt from product;

select ROWNUMBER() over (ORDER BY pId) num, p.* from product p where pExit= 1
select * from(select ROWNUMBER() over (ORDER BY pId) num, p.* from product p where pExit= 1)where num between 1 and 1;

select * from product where pId = 0;




drop table detailProduct;
create table detailProduct (
    idx number primary key,
    pId number,
    pImg VARCHAR2(1000),
    constraint detailProduct_pId_fk FOREIGN key(pId) REFERENCES product(pId) 
);
select * from detailProduct;

select pImg from detailProduct where pId = 0;

drop sequence detailIdx;

CREATE SEQUENCE detailIdx START WITH 0 minvalue 0 INCREMENT BY 1 NOCACHE;
    
INSERT INTO DETAILPRODUCT (idx,pId,pImg) values (detailIdx.NEXTVAL,'0','2');

drop table cart;
create table cart (
	cId number primary key,
	pId number,
	mId VARCHAR2(100),
	cCnt number,
	constraint cart_pId_fk FOREIGN key(pId) REFERENCES product(pId),
	constraint cart_mId_fk FOREIGN key(mId) REFERENCES member(mId)
);
select * from cart;
CREATE SEQUENCE cartIdx START WITH 0 minvalue 0 INCREMENT BY 1 NOCACHE;

INSERT INTO cart (cId,pId,mId,cCnt) values (cartIdx.NEXTVAL,?,?,?);

SELECT cId from cart where pId = ? and mId = ?; 

DELETE FROM cart where mId = ?; 

UPDATE cart SET cCnt = ? WHERE cId = ?; 

SELECT c.cId , p.pId ,c.mId , c.cCnt ,p.pPrice,dp.pImg 
	FROM cart c
	JOIN product p on c.pId = p.pId
	INNER JOIN detailProduct dp on p.pId = dp.pId
	where c.mId = 'admin';

drop table orderList;
create table orderList (
	oId number primary key,
	mId VARCHAR2 (100),
	oPrice number,
	oDate date default sysdate
)
CREATE SEQUENCE orderIdx START WITH 0 minvalue 0 INCREMENT BY 1 NOCACHE;

INSERT INTO orderList (oId,mId,oPrice) values (orderIdx.NEXTVAL,?,?);


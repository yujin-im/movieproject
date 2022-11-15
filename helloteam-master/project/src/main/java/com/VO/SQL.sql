select * from tbl_video;


select video_seq,video_type,video_title,video_content,video_img,to_char(video_open_date,'YYYY-MM-DD'),to_char(video_close_date,'YYYY-MM-DD'),video_rating,video_runtime,video_country,video_ott,genre_seq,mb_id from tbl_video where video_type = '1' and video_ott = 'netflix' and video_img = 'https://img1.daumcdn.net/thumb/C408x596/?fname=https://t1.daumcdn.net/movie/c23137b8c082f66df707f21c9884ca38a1903efa'



select * from tbl_video where video_img = 'https://img1.daumcdn.net/thumb/C408x596/?fname=https://t1.daumcdn.net/movie/c23137b8c082f66df707f21c9884ca38a1903efa'
select * from tbl_video where video_title = '미나리'

update tbl_video set video_type = '2' where video_type = '종료예정'

update tbl_video set video_ott = 'watcha' where video_ott = '왓챠'

select * from TBL_VIDEO;

delete from TBL_VIDEO where video_seq = 294

select * from tbl_member;

insert into tbl_member values('박성진','1234','1234','2022-08-01','M',SYSDATE,'U')

select * from tbl_genre
select * from tbl_fav_genre;

insert int va (fg_seq.new , id, gen)

select * from TBL_VIDEO

CREATE SEQUENCE tbl_seq
start with 1
increment by 1
minvalue 1
MAXVALUE 9999
drop SEQUENCE tbl_seq
ALTER SEQUENCE tbl_seq start BY 1; 
 ALTER SEQUENCE seq INCREMENT BY 1; 

select TBL_FAV_GENRE,TBL_FAV_GENRE.type

delete TBL_FAV_GENRE;
commit;
insert into tbl_fav_genre values(seq.NEXTVAL,1,0,'안녕');
insert into tbl_fav_genre(fg_seq,mb_id,genre_seq) values('안녕',1,seq.NEXTVAL)

alter table tbl_fav_genre modify fg_seq NUMBER(12,0);

alter table  add fav_genre varchar(300);

select * from tbl_fav_genre

select * from tbl_fav_genre where MB_ID=1;
select * from tbl_member where MB_Id =?

insert into tbl_fav_genre values(tbl_fav_genre_SEQ.nextval,5)

insert into tbl_community values(tbl_seq.nextval,'테스트1','tessttest','tes',sysdate,'5',0);
delete TBL_community;

ALTER SEQUENCE tbl_community_seq INCREMENT BY 1; 

select * from tbl_community where article_date = '2022/08/30'
select * from tbl_community where ARTICLE_SEQ < 48 and rownum<=10 order by ARTICLE_SEQ desc
select article_seq(select article_seq from tbl_community order by ARTICLE_SEQ desc ) from tbl_community where ARTICLE_SEQ < 48 

select * from tbl_genre;
select * from 
 UPDATE tbl_fav_genre set FAV_GENRE_ID=null where MB_ID=5
 select * from tbl_community where ARTICLE_SEQ = 20
select * from (select ARTICLE_SEQ, ARTICLE_TITLE, ARTICLE_CONTENT, ARTICLE_FILE, ARTICLE_DATE, MB_ID from tbl_community ORDER BY ARTICLE_SEQ DESC ) where article_seq < 30 and rownum<=10   
SELECT * FROM (SELECT b.article_seq, b.article_title, b.article_content,b.article_file, b.article_date, b.mb_id FROM tbl_community b, tbl_community m WHERE b.mb_id = m.mb_id ORDER BY article_seq DESC) WHERE rn>? AND rn <= ?;
select ARTICLE_SEQ11(select ARTICLE_SEQ from tbl_community ORDER BY ARTICLE_SEQ DESC ) from tbl_community
delete tbl_community
drop TABLE tbl_community
DROP TRIGGER tbl_community_AI_TRG;
CREATE TABLE tbl_community
(
    article_seq        NUMBER(12, 0)     NOT NULL, 
    article_title      VARCHAR2(300)     NOT NULL, 
    article_content    VARCHAR2(4000)    NOT NULL, 
    article_file       VARCHAR2(300)     NOT NULL, 
    article_date       DATE              NOT NULL, 
    mb_id              VARCHAR2(20)      NOT NULL, 
     PRIMARY KEY (article_seq)
)
select * from tbl_community where ARTICLE_SEQ < 12 and rownum<=10 order by ARTICLE_SEQ desc
select ARTICLE_SEQ from tbl_community ORDER BY ARTICLE_SEQ DESC
select * from tbl_community where ARTICLE_SEQ < 10 and rownum<=10 order by ARTICLE_SEQ desc
select * from tbl_community where ARTICLE_SEQ < 12 and rownum<=10 order by ARTICLE_SEQ desc ;

select * from tbl_community where article_seq = 12 order by article_seq desc limit 10

delete from tbl_community where mb_id='5'
CREATE SEQUENCE cmt_seq
start with 1
increment by 1
minvalue 1
MAXVALUE 9999
insert into tbl_comment values(cmt_seq.nextval, '46' ,'1241' ,sysdate,'5')
insert into tbl_comment values(cmt_seq.nextval, 47 ,'댓글 test' ,sysdate,'5');
select * from tbl_comment where article_seq = 48 order by cmt_seq desc 

select tbl_
UPDATE tbl_community set ARTICLE_count=ARTICLE_count+1 where ARTICLE_SEQ='61'


alter table tbl_community add article_count number(12,0) default 0          //컬럼 추가
alter table tbl_community modify(article_count not null)

alter table tbl_community drop column article_count

select * from (select ARTICLE_SEQ, ARTICLE_TITLE, ARTICLE_CONTENT, ARTICLE_FILE, ARTICLE_DATE, ARTICLE_COUNT, MB_ID from tbl_community ORDER BY ARTICLE_SEQ DESC ) where article_seq < '2' and rownum<=10
insert into user_role values(1,'admin','dagrawal',now());

insert into contact values(1,'Devendra','Agrawal','Dev','31 Parkerson Rd','Edison','NJ','USA',7326623814,7328743335,'dagrawal',now());

insert into user values(1,'dagrawal',1,'dagrawal',1,'y','dagrawal',now());

insert into account_type values(1,'regular',5,'dagrawal',now());

insert into account values(1,3814,1,now(),null,1,'y','dagrawal',now());

insert into media_type values(1,'book','printed book','dagrawal',now());
insert into media_type values(2,'cd','audio, video or data cd','dagrawal',now());
insert into media_type values(3,'dvd','audio, video or data dvd','dagrawal',now());

insert into media_category values(1,'education','dagrawal',now());
insert into media_category values(2,'movie','dagrawal',now());
insert into media_category values(3,'bhajan','dagrawal',now());
insert into media_category values(4,'biography','dagrawal',now());
insert into media_category values(5,'dham','dagrawal',now());

insert into media values(1,'Bhagavad gita as it is', 1,1,1,1,5,'bhagavad gita as it is by Srila Prabhupada',null,'A.C Bhaktivedanta Prabhupada', 'Bhaktivedanta Book Trust', 'dagrawal',now());


alter table media_lending change actual_return_datetime actual_return_datetime datetime null;

insert into media_lending values(1,1,1,now(),null,null,'dagrawal',now());


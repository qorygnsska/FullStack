create table homeUsers(
    
	no  		number primary key,
	email 		varchar2(100) not null,
	password 	varchar2(100) not null,
	nickname 	varchar2(50) not null,
	create_at   timestamp  default current_timestamp

);

create sequence user_seq;

commit;


select * from homeUsers;






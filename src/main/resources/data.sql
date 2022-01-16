insert into customer(email, password) values('sljdfs@naver.com','elf245754');
insert into account(customer_id, pay_money,memo,created_at) values(1,200,'콜라한잔',LOCALTIMESTAMP);
delete from account where id =1;
insert into delete_account(id,customer_id, pay_money,memo,created_at,modified_at) values(1,1,200,'콜라한잔',LOCALTIMESTAMP,LOCALTIMESTAMP);
insert into account(customer_id, pay_money,memo,created_at) values(1,2000,'콜라한잔',LOCALTIMESTAMP);
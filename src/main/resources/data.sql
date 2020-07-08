insert into todo(id, user_name,description,target_date,created_by,creation_date,last_modified_by,last_modified_date,is_done)
values(10001, 'pankaj', 'Learn JPA', sysdate(),'pankaj',sysdate(),'pankaj',sysdate(), false);

insert into todo(id, user_name,description,target_date,created_by,creation_date,last_modified_by,last_modified_date,is_done)
values(10002, 'pankaj', 'Learn Data JPA', sysdate(),'pankaj',sysdate(),'pankaj',sysdate(), false);

insert into todo(id, user_name,description,target_date,created_by,creation_date,last_modified_by,last_modified_date,is_done)
values(10003, 'pankaj', 'Learn Microservices', sysdate(),'pankaj',sysdate(),'pankaj',sysdate(),false);

insert into role(role_id, name)
values(1, 'ROLE_ADMIN');

insert into role(role_id, name)
values(2,'ROLE_USER');


insert into user(user_id, user_name,password,enabled)
values(1, 'pankaj','$2a$10$mdqSNklQylGSSOoMgsDlGeMUFYUuEVLw01Bqu.sWTuEc0DruemKvm', true);

insert into user(user_id, user_name,password,enabled)
values(2, 'user','$2a$10$fDgcE9mguoRoJ2fPeGoqn.u/LR8aNQ/COyRqSi1BvpK7TDkD2GFH6', true);

insert into users_roles(user_id,role_id)
values(1,1);

insert into users_roles(user_id,role_id)
values(1,2);

insert into users_roles(user_id,role_id)
values(2,2);

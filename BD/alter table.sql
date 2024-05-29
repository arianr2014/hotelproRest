alter table habitacion add column contadorreserva int default 0;
alter table habitacion add column clasificacion VARCHAR(200) default ''; 
alter table habitacion add column cantidad int default 0; 

alter table habitacion add column counter int default 0; 
alter table habitacion add column onsale  BIT default 1; 
alter table habitacion add column preciovalor VARCHAR(20) default ''; 




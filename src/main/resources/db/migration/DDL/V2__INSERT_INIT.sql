

insert into perfilamiento( pregunta, ponderacion) values ('¿Sabes de inversiones?', 0);
insert into perfilamiento( pregunta, ponderacion) values ('¿Tienes experiencia invirtiendo o ahorrando?', 0);
insert into perfilamiento( pregunta, ponderacion) values ('¿Alcanzas a ahorrar mensualmente una suma considerable?', 0);
insert into perfilamiento( pregunta, ponderacion) values ('Supongamos que tienes $10.000 y deseas invertirlo. Invertirias todo?', 0);
insert into perfilamiento( pregunta, ponderacion) values ('Si sucediera un evento inesperado ¿Retirarías tu dinero?', 0);
insert into perfilamiento( pregunta, ponderacion) values ('Considerando el objetivo y plazos de tus inversiones ¿Serias paciente con tu inversión?', 0);
insert into perfilamiento( pregunta, ponderacion) values ('¿Tines un objetivo para tu inversión?', 0);


INSERT INTO usuario (ID_USUARIO, NOMBRES, IDENTIFICACION, EMAIL, PERFIL, BALANCE) VALUES(1, 'KEVIN TADAY', '1726213976', 'ktaday@ceiba.com', '', 0);


INSERT INTO operacion (ID_OPERACION, ID_USUARIO, TIPO_OPERACION, MONTO, FECHA, ESTATUS) VALUES(1, 1, 'APORTACION', 100, '2022-06-12 17:40:56', 'SOLICITUD');

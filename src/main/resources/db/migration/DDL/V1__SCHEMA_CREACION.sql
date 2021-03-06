DROP TABLE IF EXISTS inversion CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS perfilamiento CASCADE;
DROP TABLE IF EXISTS operacion CASCADE;



CREATE TABLE usuario(
   ID_USUARIO int NOT NULL AUTO_INCREMENT,
   NOMBRES varchar(100) DEFAULT NULL,
   IDENTIFICACION varchar(32) DEFAULT NULL,
   EMAIL varchar(64) DEFAULT NULL,
   PERFIL varchar(32) DEFAULT NULL,
   BALANCE decimal(10,3) DEFAULT 0,
   PRIMARY KEY (ID_USUARIO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE perfilamiento (
   ID_PERFILAMIENTO int NOT NULL AUTO_INCREMENT,
   PREGUNTA varchar(512) DEFAULT NULL,
   PONDERACION int DEFAULT NULL,
   PRIMARY KEY (ID_PERFILAMIENTO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE operacion (
   ID_OPERACION int NOT NULL AUTO_INCREMENT,
   ID_USUARIO int DEFAULT NULL,
   TIPO_OPERACION varchar(32) DEFAULT NULL,
   MONTO decimal(10,3) DEFAULT NULL,
   FECHA datetime DEFAULT NULL,
   ESTATUS varchar(16) DEFAULT NULL,
   PRIMARY KEY (ID_OPERACION),
   KEY OPERACION_FK (ID_USUARIO),
   CONSTRAINT OPERACION_FK FOREIGN KEY (ID_USUARIO) REFERENCES usuario (ID_USUARIO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE inversion (
     ID_INVERSION int NOT NULL AUTO_INCREMENT,
     ID_USUARIO int DEFAULT NULL,
     ID_OPERACION int DEFAULT NULL,
     INTERES decimal(10,3) DEFAULT NULL,
     MONTO_TOTAL decimal(10,3) DEFAULT NULL,
     FECHA datetime DEFAULT NULL,
     PRIMARY KEY (ID_INVERSION),
     KEY INVERSION_FK (ID_USUARIO),
     KEY INVERSION_FK_1 (ID_OPERACION),
     CONSTRAINT INVERSION_FK FOREIGN KEY (ID_USUARIO) REFERENCES usuario (ID_USUARIO),
     CONSTRAINT INVERSION_FK_1 FOREIGN KEY (ID_OPERACION) REFERENCES operacion(ID_OPERACION)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

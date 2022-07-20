
INSERT into usuarios (correo, clave , enable) values ('admin@gmail.com', '$2a$12$3fN/lWdMe7La.TRP/33MjeseG8LrPntSrJAOYYw9M/ARrZwBXnfE2', 1);
INSERT into usuarios (correo, clave , enable) values ('cliente@gmail.com', '$2a$12$7BIYCEADFZVs63CXAqj0/uKmjzN78wnjZL2GiyBAPr.OnXXtqh68O', 1)

insert into roles (rol) values ('ROLE_ADMIN');
insert into roles (rol) values ('ROLE_CLIENTE');
insert into roles (rol) values ('ROLE_EMPLEADO');

INSERT INTO usuarios_roles (usuario_id, role_id) values (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) values (2,2);

insert into productos(estadoPro, imageProp, nombrePro, categoria_id) values("","", "cuaderno 100 hojas", "1");
-- INSERT INTO usuarios_roles (usuario_id, role_id) values (2,1);

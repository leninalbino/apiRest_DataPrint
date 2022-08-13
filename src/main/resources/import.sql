
INSERT into usuarios (correo, clave , enable) values ('admin@gmail.com', '$2a$12$3PClXBgrJyqGRz5VvRkpQezeLEbdG39AkeST.zAfkbVJMAR3wADu2', 1);
INSERT into usuarios (correo, clave , enable) values ('cliente@gmail.com', '$2a$12$7BIYCEADFZVs63CXAqj0/uKmjzN78wnjZL2GiyBAPr.OnXXtqh68O', 1)

insert into roles (rol) values ('ROLE_ADMIN');
insert into roles (rol) values ('ROLE_CLIENTE');
insert into roles (rol) values ('ROLE_EMPLEADO');

INSERT INTO usuarios_roles (usuario_id, role_id) values (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) values (2,2);

INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Útiles de oficina');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Laminas escolares');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Materiales de oficina');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Materiales de cómputo');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Tintas');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Papelería');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Anillados');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Espiralados');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Mercería');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Perfumería');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Pelotas');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Regalos');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Enmicados');
INSERT INTO `dbdataprint`.`categorias` (`nombreCate`) VALUES ('Útiles escolares');




INSERT INTO `dbdataprint`.`productos` (`estadoPro`,`imageProp` ,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2629109974.jpg', 'Tajador doble cheat sharp plastico ', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`,`imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2702400293.jpg', 'Tampón dactilar', 1);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2702404832.jpg', 'Dispensador de Cinta mediano Mod 310', 1);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2702418338.jpg', 'Cuchilla Metal', 1);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (false,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2741703103.jpg', 'Papel Fotocopia', 6);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (false,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/3074601083.jpg', 'Post It', 6);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (false,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2916368887.jpg', 'Block de Notas Flores', 6);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2894187651.jpg', 'Cuaderno A4', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2638130686.jpg', 'Borrador', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2629837356.jpg', 'Borrador Exam', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2681165782.jpg', 'Corrector Liquido', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2670195767.jpg', 'Lápiz Eco', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2700129042.jpg', 'Lápiz Bicolor P12', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2675080418.jpg', 'Goma en barra', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2699870042.jpg', 'Cola Sintética', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d2j6dbq0eux0bg.cloudfront.net/images/63925813/2675179165.jpg', 'Tijera Escolar', 14);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://elcomercio.pe/resizer/Y0MbzZsxR6L6KfhIU_iONQJ9tQw=/620x0/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/YLBVNXSSFNHSRBFP4TZFPZDNIE.jpg', 'Historia  del  Perú', 2);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://elcomercio.pe/resizer/IxDX0PJoVSPgWXpPqpjwYZhfyMw=/980x0/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/LRRAGXHFLNF53LI7YMELTRKYOU.jpg', 'Política  del  Perú', 2);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://image.shutterstock.com/image-photo/two-ceramic-teddy-bears-holding-260nw-1818381767.jpg', 'Peluches  Pequeños', 9);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://m.media-amazon.com/images/I/41A-Zg+Q1pS.jpg', 'Reloj', 9);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://production-tailoy-repo-magento-statics.s3.amazonaws.com/imagenes/872x872/productos/i/l/i/libreta-jean-15bl-puntos-surtido-37446001-default-1.png', 'Libreta', 3);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://www.ekaprecio.com/wp-content/uploads/2021/06/035.jpg', 'Caja de Lapiceros', 3);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://d34vmoxq6ylzee.cloudfront.net/catalog/product/cache/b3b166914d87ce343d4dc5ec5117b502/4/B/4BX31AA-1_T1561581013.png', 'Audífonos', 4);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://production-tailoy-repo-magento-statics.s3.amazonaws.com/imagenes/872x872/productos/i/t/e/teclado-gamer-halion-diamon-k658-rainbow-49202-default-1.jpg', 'Teclado Gamer', 4);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://image.made-in-china.com/155f0j00PEwqtrDmCucn/Ocbestjet-100ml-6-Colors-Universal-Pigment-Ink-314-478-for-Epson-15000-Ink-for-Epson-Expression-Photo-HD-XP-15000-Printer.jpg', 'Tinta HP', 5);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://production-tailoy-repo-magento-statics.s3.amazonaws.com/imagenes/872x872/productos/i/c/u/cuaderno-anillado-a-4-156h-6d-cuadriculado-solido-loro-29224-default-1.jpg', 'Cuaderno Anillado', 7);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://blog.perfumeriasunidas.com/hubfs/30700346101_3-1.jpg', 'Dolce  &  Gabbana', 10);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://home.ripley.com.pe/Attachment/WOP_5/2014175809373/2014175809373_2.jpg', ' Hugo Boss', 10);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://i.linio.com/p/17a4ba588190fee49a9830dddd313bb3-product.jpg', 'Pelota de fútbol', 11);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://w7.pngwing.com/pngs/481/783/png-transparent-basketball-jersey-basketball-ball-game-sport-orange.png', 'Pelota de Basquet', 11);
INSERT INTO `dbdataprint`.`productos` (`estadoPro`, `imageProp`,`nombrePro`, `categoria_id`) VALUES (true,'https://static.abc.es/media/familia/2018/11/28/regalos-kkSD--620x349@abc.jpg', 'Regalos de navidad', 12);



INSERT INTO `dbdataprint`.`caracteristicas` (`cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'Con tabla de multiplicar', '13.80', '1');
INSERT INTO `dbdataprint`.`caracteristicas` (`cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('3', 'ARTESCO - Negro', '5', '2');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('1', 'ARTESCO - MEDIANO', '9.5', '3');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('1', '18mm Con Grip', '10.80', '4');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('1', 'ALPHA - A4 Paquete x 500', '15', '5');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('4', 'pack 12 Tropical x 100 hojitas', '29.50', '6');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', '100% Italiano Hecho de Papel', '27.50', '7');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('3', 'Minimal 160pg', '30.90', '8');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('4', 'STABILO - Borrador Office Legacy', '1.80', '9');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('6', 'STABILO - Borrador Para examenes', '3.20', '10');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'PAPER MATE - Tipo lapicero', '5.30', '11');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'FABER CASTELL - Triangular 1210/B', '1.00', '12');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'ARTESCO - Rojo y Azul', '1.00', '13');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'FABER CASTELL - Barra Adhesiva por unidad', '2.00', '14');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'ARTESCO - Con dosificador', '2.20', '15');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'FABER CASTELL - Roja', '3.00', '16');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('5', 'Chikipedia', '8.00', '17');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('1', 'Chikipedia', '8.00', '18');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('8', 'blanco y marron', '20.00', '19');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('1', ' INTELIGENTE 2021 PARA HOMBRES Y MUJERES', '200.00', '20');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', ' Carton reciclado color amarillo', '10.00', '21');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('3', ' Tinta color azul', '25.00', '22');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('1', 'HP Pavilion Gaming 400', '35.00', '23');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'Color Negro', '89.90', '24');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'Color Negro, azul, amarillo y negro', '25.90', '25');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('10', 'Premium Cuadriculado A4 Rojo x 100 Hojas', '25.90', '26');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'Un aroma clásico, relajante y ligeramente herbal, pero masculino', '269.90', '27');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'TOILETTE HUGO BOSS BOTTLED UNLIMITED PARA HOMBRE 100 ML', '356.90', '28');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'Walon - color naranja', '65.90', '29');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'Winstar - Peso Medida Oficial – #7', '89.90', '30');
INSERT INTO `dbdataprint`.`caracteristicas` ( `cantidCaract`, `descriCaract`, `precioCaract`, `producto_id`) VALUES ('2', 'Regalos para los pequeños', '35.00', '31');




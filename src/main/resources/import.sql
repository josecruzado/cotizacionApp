INSERT INTO `users` (username, password, enabled) VALUES ('jose','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);
INSERT INTO `cotizacion` (`id`, `fecha`, `precio_equipos`, `precio_mano_obra`, `precio_materiales`, `precio_otros`, `sub_total`, `total_igv`, `utilidad_equipos`, `utilidad_materiales`, `cliente_id`, `usuario_id`) VALUES (NULL, '2021-05-05 12:00:29', '1000', '500', '1200', '400', '3100', '3680', '500', '200', '1', '1');
INSERT INTO `cliente` (`id`, `direccion`, `numero`, `razon_social`, `rubro`, `ruc`) VALUES (NULL, 'Miraflores', '9123214', 'Innova', 'Telecomunicaciones', '20482181997');

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');
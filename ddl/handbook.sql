INSERT INTO `role`( `name`) VALUES ('ADMIN');
INSERT INTO `role`( `name`) VALUES ('USER');

INSERT INTO `user`(`username`, `password`, `email`, `about`)
VALUES ('admin', '$2y$10$OzcebClrP0f56UDpFtfiZuEPBzN1HgPkBKpmtkeSWgAyp82v3s3CO', 'admin@admin.com', 'admin');

INSERT INTO `user`(`username`, `password`, `email`, `about`)
VALUES ('dusan', '$2y$10$OzcebClrP0f56UDpFtfiZuEPBzN1HgPkBKpmtkeSWgAyp82v3s3CO', 'dusan@dusan.com', 'regular_user');

INSERT INTO `user_role`(`role_fk`, `user_fk`) VALUES ('1','1');
INSERT INTO `user_role`(`role_fk`, `user_fk`) VALUES ('2','2');

INSERT INTO `pc`(`os`, `kernel`, `cpu`, `gpu`, `ram`, `user_fk`)
VALUES ('MANJARO OS', 'Linux 5.14.21-2', 'Intel Xeon E-2224G 4.7Ghz', 'Intel UHD 620', 24, 2);

INSERT INTO `category`(`name`) VALUES ('Kernel');
INSERT INTO `category`(`name`) VALUES ('Boot Loader/GRUB');
INSERT INTO `category`(`name`) VALUES ('Hardware Issues');
INSERT INTO `category`(`name`) VALUES ('Display Manager Issues');

INSERT INTO `post`(`user_fk`, `category_fk`, `pc_fk`, `title`, `body`, `upvotes`, `downvotes`)
VALUES (2, 3, 1, 'GeForce Graphics Issues', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 0, 0);

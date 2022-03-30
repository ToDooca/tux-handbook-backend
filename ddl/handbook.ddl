#create database if not exists `handbook`;
#use `handbook`;

set foreign_key_checks = 0;

drop table if exists `category`;
create table `category`
(
    `category_id`        int auto_increment primary key,
    `name`               varchar(64) not null unique,

    -- auditable
    `created_date`       timestamp   default current_timestamp(),
    `last_modified_by`   varchar(32) default 'system',
    `last_modified_date` timestamp   default current_timestamp(),
    `record_status`      int         default 1
) comment 'Linux issue category';

drop table if exists `role`;
create table `role`
(
    `role_id`            int auto_increment primary key,
    `name`               varchar(32) not null unique,

    -- auditable
    `created_date`       timestamp   default current_timestamp(),
    `last_modified_by`   varchar(32) default 'system',
    `last_modified_date` timestamp   default current_timestamp(),
    `record_status`      int         default 1
) comment 'User permissions';

drop table if exists `pc`;
create table `pc`
(
    `pc_id`             int auto_increment primary key,
    `os`                varchar(64) not null,
    `kernel`            varchar(64) not null,
    `cpu`               varchar(64) not null,
    `gpu`               varchar(64) not null,
    `ram`               int         not null,
    `user_fk`           int         not null,

    -- auditable
    `created_date`       timestamp   default current_timestamp(),
    `last_modified_by`   varchar(32) default 'system',
    `last_modified_date` timestamp   default current_timestamp(),
    `record_status`      int         default 1,

    constraint `fk_pc_user` foreign key (`user_fk`) references `user` (`user_id`)
        on update cascade on delete cascade
) comment 'User PC that the post applies for';

drop table if exists `user`;
create table `user`
(
    `user_id`            int auto_increment primary key,
    `username`           varchar(32)  not null,
    `password`           varchar(512) not null,
    `email`              varchar(32)  not null,
    `about`              text         null,
    `pc_fk`              int          null,

    -- auditable
    `created_date`       timestamp   default current_timestamp(),
    `last_modified_by`   varchar(32) default 'system',
    `last_modified_date` timestamp   default current_timestamp(),
    `record_status`      int         default 1,

    constraint `fk_user_pc` foreign key (`pc_fk`) references `pc` (`pc_id`)
        on update cascade on delete restrict
) comment 'User';

drop table if exists `post`;
create table `post`
(
    `post_id`            int auto_increment primary key,
    `user_fk`            int                                     null,
    `category_fk`        int                                     not null,
    `pc_fk`              int                                     not null,
    `title`              varchar(255)                            not null,
    `body`               text                                    not null,
    `upvotes`            int                                     not null,
    `downvotes`          int                                     not null,

    -- auditable
    `created_date`       timestamp   default current_timestamp(),
    `last_modified_by`   varchar(32) default 'system',
    `last_modified_date` timestamp   default current_timestamp(),
    `record_status`      int         default 1,

    constraint `fk_post_author` foreign key (`user_fk`) references `user` (`user_id`)
        on update cascade on delete set null,
    constraint `fk_post_category` foreign key (`category_fk`) references `category` (`category_id`)
        on update cascade on delete restrict,
    constraint `fk_post_pc` foreign key (`pc_fk`) references `pc` (`pc_id`)
        on update cascade on delete restrict
) comment 'Tutorial post';


drop table if exists `comment`;
create table `comment`
(
    `comment_id`         int  auto_increment primary key,
    `user_fk`            int                                     not null,
    `post_fk`            int                                     null,
    `pc_fk`              int                                     null,
    `body`               text                                    not null,
    `upvotes`            int                                     not null,
    `downvotes`          int                                     not null,
    `best_solution`      boolean                                 not null,

    -- auditable
    `created_date`       timestamp   default current_timestamp(),
    `last_modified_by`   varchar(32) default 'system',
    `last_modified_date` timestamp   default current_timestamp(),
    `record_status`      int         default 1,

    constraint `fk_post_comment` foreign key (`post_fk`) references `post` (`post_id`)
        on update cascade on delete cascade,
    constraint `fk_user_comment` foreign key (`user_fk`) references `user` (`user_id`)
        on update cascade on delete cascade,
    constraint `fk_comment_pc` foreign key (`pc_fk`) references `pc` (`pc_id`)
        on update cascade on delete restrict
) comment 'User comment on a post';

drop table if exists `user_role`;
create table `user_role`
(
    `role_fk` int not null,
    `user_fk` int not null,
    primary key (`role_fk`, `user_fk`),
    constraint fk_user_role_role foreign key (`role_fk`) references `role` (`role_id`)
        on update cascade on delete cascade,
    constraint fk_user_role_user foreign key (`user_fk`) references `user` (`user_id`)
        on update cascade on delete cascade
) comment 'Blog user or author';

set foreign_key_checks = 1;
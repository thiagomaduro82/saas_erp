-- describe the permissions table
create table permissions (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   name varchar(127) not null,
   description varchar(255) not null,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp
) ENGINE = innoDB default charset = utf8mb4;


-- describe the roles table
create table roles (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   name varchar(127) not null,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp
) ENGINE = innoDB default charset = utf8mb4;


-- describe the role_permissions table
create table role_permissions (
   id bigint unsigned not null primary key auto_increment,
   role_id bigint unsigned not null,
   permission_id bigint unsigned not null,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp,
   constraint `role_permissions_roles_fk` foreign key (`role_id`) references `roles` (`id`) on delete cascade,
   constraint `role_permissions_permissions_fk` foreign key (`permission_id`) references `permissions` (`id`)
) ENGINE = innoDB default charset = utf8mb4;


-- describe the users table
create table users (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   name varchar(127) not null,
   email varchar(255) not null unique,
   password varchar(255) not null,
   role_id bigint unsigned not null,
   active boolean,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp,
   constraint `users_roles_fk` foreign key (`role_id`) references `roles` (`id`)
) ENGINE = innoDB default charset = utf8mb4;


-- describe the contact_types table
create table contact_types (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   name varchar(127) not null,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp
) ENGINE = innoDB default charset = utf8mb4;


-- describe the country table
create table countries (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   name varchar(127) not null,
   code char(2) not null,
   currency char(3) not null,
   locale char(5) not null,
   state_required boolean default true,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp
) ENGINE = innoDB default charset = utf8mb4;


-- describe the timezone table
create table timezones (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   country_id bigint unsigned not null,
   name varchar(255) not null,
   utc_offset integer,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp,
   constraint `timezone_countries_fk` foreign key (`country_id`) references `countries` (`id`)
) ENGINE = innoDB default charset = utf8mb4;


-- describe the merchants table
create table merchants (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   name varchar(127) not null,
   email varchar(255) not null unique,
   country_id bigint unsigned not null,
   timezone_id bigint unsigned not null,
   verified boolean default false,
   blocked boolean default false,
   actived boolean default false,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp,
   constraint `merchants_countries_fk` foreign key (`country_id`) references `countries` (`id`),
   constraint `merchants_timezones_fk` foreign key (`timezone_id`) references `timezones` (`id`)
) ENGINE = innoDB default charset = utf8mb4;


-- describe the merchant_addresses table
create table merchant_addresses (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   merchant_id bigint unsigned not null,
   description varchar(127) not null,
   address_1 varchar(127) not null,
   address_2 varchar(127),
   address_3 varchar(127),
   county varchar(127) not null,
   city varchar(127) not null,
   zip_code varchar(15) not null,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp,
   constraint `merchant_addresses_merchants_fk` foreign key (`merchant_id`) references `merchants` (`id`)
) ENGINE = innoDB default charset = utf8mb4;


-- describe the merchant_contacts table
create table merchant_contacts (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   merchant_id bigint unsigned not null,
   contact_type_id bigint unsigned not null,
   value varchar(255) not null,
   person_name varchar(127) not null,
   description varchar(127) not null,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp,
   constraint `merchant_contacts_merchants_fk` foreign key (`merchant_id`) references `merchants` (`id`),
   constraint `merchant_contacts_contact_types_fk` foreign key (`contact_type_id`) references `contact_types` (`id`)
) ENGINE = innoDB default charset = utf8mb4;


-- describe the merchant_verified table
create table mechant_verified (
   id bigint unsigned not null primary key auto_increment,
   uuid char(13) not null unique,
   merchant_id bigint unsigned not null,
   token_generated char(13) not null,
   token_expired_at timestamp not null,
   created_at timestamp not null default current_timestamp,
   updated_at timestamp not null default current_timestamp on update current_timestamp,
   constraint `merchant_verified_merchants_fk` foreign key (`merchant_id`) references `merchants` (`id`)
) ENGINE = innoDB default charset = utf8mb4;


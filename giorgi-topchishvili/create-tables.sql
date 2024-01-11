create table BOOKING_ID_SEQ
(
    next_val bigint null
);

create table HOTELS
(
    CREATED_DATE datetime(6) null,
    ID           bigint not null primary key,
    UPDATED_DATE datetime(6) null,
    NAME         varchar(255) not null,
    RECORD_STATE enum ('ACTIVE', 'INACTIVE') null
);

create table HOTEL_ID_SEQ
(
    next_val bigint null
);

create table LOGS
(
    ID                      bigint       not null primary key,
    LOG_CREATION_DATE       datetime(6) null,
    METHOD_EXECUTION_MILLIS bigint       not null,
    CLASS_NAME              varchar(255) not null,
    METHOD_NAME             varchar(255) not null
);

create table LOG_ID_SEQ
(
    next_val bigint null
);

create table ROOMS
(
    IS_OCCUPIED  bit            not null,
    PRICE        decimal(38, 2) not null,
    CREATED_DATE datetime(6) null,
    HOTEL_ID     bigint         not null,
    ID           bigint         not null primary key,
    UPDATED_DATE datetime(6) null,
    RECORD_STATE enum ('ACTIVE', 'INACTIVE') null,
    constraint FK205giepeaf9e7b75i3j74fe6q
        foreign key (HOTEL_ID) references HOTELS (ID)
);

create table BOOKINGS
(
    PRICE        decimal(38, 2) not null,
    CREATED_DATE datetime(6) null,
    ID           bigint         not null
        primary key,
    ROOM_ID      bigint         not null,
    UPDATED_DATE datetime(6) null,
    VALID_UNTIL  datetime(6) not null,
    RECORD_STATE enum ('ACTIVE', 'INACTIVE') null,
    constraint FKh72o5nh3v124gmrm5bqdgfqbv
        foreign key (ROOM_ID) references ROOMS (ID)
);

create table ROOM_ID_SEQ
(
    next_val bigint null
);


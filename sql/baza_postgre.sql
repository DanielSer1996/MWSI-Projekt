/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     19.01.2018 22:52:42                          */
/*==============================================================*/


drop table ADRESS;

drop table CAR;

drop table CAR_REVIEW;

drop table CRIMINAL_RECORDS;

drop table CRIMINAL_RECORDS_DICTIONARY;

drop table DRIVER;

drop table DRIVER_CAR_REL;

drop table DRIVING_LICENSE;

drop table DRIVING_LICENSE_CATEGORY_REL;

drop table INSURANCE;

drop table LICENSE_CATEGORY;

/*==============================================================*/
/* Table: ADRESS                                                */
/*==============================================================*/
create table ADRESS (
   ADRESS_ID            INT8                 not null,
   ADRESS_LOCALITY      VARCHAR(100)         null,
   ADRESS_STREET        VARCHAR(100)         null,
   ADRESS_ZIPCODE       VARCHAR(6)           null,
   ADRESS_VOIVODESHIP   VARCHAR(100)         null,
   ADRESS_STREET_NUMBER NUMERIC(8,0)         null,
   ADRESS_APARTMENT_NUMBER NUMERIC(8,0)         null,
   constraint PK_ADRESS primary key (ADRESS_ID)
);

/*==============================================================*/
/* Table: CAR                                                   */
/*==============================================================*/
create table CAR (
   CAR_VIN              VARCHAR(17)          not null,
   INSURANCE_ID         INT8                 not null,
   CAR_MAKE             VARCHAR(100)         null,
   CAR_MODEL            VARCHAR(100)         null,
   CAR_REGISTRATION_NUMBER VARCHAR(10)          null,
   constraint PK_CAR primary key (CAR_VIN)
);

/*==============================================================*/
/* Table: CAR_REVIEW                                            */
/*==============================================================*/
create table CAR_REVIEW (
   CAR_VIN              VARCHAR(17)          not null,
   REVIEW_ID            INT8                 not null,
   REVIEW_DATE          DATE                 null,
   REVIEW_EXPIRE_DATE   DATE                 null,
   REVIEW_COMMENTS      VARCHAR(500)         null,
   constraint PK_CAR_REVIEW primary key (REVIEW_ID)
);

/*==============================================================*/
/* Table: CRIMINAL_RECORDS                                      */
/*==============================================================*/
create table CRIMINAL_RECORDS (
   DRIVER_ID            INT8                 not null,
   RECORD_ID            INT8                 not null,
   CR_DICTIONARY_ID     INT8                 not null,
   constraint PK_CRIMINAL_RECORDS primary key (RECORD_ID)
);

/*==============================================================*/
/* Table: CRIMINAL_RECORDS_DICTIONARY                           */
/*==============================================================*/
create table CRIMINAL_RECORDS_DICTIONARY (
   CR_DICTIONARY_ID     INT8                 not null,
   CR_DICTIONARY_TYPE   VARCHAR(300)         null,
   CR_DICTIONARY_POINTS NUMERIC(8,0)         null,
   constraint PK_CRIMINAL_RECORDS_DICTIONARY primary key (CR_DICTIONARY_ID)
);

/*==============================================================*/
/* Table: DRIVER                                                */
/*==============================================================*/
create table DRIVER (
   DRIVER_ID            INT8                 not null,
   ADRESS_ID            INT8                 null,
   LICENSE_ID           INT8                 null,
   DRIVER_PESEL         VARCHAR(11)          null,
   DRIVER_NAME          VARCHAR(100)         null,
   DRIVER_SURNAME       VARCHAR(100)         null,
   DRIVER_BIRTH_DATE    DATE                 null,
   constraint PK_DRIVER primary key (DRIVER_ID)
);

/*==============================================================*/
/* Table: DRIVER_CAR_REL                                        */
/*==============================================================*/
create table DRIVER_CAR_REL (
   DRIVER_ID            INT8                 not null,
   CAR_VIN              VARCHAR(17)          not null
);

/*==============================================================*/
/* Table: DRIVING_LICENSE                                       */
/*==============================================================*/
create table DRIVING_LICENSE (
   LICENSE_ID           INT8                 not null,
   EXPIRE_DATE          DATE                 null,
   ISSUE_DATE           DATE                 null,
   IS_SUSPENDED         BOOL                 null,
   LICENSE_NO           VARCHAR(8)           null,
   constraint PK_DRIVING_LICENSE primary key (LICENSE_ID)
);

/*==============================================================*/
/* Table: DRIVING_LICENSE_CATEGORY_REL                          */
/*==============================================================*/
create table DRIVING_LICENSE_CATEGORY_REL (
   LICENSE_ID           INT8                 not null,
   CATEGORY_ID          INT8                 not null
);

/*==============================================================*/
/* Table: INSURANCE                                             */
/*==============================================================*/
create table INSURANCE (
   INSURANCE_ID         INT8                 not null,
   INSURANCE_BEGIN_DATE DATE                 null,
   INSURANCE_EXPIRE_DATE DATE                 null,
   INSURANCE_TYPE       VARCHAR(100)         null,
   constraint PK_INSURANCE primary key (INSURANCE_ID)
);

/*==============================================================*/
/* Table: LICENSE_CATEGORY                                      */
/*==============================================================*/
create table LICENSE_CATEGORY (
   CATEGORY_ID          INT8                 not null,
   CATEGORY_TYPE        VARCHAR(5)           null,
   CATEGORY_DESCRIPTION VARCHAR(200)         null,
   constraint PK_LICENSE_CATEGORY primary key (CATEGORY_ID)
);

alter table CAR
   add constraint FK_CAR_RELATIONS_INSURANC foreign key (INSURANCE_ID)
      references INSURANCE (INSURANCE_ID)
      on delete restrict on update restrict;

alter table CAR_REVIEW
   add constraint FK_CAR_REVI_RELATIONS_CAR foreign key (CAR_VIN)
      references CAR (CAR_VIN)
      on delete restrict on update restrict;

alter table CRIMINAL_RECORDS
   add constraint FK_CRIMINAL_RELATIONS_CRIMINAL foreign key (CR_DICTIONARY_ID)
      references CRIMINAL_RECORDS_DICTIONARY (CR_DICTIONARY_ID)
      on delete restrict on update restrict;

alter table CRIMINAL_RECORDS
   add constraint FK_CRIMINAL_RELATIONS_DRIVER foreign key (DRIVER_ID)
      references DRIVER (DRIVER_ID)
      on delete restrict on update restrict;

alter table DRIVER
   add constraint FK_DRIVER_RELATIONS_DRIVING_ foreign key (LICENSE_ID)
      references DRIVING_LICENSE (LICENSE_ID)
      on delete restrict on update restrict;

alter table DRIVER
   add constraint FK_DRIVER_RELATIONS_ADRESS foreign key (ADRESS_ID)
      references ADRESS (ADRESS_ID)
      on delete restrict on update restrict;

alter table DRIVER_CAR_REL
   add constraint FK_DRIVER_C_RELATIONS_CAR foreign key (CAR_VIN)
      references CAR (CAR_VIN)
      on delete restrict on update restrict;

alter table DRIVER_CAR_REL
   add constraint FK_DRIVER_C_RELATIONS_DRIVER foreign key (DRIVER_ID)
      references DRIVER (DRIVER_ID)
      on delete restrict on update restrict;

alter table DRIVING_LICENSE_CATEGORY_REL
   add constraint FK_DRIVING__RELATIONS_DRIVING_ foreign key (LICENSE_ID)
      references DRIVING_LICENSE (LICENSE_ID)
      on delete restrict on update restrict;

alter table DRIVING_LICENSE_CATEGORY_REL
   add constraint FK_DRIVING__RELATIONS_LICENSE_ foreign key (CATEGORY_ID)
      references LICENSE_CATEGORY (CATEGORY_ID)
      on delete restrict on update restrict;

create table hibernate_sequences(
   sequence_next_hi_value BIGINT,
   sequence_name VARCHAR(32)
);

INSERT INTO hibernate_sequences
    VALUES (1,'CRIMINAL_RECORDS');
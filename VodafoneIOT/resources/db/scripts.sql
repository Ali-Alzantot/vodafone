---- this file contains required scripts to run the project ------


----  create Schema this requires to be run from your db local admin ------
CREATE USER vodafone_iot IDENTIFIED BY "vodafone_iot";
GRANT UNLIMITED TABLESPACE TO vodafone_iot;
GRANT ALL PRIVILEGES TO vodafone_iot;
GRANT CREATE SESSION TO vodafone_iot;
GRANT dba TO vodafone_iot;

----  create table DEVICE_STATUS ------
CREATE TABLE vodafone_iot.DEVICE_STATUS
(
ID NUMBER NOT NULL
, CODE VARCHAR2(100) NOT NULL
, CONSTRAINT STATUS_PK PRIMARY KEY
(ID) ENABLE
);

----  insert DEVICE_STATUS lookup data  ------
INSERT INTO vodafone_iot.DEVICE_STATUS (ID, CODE) VALUES ('1', 'ACTIVE');
INSERT INTO vodafone_iot.DEVICE_STATUS (ID, CODE) VALUES ('2', 'WAITING_FOR_ACTIVATION');
INSERT INTO vodafone_iot.DEVICE_STATUS (ID, CODE) VALUES ('3', 'BLOCKED');
INSERT INTO vodafone_iot.DEVICE_STATUS (ID, CODE) VALUES ('4', 'DEACTIVATED');
INSERT INTO vodafone_iot.DEVICE_STATUS (ID, CODE) VALUES ('5', 'READY');

----  create SIM table ------
CREATE TABLE vodafone_iot.SIM
(
ID NUMBER NOT NULL,
OPERATOR_CODE VARCHAR2(20) NOT NULL,
COUNTRY VARCHAR2(100) NOT NULL,
DEVICE_STATUS_ID NUMBER,
CONSTRAINT SIM_PK PRIMARY KEY
(ID) ENABLE,
CONSTRAINT DEVICE_STATUS_FK FOREIGN KEY (DEVICE_STATUS_ID)
REFERENCES vodafone_iot.DEVICE_STATUS (ID) ENABLE
);

----  create DEVICE table ------
CREATE TABLE vodafone_iot.DEVICE
(
ID NUMBER NOT NULL,
temperature number NOT NULL,
SIM_ID NUMBER,
CONSTRAINT DEVICE_PK PRIMARY KEY
(ID) ENABLE,
CONSTRAINT SIM_FK FOREIGN KEY (SIM_ID)
REFERENCES vodafone_iot.SIM (ID) ENABLE
);

----  insert dummy data for testing in SIM table   ------
INSERT INTO vodafone_iot.SIM (ID, OPERATOR_CODE, COUNTRY, DEVICE_STATUS_ID) VALUES ('1', '602', 'EGPYT', 1);
INSERT INTO vodafone_iot.SIM (ID, OPERATOR_CODE, COUNTRY, DEVICE_STATUS_ID) VALUES ('2', '602', 'EGPYT', 2);
INSERT INTO vodafone_iot.SIM (ID, OPERATOR_CODE, COUNTRY, DEVICE_STATUS_ID) VALUES ('3', '602', 'EGPYT', 3);
INSERT INTO vodafone_iot.SIM (ID, OPERATOR_CODE, COUNTRY, DEVICE_STATUS_ID) VALUES ('4', '602', 'EGPYT', 4);
INSERT INTO vodafone_iot.SIM (ID, OPERATOR_CODE, COUNTRY, DEVICE_STATUS_ID) VALUES ('5', '602', 'EGPYT', 5);

----  insert dummy data for testing in DEVICE table   ------
INSERT INTO vodafone_iot.DEVICE (ID, temperature, SIM_ID) VALUES ('1', 80, 5);
INSERT INTO vodafone_iot.DEVICE (ID, temperature, SIM_ID) VALUES ('2', 90, 2);
INSERT INTO vodafone_iot.DEVICE (ID, temperature, SIM_ID) VALUES ('3', 70, 2);
INSERT INTO vodafone_iot.DEVICE (ID, temperature, SIM_ID) VALUES ('4', 60, 1);
INSERT INTO vodafone_iot.DEVICE (ID, temperature, SIM_ID) VALUES ('5', 65, 3);

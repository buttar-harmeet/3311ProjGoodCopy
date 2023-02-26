create database feedback;
use feedback;

CREATE TABLE project5 (
        REF_DATE varchar(15) NOT NULL,
        GEO VARCHAR(100) NOT NULL,
        DGUID VARCHAR(30) NOT NULL,
        NHPI VARCHAR(100) NOT NULL,
        UOM VARCHAR(100) NOT NULL,
        UOM_ID VARCHAR(40) NOT NULL,
        SCALAR_FACTOR VARCHAR(40) NOT NULL,
        SCALAR_ID VARCHAR(30) NOT NULL,
        VECTOR VARCHAR(30) NOT NULL,
        COORDINATE DOUBLE(4, 1) NOT NULL,
        VAL varchar(10),
        STAT VARCHAR(10)
    );

SELECT *
FROM project5;

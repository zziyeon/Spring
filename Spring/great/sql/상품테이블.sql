drop table product_info;
--��ǰ ���̺� ����
create table product_info(
    P_NUMBER NUMBER(30, 0)
,    OWNER_NUMBER NUMBER(6, 0)
,   STORE_NAME VARCHAR2(30 BYTE)
,    P_TITLE VARCHAR2(300 BYTE)
,    P_NAME VARCHAR2(30 BYTE)
,    DEADLINE_TIME DATE
,    CATEGORY VARCHAR2(17 BYTE)
,    TOTAL_COUNT NUMBER(5, 0)
,    REMAIN_COUNT NUMBER(5, 0)
,    NORMAL_PRICE NUMBER(8, 0)
,    SALE_PRICE NUMBER(8, 0)
,    DISCOUNT_RATE NUMBER(20, 0)
,    PAYMENT_OPTION VARCHAR2(32 BYTE)
,    DETAIL_INFO VARCHAR2(4000 BYTE)
,    R_DATE DATE default sysdate
,    U_DATE DATE default sysdate
,    P_STATUS NUMBER(1, 0)
);

--�⺻Ű ����
ALTER TABLE PRODUCT_INFO ADD CONSTRAINT product_info_p_id_pk PRIMARY key(p_NUMBER);

drop sequence PRODUCT_P_NUMBER_SEQ;
-- ��ǰ��ȣ ������ ����
create sequence PRODUCT_P_NUMBER_SEQ;
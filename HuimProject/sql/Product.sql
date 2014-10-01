CREATE TABLE PRODUCT 
(
  PRO_CODE VARCHAR2(6 BYTE) NOT NULL 
, PRO_NAME VARCHAR2(50 BYTE) NOT NULL 
, PRO_SIZE VARCHAR2(10 BYTE) NOT NULL 
, PRO_PRICE NUMBER NOT NULL 
, PRO_DISCOUNT_RATE NUMBER NOT NULL 
, PRO_SELL_COUNT NUMBER NOT NULL 
, PRO_STOCK NUMBER NOT NULL 
, PRO_COMPANY VARCHAR2(30 BYTE) NOT NULL 
, PRO_REG_DATE DATE NOT NULL 
, PRO_IMG VARCHAR2(20 BYTE) NOT NULL 
, PRO_CATEGORY VARCHAR2(20 BYTE) 
, PRO_DETAIL VARCHAR2(100 BYTE) NOT NULL 
, CONSTRAINT PRODUCT_PK PRIMARY KEY 
  (
    PRO_CODE 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX PRODUCT_PK ON PRODUCT (PRO_CODE ASC) 
      LOGGING 
      TABLESPACE SYSTEM 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        FREELISTS 1 
        FREELIST GROUPS 1 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE SYSTEM 
PCTFREE 10 
PCTUSED 40 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  FREELISTS 1 
  FREELIST GROUPS 1 
  BUFFER_POOL DEFAULT 
) 
NOCOMPRESS;

COMMENT ON COLUMN PRODUCT.PRO_CODE IS '상품의 코드';

COMMENT ON COLUMN PRODUCT.PRO_NAME IS '상품의 이름';

COMMENT ON COLUMN PRODUCT.PRO_SIZE IS '상품의 사이즈';

COMMENT ON COLUMN PRODUCT.PRO_PRICE IS '상품의 기본가격';

COMMENT ON COLUMN PRODUCT.PRO_DISCOUNT_RATE IS '상품의 할인율';

COMMENT ON COLUMN PRODUCT.PRO_SELL_COUNT IS '상품의 판매량';

COMMENT ON COLUMN PRODUCT.PRO_STOCK IS '상품의 재고량';

COMMENT ON COLUMN PRODUCT.PRO_COMPANY IS '상품의 제조사';

COMMENT ON COLUMN PRODUCT.PRO_REG_DATE IS '상품의 입력일자';

COMMENT ON COLUMN PRODUCT.PRO_IMG IS '상품의 이미지경로';

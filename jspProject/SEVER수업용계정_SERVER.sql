--�α��� ��û �� ���� �� sql��
SELECT
      USER_NO
    , USER_ID
    , USER_PWD
    , USER_NAME
    , PHONE
    , EMAIL
    , ADDRESS
    , interest
    , ENROLL_DATE
    , MODIFY_DATE
    , STATUS
FROM MEMBER
WHERE USER_ID =?
AND USER_PWD =?
AND STATUS = 'Y';

INSERT
 INTO MEMBER
 (
     USER_NO
   , USER_ID
   , USER_PWD
   , USER_NAME
   , PHONE
   , EMAIL
   , ADDRESS
   , INTEREST
   )
   VALUES
   (
     SEQ_UNO.NEXTVAL
     , ?
     , ?
     , ?
     , ?
     , ?
     , ?
     , ?
   )
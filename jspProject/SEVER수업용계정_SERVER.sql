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
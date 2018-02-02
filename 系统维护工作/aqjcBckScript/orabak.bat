SET DESDIR=E:\aqjcBack\DBdata
FOR /F "TOKENS=1,2,3 DELIMS=/ " %%i IN ('DATE /T') DO SET d=%%i-%%j-%%k
cd /d %DESDIR%
del sbgl%d%.EXPDP
rem start back database ...  fileFormat:sbglYYYYMMDD.expdp

expdp sbgl/sbgl@orcl directory=bck_dir dumpfile=sbgl%d%.EXPDP schemas=sbgl

::将备份好的文件拷贝到远程服务器中
SET REMOTEDESPATH=\\192.168.33.1\e$\aqjcBack\DBdata\
SET SRCPATH=sbgl%d%.EXPDP
XCOPY %SRCPATH% %REMOTEDESPATH% /S /Y 


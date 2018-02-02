@ECHO OFF
SET SRCPATH=D:\project\myApp\aqjc\uploads
SET DESPATH=E:\aqjcBack\appData\
FOR /F "TOKENS=1,2,3 DELIMS=/ " %%i IN ('DATE /T') DO SET d=%%i-%%j-%%k
SET DESDIR=uploads%d%
MKDIR %DESPATH%%DESDIR%
XCOPY %SRCPATH% %DESPATH%%DESDIR% /S /Y

::将备份好的文件拷贝到远程服务器中
SET REMOTEDESPATH=\\192.168.33.1\e$\aqjcBack\appData\
MKDIR %REMOTEDESPATH%%DESDIR%
XCOPY %SRCPATH% %REMOTEDESPATH%%DESDIR% /S /Y
ECHO ON
rem Pause
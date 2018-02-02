@ECHO OFF
SET SRCPATH=D:\"Apache Software Foundation"\apache-tomcat-7.0.63\webapps\aqjc\uploads
SET DESPATH=D:\test\dump\
FOR /F "TOKENS=1,2,3 DELIMS=/ " %%i IN ('DATE /T') DO SET d=%%i-%%j-%%k
SET DESDIR=uploads%d%
MKDIR %DESPATH%%DESDIR%
XCOPY %SRCPATH% %DESPATH%%DESDIR% /S
ECHO ON
rem Pause
SET DESDIR=D:\expdp
FOR /F "TOKENS=1,2,3 DELIMS=/ " %%i IN ('DATE /T') DO SET d=%%i-%%j-%%k
cd /d %DESDIR%
del sbgl%d%.EXPDP
rem start back database ...  fileFormat:sbglYYYYMMDD.expdp

expdp sbgl/sbgl@orcl directory=pump_dir dumpfile=sbgl%d%.EXPDP schemas=sbgl nologfile=y


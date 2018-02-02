//查看服务器的连接情况，容易报错：ORA—12518

//146
select count(*)  from v$session; 
//252
select value from v$parameter where name='sessions';
//149
select count(*) from v$process;
//150
select value from v$parameter where name='processes';

//process shu = session shu *1.1 + 5;

//调整参数大小

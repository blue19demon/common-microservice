@echo off & title zookeeper-server

:main
call :startZookeeper
goto :EOF


rem Æô¶¯zookeeper
:startZookeeper
color 0a
call F:\softs\zookeeper-3.4.14.tar\zookeeper-3.4.14\zookeeper-3.4.14\bin\zkServer.cmd
echo;
pause;


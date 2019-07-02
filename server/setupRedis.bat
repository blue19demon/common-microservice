@echo off

:main
call :startRedis
goto :EOF

rem Æô¶¯redis
:startRedis
@echo off
title redis-server
color 0a
call F:\softs\redis-64.3.0.503\redis-server.exe

echo;
pause;



@echo off & title rabbtimq-server

:main
call :setupRabbtimq
goto :EOF


rem Æô¶¯rabbtimq
:setupRabbtimq
color 0a
start cmd /k "C:\Program Files\RabbitMQ Server\rabbitmq_server-3.6.5\sbin\rabbitmq-server.bat"
echo;
pause;


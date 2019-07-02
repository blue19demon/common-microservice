@echo off & title 发布jhzb-web版本
:main

set current_path="%cd%"
rem 大平台项目根目录
set project_provder_path=%current_path%all-platform
rem jhzb-web项目根目录
set project_web_path=%current_path%SVN-jhzb-web


set project=jhzb-web
echo 当前发版：%project%
call :deployJhzbWeb
echo ===========发布到服务器完成=========
goto :EOF

rem 发版jhzb-web
:deployJhzbWeb
@echo off
echo ===========jhzb-web发布到服务器开始=========
cd %project_web_path%\jhzb-web
echo 进行maven打包操作
call mvn clean package -Dmaven.test.skip=true
echo Maven工程打包完毕
cd target
echo 延迟1秒启动服务
call java -jar jhzb-web.jar sleep(1000)
echo;
pause


rem 发版member-core
:deployMemberCore
@echo off
echo ===========member-core发布到服务器开始=========
cd %project_provder_path%\member\trunk\member-api 
echo 进行maven打包操作
call mvn clean install
echo Maven工程打包完毕 延迟1秒启动服务
cd %project_provder_path%\member\trunk\member-core
sleep(1000)
call mvn clean jetty:run -Djetty.port=15083
echo;
pause


rem 发版website
:deployWebsite
@echo off
echo ===========website发布到服务器开始=========
cd %project_provder_path%\website\trunk 
call mvn clean jetty:run -Djetty.port=9094
echo;
pause


@echo off

:main
set current_path="%cd%"
rem jhzb-web项目根目录
set project_web_path=%current_path%\SVN-jhzb-web
call :downloadFromSvn
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
call java -jar jhzb-web.war sleep(1000)
echo;
pause;

rem 从svn拉取代码下来
:downloadFromSvn
@echo off
echo ===========从svn拉取代码开始=========
cd F:\SVN-jhzb-web

cd jhzb-web
svn update;
echo ===========从svn拉取代码完成=========
call :deployJhzbWeb
echo;
pause;


@echo off
setlocal enableextensions
pushd %~dp0

cd ..
call gradlew clean shadowJar

# 确保data目录存在
if not exist data mkdir data

cd build\libs
for /f "tokens=*" %%a in (
    'dir /b *.jar'
) do (
    set jarloc=%%a
)

# 使用绝对路径确保data目录被正确创建
java -jar %jarloc% < ..\..\text-ui-test\input.txt > ..\..\text-ui-test\ACTUAL.TXT

cd ..\..\text-ui-test

echo Actual output:
type ACTUAL.TXT
echo.
echo Expected output:
type EXPECTED.TXT
echo.

FC ACTUAL.TXT EXPECTED.TXT >NUL
if errorlevel 1 (
    echo Test failed! Differences found:
    FC ACTUAL.TXT EXPECTED.TXT
) else (
    echo Test passed!
)
@echo off

echo Killing the process...
net stop mmpc 2> nul
for /L %%i in (0, 0, 1) do (
    for %%p in (Ctsc_Multi.exe,DeviceControl_x64.exe,HRMon.exe,MultiClient.exe,OActiveII-Client.exe,OEClient.exe,OELogSystem.exe,OEUpdate.exe,OEProtect.exe,ProcessProtect.exe,RunClient.exe,RunClient.exe,ServerOSS.exe,Student.exe,wfilesvr.exe,tvnserver.exe,updatefilesvr.exe,ScreenRender.exe,StudentMain.exe) do (
        taskkill /F /T /IM "%%p" 2> nul
    )
)

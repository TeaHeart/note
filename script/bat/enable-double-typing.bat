@echo off
chcp 65001
reg add "HKEY_CURRENT_USER\SOFTWARE\Microsoft\InputMethod\Settings\CHS" /v "Enable Double Pinyin" /t REG_DWORD /f /d 1
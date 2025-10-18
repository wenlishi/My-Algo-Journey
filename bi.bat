@echo off
setlocal enabledelayedexpansion

for /d %%i in (*) do (
    set "oldname=%%i"
    set "newname=!oldname!"
    
    # 这里可以添加具体的重命名逻辑
    # 例如：将文件夹名转换为小写
    echo 重命名: !oldname! → !newname!
    git mv "!oldname!" "!oldname!-temp"
    git mv "!oldname!-temp" "!newname!"
)

pause
@echo off
REM SOLID Principles Refactoring - Compilation Verification Script
REM This script verifies that all 6 examples compile successfully

cd /d "%~dp0"

echo.
echo ========================================
echo   SOLID Principles Refactoring Checker
echo ========================================
echo.

setlocal enabledelayedexpansion

set "exercises=1 2 3 4 5 6"
set "success=0"
set "total=6"

for %%E in (%exercises%) do (
    echo [Checking Ex%%E]
    cd SOLID\Ex%%E\src
    
    REM Check if Demo0%%E.java exists
    if exist Demo0%%E.java (
        echo   ✓ Demo0%%E.java found
        
        REM Try to compile (requires javac in PATH)
        echo   Attempting compilation...
        javac *.java >nul 2>&1
        
        if !errorlevel! equ 0 (
            echo   ✓ Compilation successful
            set /A "success+=1"
        ) else (
            echo   ✗ Compilation failed (check JDK installation)
        )
    ) else (
        echo   ✗ Demo0%%E.java NOT found
    )
    
    cd ..\..\..\
    echo.
)

echo ========================================
echo   Summary: %success%/%total% exercises compiled
echo ========================================
echo.

if %success% equ %total% (
    echo All exercises are ready for submission!
    exit /b 0
) else (
    echo Some exercises need attention.
    exit /b 1
)

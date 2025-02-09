function Base {
    set-executionpolicy remotesigned # 允许脚本
    powercfg -duplicatescheme e9a42b02-d5df-448d-aa00-03f14749eb61 # 电源计划 卓越性能
}

function Fast-Copy {
    param (
        [Parameter(Mandatory)] [ValidateNotNullOrEmpty()] [string] $src,
        [Parameter(Mandatory)] [ValidateNotNullOrEmpty()] [string] $dest,
        [ValidateNotNullOrEmpty()] [string] $base = (Get-Location),
        [ValidateNotNullOrEmpty()] [int] $cpus = (Get-WmiObject win32_processor).NumberOfLogicalProcessors / 2
    )
    $src = Resolve-Path $src
    $dest = Resolve-Path $dest
    $base = Resolve-Path $base
    if (Test-Path -PathType Leaf $src) {
        throw "请输入文件夹"
    }
    Get-ChildItem -Recurse $src | ForEach-Object -Parallel {
        $df = Join-Path $using:dest $_.FullName.Substring($using:base.Length)
        Write-Host -NoNewline $_" => "
        Copy-Item $_ $df
        Write-Host $df
    } -ThrottleLimit $cpus
}

# TODO 重构
function eBookConvert {
    param (
        [Parameter(Mandatory)] [ValidateNotNullOrEmpty()] [string] $base,
        [ValidateNotNullOrEmpty()] [string] $dest = ".\output\",
        [Parameter(ValueFromPipeline)] [ValidateNotNullOrEmpty()] [System.IO.FileSystemInfo[]] $files = (Get-ChildItem -Recurse $base),
        [ValidateNotNullOrEmpty()] [int]$cpus = ((Get-WmiObject win32_processor).NumberOfLogicalProcessors),
        [ValidateNotNullOrEmpty()] [string] $srcExt = ".epub",
        [ValidateNotNullOrEmpty()] [string] $destExt = ".pdf",
        [ValidateNotNullOrEmpty()] [string] $exec = 'ebook-convert.exe "{0}" "{1}"',
        [ValidateNotNullOrEmpty()] [switch] $quiet = $false
    )
    # 官网 https://www.calibre-ebook.com/zh_CN
    function WaitJob {
        param (
            [int]$limit = 1,
            [int]$sleep = 3
        )
        while ((Get-Job -State Running).Length -ge $limit) {
            Get-Job -State Running | Format-Table
            Start-Sleep $sleep
        }
    }
    mkdir -ErrorAction SilentlyContinue $dest | Out-Null
    $base = Join-Path $base "\" | Resolve-Path
    $dest = Join-Path $dest "\" | Resolve-Path
    for ($i = 0; $i -lt $files.Length; $i++) {
        $file = $files[$i]
        $sf = $file.FullName
        $df = Join-Path $dest $sf.Substring($base.Length)
        $type = "~"
        if ($file -is [System.IO.DirectoryInfo]) {
            mkdir -ErrorAction SilentlyContinue $df | Out-Null
            $type = "+"
        }
        elseif ($file.Extension -eq $srcExt) {
            WaitJob $cpus
            $df = $df.Replace($srcExt, $destExt)
            Start-Job -Name $file.BaseName -ArgumentList $exec, $sf, $df {
                cmd /c ([string]::Format($args[0], $args[1], $args[2]))
            } | Out-Null
            $type = "&"
        }
        if (!$quiet) {
            Write-Host "$i/$($files.Length) $type $df"
        }
    }
    WaitJob
    Receive-Job * | Out-Null
    Remove-Job -State Completed
}

# TODO 重构 拆分
function HashCompare {
    param (
        [Parameter(Mandatory)] [ValidateNotNullOrEmpty()] [string] $dir,
        [ValidateNotNullOrEmpty()] [string] $algorithm = "length",
        [ValidateNotNullOrEmpty()] [string] $out = ".\$algorithm.json",
        [Parameter(ValueFromPipeline)] [ValidateNotNullOrEmpty()] [System.IO.FileSystemInfo[]] $files = (Get-ChildItem -File -Recurse $dir),
        [ValidateNotNullOrEmpty()] [switch] $quiet = $false
    )
    $dir = Join-Path $dir "\" | Resolve-Path
    if (Test-Path($out)) {
        $out = $out | Resolve-Path
        $map = @{}
        (Get-Content $out -Encoding UTF8 | ConvertFrom-Json) | ForEach-Object { $map[$_.Path] = $_ }
        0..($files.Length - 1) | ForEach-Object {
            $f = $files[$_]
            $actual = @{}
            $actual.Path = $f.FullName.Substring("$dir".Length)
            $actual.Length = $f.Length
            $expected = $map[$actual.Path]
            if (!$quiet) {
                Write-Host "$($_)/$($files.Length) + $($actual.Path)"
            }
            if ($expected.Length -ne $actual.Length -or (($algorithm -ne "length") -and ($expected.Hash -ne ($actual.Hash = (Get-FileHash -Algorithm $algorithm "$($f.FullName)").Hash)))) {
                Write-Error "$($actual.Path)`n`tExpected: $($expected.Length) $($expected.Hash)`n`tActual  : $($actual.Length) $($actual.Hash)"
            }
        }
    } else {
        0..($files.Length - 1) | ForEach-Object {
            $f = $files[$_]
            $info = @{}
            $info.Path = $f.FullName.Substring("$dir".Length)
            $info.Length = $f.Length
            if (!$quiet) {
                Write-Host "$($_)/$($files.Length) + $($info.Path)"
            }
            if ($algorithm -ne "length") {
                $info.Hash = (Get-FileHash -Algorithm $algorithm "$($f.FullName)").Hash
            }
            return $info
        } | ConvertTo-Json | Out-File -Encoding UTF8 $out
        Write-Host "+ $out"
    }
}

function VisualStudio-Download-All {
    .\vs_Enterprise.exe `
        --layout .\vs_Enterprise\ <# 路径 #> `
        --all <# 全部负载 #>`
        --lang en-US zh-CN <# 语言包 #>
}

function MD5-Checker {
    param (
        [ValidateNotNullOrEmpty()] [string] $MD5File = ".\*.md5",
        [ValidateNotNullOrEmpty()] [int] $cpus = (Get-WmiObject win32_processor).NumberOfLogicalProcessors / 2
    )
    Get-Content $MD5File | ForEach-Object -Parallel {
        $line = $_.Split(" *") # 格式: `MD5 *FILE`
        $hash = (Get-FileHash -Algorithm MD5 $line[1]).Hash
        Write-Host $line[1] $line[0] ($line[0] -ieq $hash ? "==" : "!=") $hash
    } -ThrottleLimit $cpus
}

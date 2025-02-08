function Base {
    set-executionpolicy remotesigned
    powercfg -duplicatescheme e9a42b02-d5df-448d-aa00-03f14749eb61
}

function CopyItem {
    param (
        [Parameter(Mandatory)] [ValidateNotNullOrEmpty()] [string] $base,
        [ValidateNotNullOrEmpty()] [string] $dest = ".\output\",
        [Parameter(ValueFromPipeline)] [ValidateNotNullOrEmpty()] [System.IO.FileSystemInfo[]] $files = (Get-ChildItem -Recurse $base),
        [ValidateNotNullOrEmpty()] [string] $replace = $null,
        [ValidateNotNullOrEmpty()] [switch] $quiet = $false
    )
    mkdir -ErrorAction SilentlyContinue $dest | Out-Null
    $base = Join-Path $base "\" | Resolve-Path
    $dest = Join-Path $dest "\" | Resolve-Path
    for ($i = 0; $i -lt $files.Length; $i++) {
        $sf = $files[$i].FullName
        $df = $sf.Substring($base.Length)
        if (![string]::IsNullOrEmpty($replace)) {
            $df = $df.Replace("\", $replace)
        }
        $df = Join-Path $dest $df
        Copy-Item "$sf" "$df"
        if (!$quiet) {
            Write-Host "$i/$($files.Length) + $df"
        }
    }
}

function RemoveItem {
    param (
        [Parameter(Mandatory)] [ValidateNotNullOrEmpty()] [string] $base,
        [ValidateNotNullOrEmpty()] [string] $dest = $base,
        [Parameter(ValueFromPipeline)] [ValidateNotNullOrEmpty()] [System.IO.FileSystemInfo[]] $files = (Get-ChildItem -Recurse $base),
        [ValidateNotNullOrEmpty()] [switch] $quiet = $false
    )
    $base = Join-Path $base "\" | Resolve-Path
    $dest = Join-Path $dest "\" | Resolve-Path
    $files = $files | Sort-Object -Descending { $_.FullName.Length }
    for ($i = 0; $i -lt $files.Length; $i++) {
        $sf = $files[$i].FullName
        $df = Join-Path $dest $sf.Substring($base.Length)
        Remove-Item "$df"
        if (!$quiet) {
            Write-Host "$i/$($files.Length) - $df"
        }
    }
    if ($base -eq $dest) {
        Remove-Item "$base"
    }
}

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

function VisualStudioInstallAll {
    .\vs_Enterprise.exe `
        --layout .\vs_Enterprise\ <# 路径 #> `
        --all `
        --lang en-US zh-CN <# 语言包 #>
}

function HashCheck {
    param (
        [ValidateNotNullOrEmpty()] [string] $hash = ".\*.md5",
        [ValidateNotNullOrEmpty()] [string] $algorithm = "MD5",
        [ValidateNotNullOrEmpty()] [int]$cpus = ((Get-WmiObject win32_processor).NumberOfLogicalProcessors)
    )

    Get-Content "$hash" | ForEach-Object -Parallel {
        $line = $_.Split(" *")
        $hash = (Get-FileHash -Algorithm $using:algorithm $line[1]).Hash
        Write-Host "$($line[1]) $($line[0]) $($hash -ieq $line[0] ? '==' : '!=') $($hash)"
    } -ThrottleLimit $cpus
}
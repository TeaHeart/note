$rootPath = $pwd

$env:PATH = $env:PATH + ";C:\Program Files\Geth"

$dataPath = "$rootPath\script\geth"

$arr = "$dataPath\geth", "$dataPath\keystore"

foreach ($item in $arr) {
    if (Test-Path($item)) {
        Remove-Item $item -Force -Recurse
    }
}

geth --datadir "$dataPath" init "$dataPath\genesis.json"

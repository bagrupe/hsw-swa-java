$cwd = Get-Location

Set-Location $PSScriptRoot/11-maven-fizzbuzz

& mvn clean

Set-Location $PSScriptRoot/12-maven-caesar-solution

& mvn clean

Set-Location $PSScriptRoot/13-maven-parent

& mvn clean

Set-Location $PSScriptRoot/14-mavify-solution

& mvn clean

Set-Location $PSScriptRoot/20-parent

& mvn clean

Set-Location $PSScriptRoot/30-parent

& mvn clean

Set-Location $PSScriptRoot/40-parent

& mvn clean

Set-Location $cwd

$classpaths = Get-ChildItem -Path . -Include .classpath -Recurse -Hidden
foreach($file in $classpaths) {
    Remove-Item $file -Force
}
$projects = Get-ChildItem -Path . -Include .project -Recurse -Hidden
foreach($file in $projects) {
    Remove-Item $file -Force
}
$settings = Get-ChildItem -Path . -Include .settings -Recurse -Hidden
foreach($file in $settings) {
    Remove-Item $file -Recurse -Force
}

Set-Location $PSScriptRoot
Remove-Item $PSScriptRoot/../hsw-swa-java.zip
& zip -r $PSScriptRoot/../hsw-swa-java.zip . -x '*.git*' -x '*.DS_Store*'
Set-Location $cwd
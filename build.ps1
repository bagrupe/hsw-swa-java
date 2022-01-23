$cwd = Get-Location

Set-Location $PSScriptRoot/11-maven-fizzbuzz

& mvn clean install

Set-Location $PSScriptRoot/12-maven-caesar-solution

& mvn clean install

Set-Location $PSScriptRoot/13-maven-parent

& mvn clean install

Set-Location $PSScriptRoot/14-mavify-solution

& mvn clean install

Set-Location $PSScriptRoot/20-parent

& mvn clean install

Set-Location $PSScriptRoot/30-parent

& mvn clean install

Set-Location $PSScriptRoot/40-parent

& mvn clean install

Set-Location $PSScriptRoot/43-servlet-jsp-javax

& mvn clean install

Set-Location $PSScriptRoot/44-servlet-jsp-jakarta

& mvn clean install

Set-Location $PSScriptRoot/51-grpc-protoc

& mvn clean install

Set-Location $PSScriptRoot/52-grpc-maven

& mvn clean install

Set-Location $cwd

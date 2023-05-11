#!/bin/sh

echo Enter release version:
read -r version
echo Enter next version:
read -r nextversion

tag_message="Version $version"


git branch $version-prepare
git checkout $version-prepare

mvn versions:set -DgenerateBackupPoms=false -DnewVersion=$version

git commit -m "Release of version $version" "pom.xml"
git tag -f -a $version -m $tag_message
git push origin $version

git checkout master
git branch -D $version-prepare

#cmd /c mvn versions:set -DgenerateBackupPoms=false -DnewVersion=%nextversion%-SNAPSHOT

#git commit -m "Next version %nextversion%" "pom.xml"
#git push

#del pom.xml.versionsBackup

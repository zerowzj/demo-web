#!/bin/bash

PROJECT_NAME=demo-web
DEPLOY_HOME=/app/demo-web
WEB_APPS=$DEPLOY_HOME/webapps

war_file=$1
if [ ! -f "$DEPLOY_HOME/$war_file" ]; then
    echo "文件不存在"
    exit 1
fi

cd `dirname $0`
cd ..

rm -rf $WEB_APPS/ROOT
unzip -oq $war_file -d $WEB_APPS/ROOT;
sleep 3;
rm -rf $war_file

pid=`ps -ef |grep $PROJECT_NAME |grep -v grep |awk '{print $2}'`
if [ -n "$pid" ]; then
    kill -9 $pid
    echo "------------------------------"
    echo "     Shutdown tomcat...       "
    echo "------------------------------"
fi

export JAVA_HOME=/usr/jdk1.8.0_162
export PATH=$PATH:$JAVA_HOME/bin
sh ./startup.sh



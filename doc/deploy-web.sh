#!/bin/bash

PROJECT_NAME=demo-web
DEPLOY_HOME=/app/demo-web
WEB_APPS=$DEPLOY_HOME/webapps
ROOT=$WEB_APPS/ROOT

WAR_FILE=$DEPLOY_HOME/$1
if [ ! -f "$WAR_FILE" ]; then
    echo "ERROR: file[$WAR_FILE] not exist!"
    exit 1
fi

cd `dirname $0`
##进入webapps
#cd ..

rm -rf $ROOT
unzip -oq $WAR_FILE -d $ROOT;
sleep 3;
rm -rf $WAR_FILE

pid=`ps -ef |grep /app/demo-web/ |grep -v grep |grep -v deploy-web.sh |awk '{print $2}'`
if [ -n "$pid" ]; then
    kill -9 $pid
    echo "------------------------------"
    echo "     Shutdown tomcat...       "
    echo "------------------------------"
fi

sh startup.sh

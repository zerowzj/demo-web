#!/bin/bash

PROJECT_NAME=demo-web
DEPLOY_HOME=/app/demo-web
WEB_APPS=$DEPLOY_HOME/webapps
ROOT=$WEB_APPS/ROOT

war_file=$1
echo "=====>$1"
if [ ! -f "$DEPLOY_HOME/$war_file" ]; then
    echo "文件不存在"
    exit 1
fi

cd `dirname $0`
#进入webapps
cd ..

rm -rf $ROOT
unzip -oq $war_file -d $ROOT;
sleep 3;
rm -rf $war_file

pid=`ps -ef |grep /app/demo-web/ |grep -v grep |grep -v deploy-web.sh |awk '{print $2}'`
if [ -n "$pid" ]; then
    kill -9 $pid
    echo "------------------------------"
    echo "     Shutdown tomcat...       "
    echo "------------------------------"
fi

#!/bin/bash

# 사용자 폴더 생성
cd /Users/ssionii/Desktop/secubook/user/userCode
mkdir $1

# 컨테이너 생성
docker create \
--name=$1 \
-e PUID=$UID \
-e PGID=$(id -g $USER) \
-e TZ=Asia/Seoul \
-e PASSWORD=0000 \
-e SUDO_PASSWORD=0000 \
-p $2:8443 \
-v /Users/ssionii/Desktop/secubook/user/userCode/$1:/config \
-v /Users/ssionii/Desktop/secubook/log/score:/opt/$1/log/score \
secubook

# 컨테이너 실행
docker start $1

# 컨테이너 종료
docker stop $1

# 문제 복사
cd /Users/ssionii/Desktop/secubook_problem
cp -r problems problems_cp
mv problems_cp /Users/ssionii/Desktop/secubook/user/userCode/$1/workspace
cd /Users/ssionii/Desktop/secubook/user/userCode/$1/workspace
mv problems_cp problems
#!/bin/bash

# 사용자 폴더 생성
# $1: 사용자 ID
cd ~/secubook/user/userCode
mkdir $1

# 컨테이너 생성
docker create \
--name=$1 \
-e PUID=$UID \
-e PGID=$(id -g $USER) \
-e TZ=Asia/Seoul \
-e PASSWORD=0000 \
-e SUDO_PASSWORD=0000 \
-v ~/secubook/user/userCode/$1:/config \
-v ~/secubook/log/score:/opt/secubook/log/score \
ssionii/secubook:v2

# 컨테이너 실행
docker start $1

# 컨테이너 종료
docker stop $1

# 문제 복사
cd ~/secubook_problem
cp -r problems problems_cp
mv problems_cp ~/secubook/user/userCode/$1/workspace
cd ~/secubook/user/userCode/$1/workspace
mv problems_cp problems

# CodeAnalyzer 다시 생성
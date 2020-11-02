#!/bin/bash

# 사용자 컨테이너 실행
# $1: 사용자 ID, $2: 문제 번호
# cd /home/ubuntu/secubook_problem
cd ~/secubook_problem
docker start $1
docker exec $1 ./run_codeanalyzer.sh $1 $2

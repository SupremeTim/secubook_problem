#!/bin/bash

# 사용자 컨테이너 실행
# $1: 사용자 ID, $2: 문제 번호
docker exec $1 run ./run_codeanalyzer $1 $2

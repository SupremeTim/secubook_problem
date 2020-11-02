#!/bin/bash

# CodeAnalyzer 빌드
cd /opt/secubook_problem/CodeAnalyzer/src
javac com/company/Main.java
java com.company.Main $1 $2
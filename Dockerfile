FROM linuxserver/code-server

# 필요한 것들 다운로드
RUN apt-get update
RUN apt-get install vim -y
RUN apt-get install openjdk-8-jdk -y

# 문제 제공 환경 구축
WORKDIR /opt
RUN git clone https://github.com/SupremeTim/secubook_problem.git

# 로그 저장 공간 구축
RUN ls
RUN mkdir secubook && cd secubook && mkdir log && mkdir score

# 환경 변수 설정
WORKDIR /opt/secubook_problem
RUN cp profile profile_cp && mv profile_cp /etc && cd /etc && mv profile_cp profile

# CodeAnalyzer 빌드
WORKDIR /opt/secubook_problem/CodeAnalyzer/src
RUN javac com/company/Main.java

# 문제 workspace로 복사
WORKDIR /opt/secubook_problem
# CMD cp -r problems problems_cp && mv problems_cp /config/workspace && cd /config/workspace && mv problems_cp problems
# 카프카 완벽가이드 - 커넥트 편

## 들어가기 전에

✔ 다양한 Connector 들에 대한 환경 구성 및 구동 실습

```
- Spooldir Source
- Java JDBC
- Debezium MySQL
```

✔ Debezium CDC Connector에 대한 핵심 메커니즘

```
DEBEZIUM + KAFKA CONNECT
```

## 환경 구축

```
Oracle Virtual Box 6.1

Kafka Confluent Platform 7.1.x

Ubuntu 20.04 LTS

```

- [Kafka Confluent Platform](https://docs.confluent.io/platform/current/installation/versions-interoperability.html)


✔ 고정 IP 할당하기 (Putty 사용)

``````
1. Oracle Virtual Box VM 기동전 호스트 네트워크 관리자

2. Virtual Box VM 설정 -> 네트워크 -> 어댑터2 
- 네트워크 어댑터 사용하기 체크
- 호스트 전용 어댑터 선택

3. VM 재기동

4. VM에서 우측 상단 네트워크 클릭 후 유선 네트워크 설정

5. 이더넷 설정 버튼 클릭 후, IPv4 자동에서 수동으로 변경

6. IP 주소 입력 후, 이더넷 enp0s8 재시작

7. ifconfig로 바뀐 주소 확인 후, 로컬에서 CMD로 ping IP Address로 확인

8. ping 확인 후, SSH 설정
``````

✔ confluent kafka 설치

```
# 실습 환경 버전
Version : 7.1.2
```

- **Confluent Kafka vs Apache Kafka**

```
Schema registry를 쓰려면 Apache Kafka의 경우, 별도로 Confluent Kafka에 있는 스키마를 별도로 다 가져다 써야 하는 불편함이 있음.

Confluent Kafka는 일체화 되어 있어서 그럴 필요가 없음
```

## 서버 환경 설정

```
## zookeeper.properties

dataDir=/home/min/data/zookeeper

## server.properties

log.dirs=/home/min/data/kafka
```

✔ 주키퍼, 카프카 start shell 만들기

```
# zoo_start.sh
$CONFLUENT_HOME/bin/zookeeper-server-start $CONFLUENT_HOME/etc/kafka/zookeeper.properties

# kafka_start.sh
$CONFLUENT_HOME/bin/kafka-server-start $CONFLUENT_HOME/etc/kafka/server.properties

## 만든 쉘 권한 부여
chmod +x zoo_start.sh
chmod +x kafka_start.sh
```
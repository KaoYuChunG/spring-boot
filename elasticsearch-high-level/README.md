# spring-boot-demo-elasticsearch-rest-high-level-client

> 此 demo 主要演示了 Spring Boot 如何集成 `elasticsearch-rest-high-level-client` 完成對 `ElasticSearch 7.x` 版本的基本 CURD 操作 

## Elasticsearch 升级

先升級到 6.8，索引創建，设置 mapping 等操作加参數：include_type_name=true，然後升级到 7，舊索引可以用 type 訪問。具体可以参考：

https://www.elastic.co/cn/blog/moving-from-types-to-typeless-apis-in-elasticsearch-7-0

https://www.elastic.co/guide/en/elasticsearch/reference/7.0/removal-of-types.html

## 注意

此ElasticSearch 版本為 `7.3.0`，使用 docker 運行，下面是所有步骤：

1.下載鏡像：`docker pull elasticsearch:7.3.0`

2.下載安装 `docker-compose`，参考文檔： https://docs.docker.com/compose/install/

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.24.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```

3.編寫docker-compose 文件

```yaml
version: "3"

services:
  es7:
    hostname: es7
    container_name: es7
    image: elasticsearch:7.3.0
    volumes:
      - "/data/es7/logs:/usr/share/es7/logs:rw"
      - "/data/es7/data:/usr/share/es7/data:rw"
    restart: on-failure
    ports: 
      - "9200:9200"
      - "9300:9300"
    environment:
      cluster.name: elasticsearch
      discovery.type: single-node
    logging:
      driver: "json-file"
      options:
        max-size: "50m"

```
4.啟動: `docker-compose -f elasticsearch.yaml up -d`


- ElasticSearch 官方文档：https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html

- Java High Level REST Client：https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.3/java-rest-high.html


package com.kao.elasticsearchhighlevel.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.data.elasticsearch")
public class ElasticsearchConstant {

    /**
     * 請求協議
     */
    private String schema = "http";

    /**
     * 集群名稱
     */
    private String clusterName = "elasticsearch";

    /**
     * 集群節點
     */
    @NotNull(message = "集群節點不可為空")
    private List<String> clusterNodes = new ArrayList<>();

    /**
     * 連接超時時間(毫秒)
     */
    private Integer connectTimeout = 1000;

    /**
     * socket 超時時間
     */
    private Integer socketTimeout = 30000;

    /**
     * 連接请求超時時間
     */
    private Integer connectionRequestTimeout = 500;

    /**
     * 每個路由的最大連接數量
     */
    private Integer maxConnectPerRoute = 10;

    /**
     * 最大連接總數量
     */
    private Integer maxConnectTotal = 30;

    /**
     * 索引配置信息
     */
    private Index index = new Index();

    /**
     * 認證帳戶
     */
    private Account account = new Account();

    /**
     * 索引配置信息
     */
    @Data
    public static class Index {

        /**
         * 分片數量
         */
        private Integer numberOfShards = 3;

        /**
         * 副本數量
         */
        private Integer numberOfReplicas = 2;

    }

    /**
     * 認證帳戶
     */
    @Data
    public static class Account {

        /**
         * 認證用戶
         */
        private String username;

        /**
         * 認證密码
         */
        private String password;

    }
}

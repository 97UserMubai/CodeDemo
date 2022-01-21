package es.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @Classname EsConfig
 * @Description
 * @Date 2021/5/24 10:06
 * @Created by mubai
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "es.repositories")
public class EsConfig {
}

package idv.jk.config;

import com.mongodb.client.MongoClient;
import idv.jk.converter.StringToDifficultyConverter;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Collections;

@Configuration
public class MongoDBConfig {
    private final MongoProperties mongoProperties;
    private final MongoClient mongoClient;

    public MongoDBConfig(MongoProperties mongoProperties, MongoClient mongoClient) {
        this.mongoProperties = mongoProperties;
        this.mongoClient = mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoProperties.getDatabase());
        MappingMongoConverter mongoMapping = (MappingMongoConverter) mongoTemplate.getConverter();
        mongoMapping.setCustomConversions(new MongoCustomConversions(Collections.singletonList(new StringToDifficultyConverter())));
        mongoMapping.afterPropertiesSet();
        return mongoTemplate;

    }
}

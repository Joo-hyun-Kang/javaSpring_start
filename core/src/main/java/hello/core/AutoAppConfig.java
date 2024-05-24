package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        //既存書いた＠Configurationタグが貼り付いてるインスタンス除く
        //元々、設定情報を覗かないのに、既存コード維持をするため。
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        basePackages = "hello"
)
public class AutoAppConfig {
}

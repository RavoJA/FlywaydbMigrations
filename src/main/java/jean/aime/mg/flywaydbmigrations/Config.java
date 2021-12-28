package jean.aime.mg.flywaydbmigrations;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {

    @PostConstruct
    public void execMigration() {
        Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/db2", "jar", "jar")
                .locations("db/migration/db2")
                .group(true)
                .load()
                .migrate();

        Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/db3", "jar", "jar")
                .locations("db/migration/db3")
                .load()
                .migrate();

        //Other datasources
    }
}

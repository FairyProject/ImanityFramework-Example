package org.imanity.example.repository;

import org.imanity.example.configuration.ExampleH2Configuration;
import org.imanity.example.configuration.ExampleMySqlConfiguration;
import org.imanity.example.data.ExampleData;
import org.imanity.framework.*;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.UUID;

/**
 * The Repository to store data
 */
@Service(name = "example-repository")
@ProvideConfiguration(ExampleH2Configuration.class) // Specific Configuration to use in this repository
public class ExampleMySqlRepository extends SQLRepository<ExampleData, UUID> { // <Entity, Id>

    @Override
    public Class<ExampleData> type() {
        return ExampleData.class;
    }

    @Cacheable(key = "'example-' + #args[0]", forever = true, condition = "#retVal != null") // Cache the example data if it's wasn't null from
    public ExampleData find(@Nonnull UUID uuid) {
        return super.findById(uuid).orElseGet(() -> new ExampleData(uuid));
    }

    @CacheEvict("'example-' + #args[0].getUuid()") // Remove the cache
    @Async // Run in async
    public <S extends ExampleData> void saveAndDelete(S pojo) {
        super.save(pojo);
    }

}

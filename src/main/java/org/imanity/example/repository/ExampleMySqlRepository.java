package org.imanity.example.repository;

import org.imanity.example.configuration.ExampleMySqlConfiguration;
import org.imanity.example.data.ExampleData;
import org.imanity.framework.*;
import org.imanity.framework.cache.Unless;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.UUID;

/**
 * The Repository to store data
 */
@Service(name = "example-repository")
@ProvideConfiguration(ExampleMySqlConfiguration.class) // Specific Configuration to use in this repository
public class ExampleMySqlRepository extends SQLRepository<ExampleData, UUID> { // <Entity, Id>

    @Override
    public Class<ExampleData> type() {
        return ExampleData.class;
    }

    @Cacheable(key = "example-$(arg0)", forever = true, unless = Unless.ResultOptionalIsNull.class)
    @Override
    public Optional<ExampleData> findById(@Nonnull UUID uuid) {
        return super.findById(uuid);
    }

    @CacheEvict("example-$(arg0.uuid)")
    @Async
    public <S extends ExampleData> void saveExample(S pojo) {
        super.save(pojo);
    }

}

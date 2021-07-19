package io.string.portal.repository;

import io.string.portal.domain.StringProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringProductRepository extends JpaRepository<StringProduct, Long> {
}

package io.string.portal.repository;

import io.string.portal.domain.StringReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringReviewRepository extends JpaRepository<StringReview, Long> {
}

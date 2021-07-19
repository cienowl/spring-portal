package io.string.portal.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "string_review")
public class StringReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_review_pk")
    private Long stringReviewPk;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "string_product_id")
    private StringProduct stringProduct;

    @Column(name = "review_title", length = 100)
    private String reviewTitle;

    @Column(name = "review_password")
    private String reviewPassword;

    @Column(name = "string_rating")
    private Double stringRating;

    @Column(name = "review_comment")
    private String reviewComment;

    @Column(name = "is_display")
    private Boolean isDisplay;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "review_author", length = 50)
    private String reviewAuthor;

    @Column(name = "review_author_ip", length = 20)
    private String reviewAuthorIp;

    @Column(name = "count_read")
    private Integer countRead;

    @Column(name = "count_recommend")
    private Integer countRecommend;

    @Column(name = "count_blame")
    private Integer countBlame;

}

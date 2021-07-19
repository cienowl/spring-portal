package io.string.portal.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "string_model")
public class StringModel extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_model_pk")
    private Long stringModelPk;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_brand_id")
    private MasterBrand masterBrand;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_sport_id")
    private MasterSport masterSport;

    @Column(name = "string_model_code", length = 100, unique = true)
    private String stringModelCode;

    @Column(name = "string_model_name", length = 100)
    private String stringModelName;

    @Column(name = "is_discontinue")
    private Boolean isDiscontinue;

}

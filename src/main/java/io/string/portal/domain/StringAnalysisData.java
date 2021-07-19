package io.string.portal.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "string_analysis_data")
public class StringAnalysisData extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_analysis_data_pk")
    private Long stringAnalysisDataPk;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "string_product_id")
    private StringProduct stringProduct;

    @Column(name = "img_cross_section")
    private String imgCrossSection;

    @Column(name = "img_side")
    private String imgSide;

    @Column(name = "diameter")
    private Double diameter;

    @Column(name = "stiffness")
    private Double stiffness;

    @Column(name = "tension")
    private Double tension;

}

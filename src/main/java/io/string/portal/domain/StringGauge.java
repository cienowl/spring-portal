package io.string.portal.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "string_gauge")
public class StringGauge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_gauge_pk")
    private Long stringGaugePk;

    @Column(name = "gauge_code_us", length = 5)
    private String gaugeCodeUs;

    @Column(name = "gauge_code_eu", length = 5)
    private String gaugeCodeEu;

    @Column(name = "diameter_millimeter_min")
    private Double diameterMillimeterMin;

    @Column(name = "diameter_millimeter_max")
    private Double diameterMillimeterMax;

}

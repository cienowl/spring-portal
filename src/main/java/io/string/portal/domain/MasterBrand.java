package io.string.portal.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "master_brand")
public class MasterBrand extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "master_brand_pk")
    private Long masterBrandPk;

    @Column(name = "brand_ci")
    private String brandCi;

    @Column(name = "brand_code", length = 100, unique = true)
    private String brandCode;

    @Column(name = "brand_name", length = 100)
    private String brandName;

}

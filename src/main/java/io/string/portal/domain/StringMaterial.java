package io.string.portal.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "string_material")
public class StringMaterial extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_material_pk")
    private Long stringMaterialPk;

    @Column(name = "material_code", length = 20, unique = true)
    private String materialCode;

    @Column(name = "material_name", length = 50)
    private String materialName;

}

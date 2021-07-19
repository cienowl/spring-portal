package io.string.portal.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "string_composition")
public class StringComposition extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_composition_pk")
    private Long stringCompositionPk;

    @Column(name = "composition_code", length = 20, unique = true)
    private String compositionCode;

    @Column(name = "composition_name", length = 50)
    private String compositionName;

}

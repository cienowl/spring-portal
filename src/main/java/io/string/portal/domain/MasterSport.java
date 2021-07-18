package io.string.portal.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "master_sport")
public class MasterSport extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "master_sport_pk")
    private Long masterSportPk;

    @Column(name = "sport_code", length = 100, unique = true)
    private String sportCode;

    @Column(name = "sport_name", length = 100)
    private String sportName;

}

package io.string.portal.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "string_product")
public class StringProduct extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_product_pk")
    private Long stringProductPk;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "string_model_id")
    private StringModel stringModel;

    @Column(name = "product_barcode", unique = true)
    private String productBarcode;

    @Column(name = "product_package_img")
    private String productPackageImg;

    @Column(name = "is_reel")
    private Boolean isReel;

    @Column(name = "length_feet")
    private Integer lengthFeet;

    @Column(name = "length_meter")
    private Integer lengthMeter;

    @Column(name = "gauge_spec", length = 10)
    private String gaugeSpec;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "is_discontinue")
    private Boolean isDiscontinue;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_color_id")
    private MasterColor masterColor;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "string_gauge")
    private StringGauge stringGauge;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "string_material_id")
    private StringMaterial stringMaterial;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "string_composition_id")
    private StringComposition stringComposition;

}

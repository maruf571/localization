package com.maruf.localization.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author maruf
 */
@Setter
@Getter
@Entity
@Table(name = "LANGUAGE",
        indexes = {@Index(name = "idx_language", columnList = "project_id")})
public class Language extends BaseTenantEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Column(columnDefinition = "TINYINT", length = 1)
    private Boolean isRtl;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(columnDefinition = "TINYINT", length = 1)
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

}

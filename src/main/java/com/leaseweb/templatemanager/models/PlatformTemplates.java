package com.leaseweb.templatemanager.models;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "platform_templates")
public class PlatformTemplates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Id of the platform")
    private Long platformId;

    @ApiModelProperty(notes = "Id of the template")
    private Long templateId;

    @ApiModelProperty(notes = "Download state of the template")
    private String csState;

    @ApiModelProperty(notes = "Readiness state of the template")
    private String csReady;

    @ApiModelProperty(notes = "Uuid of the template")
    private String csUuid;

    @ApiModelProperty(notes = "Indicates if template is publicly available")
    private int csPublic;

    @ApiModelProperty(notes = "Indicates if the template is featured or not")
    private int csFeatured;

    @ApiModelProperty(notes = "Indicates if the template can be extracted or not")
    private int csExtractable;

    private String csCreated;

    private String csRemoved;
}

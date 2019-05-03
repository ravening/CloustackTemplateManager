package com.leaseweb.templatemanager.models;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "platforms")
public class Platforms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Name of the platform")
    private String name;

    @ApiModelProperty(notes = "POP name of the platform")
    private String pop;

    @ApiModelProperty(notes = "Data center name of the platform")
    private String dc;
    private String cc;
    private int sap;
    @Column(name = "private")
    private int isPrivate;
    private int active;

}

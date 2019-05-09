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
@Table(name = "osid")
public class Osid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id")
    private Long id;

    @ApiModelProperty(notes = "Name of the osid")
    private String name;

    @ApiModelProperty(notes = "Display text")
    private String displaytext;

    @ApiModelProperty(notes = "OS type")
    private String ostype;

    @ApiModelProperty(notes = "Tag name for the tempalte")
    private String tag;

    @ApiModelProperty(notes = "OS distribution")
    private String osdistro;

    @ApiModelProperty(notes = "OS version")
    private String osversion;

    @ApiModelProperty(notes = "CAS ID of the tempalte")
    private String osidCas;

    @ApiModelProperty(notes = "SAP id of the template")
    private String osidSap;

    @ApiModelProperty(notes = "32 or 64 bit of th OS")
    private String bit;

    @ApiModelProperty(notes = "Architecture type of the OS")
    private String arch;

    @ApiModelProperty(notes = "Type of control panel")
    private String panel;

    @ApiModelProperty(notes = "Indicates if the template is active")
    private String active;

    @ApiModelProperty(notes = "Indicates the EOL of the template")
    private String eol;

}

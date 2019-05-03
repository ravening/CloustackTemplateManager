package com.leaseweb.templatemanager.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "templates")
@ApiModel(description = "All details about the template. ")
public class Templates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated template ID")
    private Long id;

    @NotNull
    @ApiModelProperty(notes = "The template name")
    private String name;

    @NotNull
    @ApiModelProperty(notes = "The display text of the template")
    private String displaytext;

    @ApiModelProperty(notes = "OS type of the template")
    private String ostype;

    @ApiModelProperty(notes = "Tags for the template")
    private String tag;

    @ApiModelProperty(notes = "The template OS distribution")
    private String osdistro;

    @ApiModelProperty(notes = "The template OS version")
    private String osversion;

    @ApiModelProperty(notes = "The template CAS ID")
    private String osidCas;

    @ApiModelProperty(notes = "The template SAP ID")
    private String osidSap;

    @ApiModelProperty(notes = "The template bit value")
    private String bit;

    @ApiModelProperty(notes = "The architecture of the template")
    private String arch;

    @ApiModelProperty(notes = "Type of control panel")
    private String panel;

    @ApiModelProperty(notes = "Build version of the template")
    private String build;

    @ApiModelProperty(notes = "The size of the template")
    private String size;

    @ApiModelProperty(notes = "The virtio type of the template (scsi/blk)")
    private String virtio;

    private String app;

    @ApiModelProperty(notes = "Indicates if template can autogrow or not")
    private String grow;

    private String packerVersion;

    @ApiModelProperty(notes = "File name of the template")
    private String fielname;

    @ApiModelProperty(notes = "The url from where template can be downloaded")
    private String url;

    @ApiModelProperty(notes = "Indicates if the template is available for public deployment")
    private String available;
}

package com.leaseweb.templatemanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "template_view")
public class TemplateView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String displaytext;
    private String ostype;
    private String tag;
    private String osdistro;
    private String osversion;
    private String osidCas;
    private String osidSap;
    private String bit;
    private String ospanel;
    private String build;
    private String size;
    private String virtio;
    private String app;
    private int grow;
    private String packerVersion;
    private int fileAvailable;
    private String fileName;
    private String fileUrl;
    private String pop;
    private String popName;
    private String popDc;
    private String popCountry;
    private int platformId;
    private String platformUuid;
    private String platformState;
    private int platformPublic;
    private int platformFeatured;
    private String platformCreated;
    private String platformRemoved;

}

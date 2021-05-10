package com.waracle.cakemgr;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "cake")
public class Cake implements Serializable {

    @Id
    @Column(name = "cakeId")
    private int cakeId;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "description")
    private String description;

}
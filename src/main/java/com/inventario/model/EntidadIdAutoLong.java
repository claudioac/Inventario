package com.inventario.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Claudio on 17/05/2015.
 */
@MappedSuperclass
public abstract class EntidadIdAutoLong {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idAutoGen")
    public Long id;

    @Column(unique = true)
    public String altKey;

    @PrePersist
    public void prePersist(){
        altKey = (UUID.randomUUID().toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAltKey() {
        return altKey;
    }

    public void setAltKey(String altKey) {
        this.altKey = altKey;
    }
}

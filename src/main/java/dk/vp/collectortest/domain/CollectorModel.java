package dk.vp.collectortest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import dk.vp.collectortest.Views.Views;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "Collector")
public class CollectorModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    @Min(0)
    private Long id;

    @Version
    @Column(nullable = false)
    @JsonView(Views.Query.class)
    @Min(0)
    private Long version;

    @NotBlank
    @Size(max=255)
    private String name;

    @NotBlank
    @Size(min=12, max=12)
    @Column(unique = true)
    private String isin;

    public Long getId() {
        return id;
    }

    public CollectorModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public CollectorModel setVersion(Long version) {
        this.version = version;
        return this;
    }

    public String getName() {
        return name;
    }

    public CollectorModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getIsin() {
        return isin;
    }

    public CollectorModel setIsin(String isin) {
        this.isin = isin;
        return this;
    }
}

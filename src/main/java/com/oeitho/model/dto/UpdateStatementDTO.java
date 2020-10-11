package com.oeitho.model.dto;

import java.util.Objects;

public class UpdateStatementDTO {

    private Long id;
    private String claim;
    private Boolean validity;
    private String explanation;
    private Boolean active;
    private String author;

    public UpdateStatementDTO() {}

    public UpdateStatementDTO(Long id, String claim, Boolean validity, String explanation, Boolean active,
            String author) {
        this.id = id;
        this.claim = Objects.requireNonNull(claim);
        this.validity = Objects.requireNonNull(validity);
        this.explanation = Objects.requireNonNull(explanation);
        this.active = Objects.requireNonNull(active);
        this.author = Objects.requireNonNull(author);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public Boolean getValidity() {
        return validity;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}

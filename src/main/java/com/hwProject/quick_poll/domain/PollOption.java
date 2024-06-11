package com.hwProject.quick_poll.domain;

import jakarta.persistence.*;


@Entity
@Table(name= "POLL_OPTION")
public class PollOption {
    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    @Column(name="OPTION_ID")
    private Long Id;
    @Column(name="OPTION_VALUE")
    private String Value;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public PollOption(Long optionId, String optionValue) {
        this.Id = optionId;
        this.Value = optionValue;
    }

    public PollOption() {
    }
}

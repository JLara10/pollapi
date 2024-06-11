package com.hwProject.quick_poll.domain;

import jakarta.persistence.*;



@Entity
public class Vote {
    @Id
    @GeneratedValue
    @Column(name="VOTE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private PollOption pollOption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PollOption getOption() {
        return pollOption;
    }

    public void setOption(PollOption pollOption) {
        this.pollOption = pollOption;
    }
}

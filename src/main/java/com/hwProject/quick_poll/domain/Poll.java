package com.hwProject.quick_poll.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;
@Entity
public class Poll {
    @Id
    @GeneratedValue
    @Column(name="POLL_ID")
    private Long id;
    @Column(name="QUESTION")
    @NotEmpty
    private String question;
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="POLL_ID",referencedColumnName = "POLL_ID")
    @OrderBy
    @Size(min=2, max = 6)
    private Set<PollOption> pollOptions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<PollOption> getPollOptions() {
        return pollOptions;
    }

    public void setPollOptions(Set<PollOption> pollOptions) {
        this.pollOptions = pollOptions;
    }

    public Poll() {

    }

    public Poll(Long id, String question, Set<PollOption> pollOptions) {
        this.id = id;
        this.question = question;
        this.pollOptions = pollOptions;
    }
}

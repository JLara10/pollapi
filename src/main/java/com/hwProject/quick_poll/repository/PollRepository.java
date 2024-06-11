package com.hwProject.quick_poll.repository;

import com.hwProject.quick_poll.domain.Poll;
import org.springframework.data.repository.CrudRepository;


public interface PollRepository extends CrudRepository<Poll, Long> {

}

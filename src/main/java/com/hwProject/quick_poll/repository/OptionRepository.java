package com.hwProject.quick_poll.repository;

import com.hwProject.quick_poll.domain.PollOption;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<PollOption, Long> {
}

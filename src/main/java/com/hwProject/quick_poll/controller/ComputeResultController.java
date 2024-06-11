package com.hwProject.quick_poll.controller;

import com.hwProject.quick_poll.domain.Vote;
import com.hwProject.quick_poll.dto.OptionCount;
import com.hwProject.quick_poll.dto.VoteResult;
import com.hwProject.quick_poll.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class ComputeResultController {
    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping(value="/computeResult", method=RequestMethod.GET)
    public ResponseEntity<?> computeResult(@RequestParam ("pollid") Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);
        // Algorithm to count votes
        if (allVotes == null) {
            return new ResponseEntity<String>("No votes found", HttpStatus.OK);
        }
        int totalVotes = 0;
        Map<Long, OptionCount> tempMap = new HashMap<>();
        for (Vote v : allVotes) {
            totalVotes++;
            OptionCount optionCount = tempMap.get(v.getOption().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOption().getId());
                tempMap.put(v.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount() + 1);
        }
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }

}

package com.hwProject.quick_poll.service;

import com.hwProject.quick_poll.domain.Poll;
import com.hwProject.quick_poll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PollService {
    @Autowired
        private PollRepository pollRepository;
        public Iterable<Poll> getStudents(){
            return pollRepository.findAll();
        }

        public void saveStudents(Poll poll){
            pollRepository.save(poll);
        }
        public void deleteStudent(Long id){
            pollRepository.deleteById(id);
        }
        public Optional<Poll> getStudentById(Long id){
            return pollRepository.findById(id);
        }
        public void updateStudent(Long id, Poll poll){
            for(Poll s: getStudents()){
                if(s.getId().equals(id)){
                    pollRepository.save(poll);
                }
            }
        }
    }


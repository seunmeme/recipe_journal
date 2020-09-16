package com.seunmeme.recipesjournal.repository;

import com.seunmeme.recipesjournal.model.DownVote;
import org.springframework.data.repository.CrudRepository;

public interface DownVoteRepository extends CrudRepository<DownVote, Long> {
}

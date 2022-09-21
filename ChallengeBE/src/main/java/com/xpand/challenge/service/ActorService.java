package com.xpand.challenge.service;

import java.util.List;

import com.xpand.challenge.dto.ActorDTO;
import com.xpand.challenge.dto.IdentifiableActorDTO;

public interface ActorService {
    
    IdentifiableActorDTO createActor(ActorDTO actorDTO);

    IdentifiableActorDTO getActor(Long id);

    List<IdentifiableActorDTO> getActors();

    void updateActor(Long id, ActorDTO actorDTO);

    void deleteActor(Long id);

	void assignActor(Long id, Long movieId);
}

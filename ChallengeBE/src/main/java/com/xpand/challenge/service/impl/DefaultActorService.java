package com.xpand.challenge.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.xpand.challenge.dto.ActorDTO;
import com.xpand.challenge.dto.ActorDTOMapper;
import com.xpand.challenge.dto.IdentifiableActorDTO;
import com.xpand.challenge.model.Actor;
import com.xpand.challenge.repository.ActorRepository;
import com.xpand.challenge.repository.MovieRepository;
import com.xpand.challenge.service.ActorService;

@Service
public class DefaultActorService implements ActorService{
	
	private final ActorRepository actorRepository;
	private final MovieRepository movieRepository;
	
	public DefaultActorService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

	@Override
	public IdentifiableActorDTO createActor(ActorDTO actorDTO) {
		Actor actor = ActorDTOMapper.fromActorDTO(actorDTO);
		return ActorDTOMapper.toActorDTO(actorRepository.save(actor));
	}

	@Override
	public IdentifiableActorDTO getActor(Long id) {
		return actorRepository.findById(id).map(ActorDTOMapper::toActorDTO).orElseThrow();
	}

	@Override
	public List<IdentifiableActorDTO> getActors() {
		return actorRepository.findAll().stream().map(ActorDTOMapper::toActorDTO).collect(Collectors.toList());
	}

	@Override
	public void updateActor(Long id, ActorDTO actorDto) {
		actorRepository.findById(id).orElseThrow();
		Actor actor = ActorDTOMapper.fromActorDTO(actorDto);
		actor.setId(id);
		actorRepository.save(actor);
	}

	@Override
	public void assignActor(Long id, Long movieId) {
		Actor actor = actorRepository.findById(id).orElseThrow();
		actor.setMovie(movieRepository.findById(movieId).orElseThrow());
		actorRepository.save(actor);
		
	}

	@Override
	public void deleteActor(Long id) {
		actorRepository.deleteById(id);
	}

}

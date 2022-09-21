package com.xpand.challenge.dto;

import java.util.Optional;

import com.xpand.challenge.model.Actor;

public class ActorDTOMapper {

    public static IdentifiableActorDTO toActorDTO(Actor actor) {
        return Optional.ofNullable(actor).map(m -> {
        	IdentifiableActorDTO dto = new IdentifiableActorDTO();
            dto.setId(actor.getId());
            dto.setBirthDate(actor.getBirthDate());
            dto.setName(actor.getName());
            dto.setGender((actor.getGender()));
            return dto;
        }).orElse(null);
    }

    public static Actor fromActorDTO(ActorDTO dto) {
        return Optional.ofNullable(dto).map(d -> {
        	Actor actor = new Actor();
        	actor.setBirthDate(dto.getBirthDate());
        	actor.setName(dto.getName());
        	actor.setGender(dto.getGender());
            return actor;
        }).orElse(null);
    }

}

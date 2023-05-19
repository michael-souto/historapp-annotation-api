package com.detrasoft.historapp.annotation.domain.services.client.character;

import com.detrasoft.framework.cloudclient.service.GenericClientFallbackServiceFactory;
import com.detrasoft.historapp.annotation.domain.dtos.CharacterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CharacterClientFallback extends GenericClientFallbackServiceFactory<CharacterDTO> implements CharacterClientService {

    @Override
    public ResponseEntity<List<CharacterDTO>> findByListId(List<Long> body) {
        return null;
    }
}

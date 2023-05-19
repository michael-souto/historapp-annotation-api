package com.detrasoft.historapp.annotation.domain.services.client.event;

import com.detrasoft.framework.cloudclient.service.GenericClientFallbackServiceFactory;
import com.detrasoft.historapp.annotation.domain.dtos.EventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EventClientFallback extends GenericClientFallbackServiceFactory<EventDTO> implements EventClientService {

    @Override
    public ResponseEntity<List<EventDTO>> findByListId(List<Long> body) {
        return null;
    }
}
package com.detrasoft.historapp.annotation.domain.services.client.event;

import com.detrasoft.framework.cloudclient.service.GenericClientService;
import com.detrasoft.historapp.annotation.domain.dtos.EventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "event",  fallback = EventClientFallback.class )
public interface EventClientService extends GenericClientService<EventDTO> {

    @RequestMapping(value = "/event/by-list-id", method = RequestMethod.POST)
    ResponseEntity<List<EventDTO>> findByListId(@RequestBody List<Long> body);
}

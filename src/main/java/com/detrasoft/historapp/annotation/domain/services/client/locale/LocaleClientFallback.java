package com.detrasoft.historapp.annotation.domain.services.client.locale;

import com.detrasoft.framework.cloudclient.service.GenericClientFallbackServiceFactory;
import com.detrasoft.historapp.annotation.domain.dtos.LocaleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LocaleClientFallback extends GenericClientFallbackServiceFactory<LocaleDTO> implements LocaleClientService {

    @Override
    public ResponseEntity<List<LocaleDTO>> findByListId(List<Long> body) {
        return null;
    }
}
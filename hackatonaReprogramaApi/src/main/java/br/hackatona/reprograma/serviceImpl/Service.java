package br.hackatona.reprograma.serviceImpl;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public interface Service {

	Object getAll() throws JsonParseException, JsonMappingException, IOException ;
}

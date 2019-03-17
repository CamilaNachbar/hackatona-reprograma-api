package br.hackatona.reprograma.serviceImpl;

import java.io.IOException;

import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServiceImpl implements br.hackatona.reprograma.serviceImpl.Service {

	@Override
	public Object getAll() throws JsonParseException, JsonMappingException, IOException {

		String jsonObject = "{ \"cartao\": {\"numero\": \"123456789876543\",\"limite-total\": 5500 }, \"compras\": [ { \"valor\": 128.90, \"valorparcela\": null, "
				+ "\"numeroparcela\": 0, \"data\": \"12/12/2018\", \"tipo\": { \"nome\": \"transporte\", \"prioridade\": 1  } }, "
				+ "{ \"valor\": 120,\"valorparcela\": 60, \"numeroparcela\": 2,\"data\": \"12/12/2018\",\"tipo\": {\"nome\": \"transporte\","
				+ " \"prioridade\": 1	  }	 } ], \"compras-por-tipo\": [ { \"valor\": 1200, \"tipo\": { \"nome\": \"transporte\",	\"prioridade\": 1	 } }, {	 \"valor\": 1200,"
				+ " \"tipo\": {	\"nome\": \"alimentacao\",	 \"prioridade\": 3 } }], \"percentual-usuarios\":[ {\"valor-percentual\": 25.5,\"tipo\""
				+ ": { \"nome\": \"alimentacao\",\"prioridade\": 3} }], \"percentual-pessoal\":[   { \"valor-percentual\": 25.5,   \"tipo\": {  \"nome\": \"alimentacao\", \"prioridade\": 3    }  } ]}";

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonObject.toString(), Object.class);
	}

}

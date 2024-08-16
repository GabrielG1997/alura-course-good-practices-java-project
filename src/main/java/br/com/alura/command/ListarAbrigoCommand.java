package br.com.alura.command;

import br.com.alura.service.AbrigoService;
import br.com.alura.service.ClientHttpConfiguration;

import java.io.IOException;

public class ListarAbrigoCommand implements Command{
    @Override
    public void execute() {
        try {
            ClientHttpConfiguration client = new ClientHttpConfiguration();
            AbrigoService abrigoService = new AbrigoService(client);
            abrigoService.listarAbrigo();
        }catch ( IOException | InterruptedException exception) {
            System.err.println( exception.getMessage() );
        }
    }
}

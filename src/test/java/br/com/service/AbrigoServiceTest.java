package br.com.service;

import br.com.alura.domain.Abrigo;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.ClientHttpConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {
    final private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    final private AbrigoService abrigoService = new AbrigoService(client);
    final private HttpResponse<String> response = mock( HttpResponse.class);
    final private Abrigo abrigo = new Abrigo("Teste", "61981880392", "abrigo_alura@gmail.com");

    @Test
    public void deveVerificarQuandoHaAbrigo() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedIdENome = "0 - Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[{"+abrigo.toString()+"}]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);
        abrigoService.listarAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(expectedAbrigosCadastrados, actualAbrigosCadastrados);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }
    @Test
    public void deveVerificarQuandoNaoHaAbrigo() throws IOException, InterruptedException {
        final String expectedReturn = "Não há nenhum abrigo cadastrado!";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);
        abrigoService.listarAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualReturn = lines[0];

        Assertions.assertEquals(expectedReturn, actualReturn);
    }
}

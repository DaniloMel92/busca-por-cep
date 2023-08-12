package com.dkmo.buscacep;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Danilo
 */
public class HttpConnect {
   CloseableHttpClient httpClient = HttpClients.createDefault();  
   String web = "https://viacep.com.br/ws/"; //o Endpoint que receberá as requisições
   private static int resp = 200;
   
     //Abaixo temos o método que nos permite fazer a busca de Ceps por endereço
    public  void BuscarCepPor(String estado,String cidade,String endereco)throws IOException{
        String uri = web+estado+"/"+cidade+"/"+endereco+"/json";
        try{
        HttpGet httpget = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpget);
        StatusLine statusline =response.getStatusLine();
        HttpEntity ent = response.getEntity();
        if (statusline.getStatusCode()>=300){
            throw new HttpResponseException(statusline.getStatusCode(),statusline.getReasonPhrase());
        }
        if (ent==null){
            throw new ClientProtocolException("Resposta vazia");
            
        }
        
    Gson gson = new GsonBuilder().create();
    ContentType contentType = ContentType.getOrDefault(ent);
    Charset charset = contentType.getCharset();
    Reader reader = new InputStreamReader(ent.getContent(),charset);
    List<Resposta> get = Arrays.asList(gson.fromJson(reader,Resposta[].class));
    for (Resposta s : get){
        System.out.println(s.toString());
    }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    
    }
    //Este é o metodo que nos permite fazer a busca de um endereço pelo cep.
    public void buscarEnderecoPelo(String cep) throws Exception{
        String urlParaChamada = web+cep+"/json";
        try{    
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao =(HttpURLConnection) url.openConnection();
            if (conexao.getResponseCode()!= resp){
                throw new RuntimeException ("Erro codigo: "+ conexao.getResponseCode());
                                                                                                                                                                                    }
            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String resp;
            while((resp=resposta.readLine())!=null){
                System.out.println(resp);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        /* temos dois metodos diferentes para fazer as requisições.
        um usa apenas as bibliotecas default do java e a outra se utiliza da biblioteca 
        Apache httpClient e também da biblioteca do google Gson que é responsável por fazer a leitura do nossa
        Resposta de requisição.
 
        */
        
    }
}

            
            

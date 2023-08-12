/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.dkmo.buscacep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import  org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpClientConnection;
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


/**
 *
 * @author Danilo
 */
public class BuscaEndereco {

    public static void main(String[] args) throws IOException {
        HttpConnect con = new HttpConnect(); //Objeto da classe responsável por fazer a requisição ao web service.
        try{
            con.buscarEnderecoPelo("72800440"); //Aqui é possivel pesquisar um endereco por cep; util para completar endereco apos a inserção do cep.
            System.out.println();
            System.out.println();
            System.out.println();
//É necessário estas 3 informações para efetuar a busca por cep estado com 2 caracteres apenas cidade e endereço.
            con.BuscarCepPor("GO", "Luziania", "Avenida+7"); //Se seu endereço contiver espaço é necessário acrescentar um + caso contrario sua busca falhará.
        } catch (Exception ex) {
        }
   
    }
    
    } 
 
        
   


    


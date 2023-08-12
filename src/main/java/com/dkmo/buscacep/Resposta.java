/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dkmo.buscacep;

/**
 *
 * @author Danilo
 */
/* Esta é classe que receberá as respostas da requisiçoes e por meio do método 
toSring estaremos recebendo a resposta que será inserida em cada atributo
que corresponde aos informações contidas no Json.
*/
public class Resposta {
    
   private  String cep;
    private  String logradouro;
    private String bairro;
    private  String localidade;
    private  String uf;

    
   @Override
    public String toString() {
        return "cep: " + '['+cep+']' + " logradouro: " + '['+logradouro+']' + " bairro: " + '['+bairro +']'+ " localidade: " + '['+localidade + ']'+" uf: " + '['+uf+']';
    }

    
    
    
}

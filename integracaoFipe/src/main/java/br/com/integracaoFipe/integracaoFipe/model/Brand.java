package br.com.integracaoFipe.integracaoFipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "brands")
public class Brand implements Serializable {

    @Id
    @JsonProperty("codigo")
    private Integer _id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("tipo")
    private String type;

    @JsonIgnore
    public String getTypeUnformatted(){
        if ("Carro".equals(type)){
            return "/carros";
        } else if ("Moto".equals(type)) {
            return "/motos";
        } else {
            return "/caminhoes";
        }
    }
}

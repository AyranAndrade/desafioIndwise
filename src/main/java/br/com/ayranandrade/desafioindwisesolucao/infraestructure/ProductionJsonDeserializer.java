package br.com.ayranandrade.desafioindwisesolucao.infraestructure;

import br.com.ayranandrade.desafioindwisesolucao.model.Production;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.time.ZonedDateTime;

/**
 *
 * @author Ayran
 */
public class ProductionJsonDeserializer extends JsonDeserializer<Production> {

    @Override
    public Production deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JsonProcessingException
    {
    ObjectCodec oc=jp.getCodec();
    JsonNode node=oc.readTree(jp);
    Production p=new Production();
    //Production Time
    ZonedDateTime pt=ZonedDateTime.parse(node.get("pt").textValue());
    p.setProductionTime(pt.toLocalDateTime());
    //Radio Id
    p.setRadioId(node.get("ri").asLong());
    //Unique Id
    p.setUniqueId(node.get("uuid").textValue());
    //Spped In Seconds
    p.setSpeedInSeconds(node.get("sis").doubleValue());
    //Id
    p.setId(node.get("id").textValue());
    //Created At
    ZonedDateTime ca=ZonedDateTime.parse(node.get("createdAt").textValue());
    p.setCreatedAt(ca.toLocalDateTime());
    //Updated At
    ZonedDateTime ua=ZonedDateTime.parse(node.get("updatedAt").textValue());
    p.setUpdatedAt(ua.toLocalDateTime());
    return p;
    }
}

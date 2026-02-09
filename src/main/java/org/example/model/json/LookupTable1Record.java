package org.example.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class LookupTable1Record {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("INN")
    private String inn;
    @JsonProperty("Residence")
    private String residence;
    @JsonProperty("StoreDate")
    private String storeDate;
    @JsonProperty("BlockDate")
    private String blockDate;
}

package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Step {
    private String name;
    private boolean leaf;
    private int stepsCount;
    private boolean hasContent;
}
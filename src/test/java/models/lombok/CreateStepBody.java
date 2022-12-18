package models.lombok;

import lombok.Data;

import java.util.List;

@Data
public class CreateStepBody {
    private List<Step> steps;

}
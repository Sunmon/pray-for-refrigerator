package org.refrigerator.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  //생성자로 Bean 주입받으면 @Autowired 필요 X
public class RecipeSaveRequestDto {

    @Builder
    public PostsSaveRequestDto(String food, String ingredient){

    }
}

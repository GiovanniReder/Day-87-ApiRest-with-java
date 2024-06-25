package giovanni.springwebapi.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    @Setter
    private String name;
    @Setter
    private String surname;

}

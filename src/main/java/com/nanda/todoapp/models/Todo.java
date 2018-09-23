package com.nanda.todoapp.models;

import java.util.Date;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@Document(collection="todos")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Todo {
    @Id
    private String id;
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String title;
    private String description;
    private Boolean completed = false;
    public String status;
    private Date createdAt = new Date();

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, title='%s', completed='%s']",
                id, title, completed);
    }
}
package com.alkimin.testifoodcatalogapi.domain.category;

import com.alkimin.testifoodcatalogapi.domain.user.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Setter
    private String title;
    @Setter
    private String description;
    private User owner;

}

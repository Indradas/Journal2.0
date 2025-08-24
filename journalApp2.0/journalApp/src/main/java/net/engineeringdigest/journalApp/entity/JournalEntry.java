package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.sql.DataSourceDefinition;
import java.time.LocalDateTime;

@Document
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class JournalEntry {
    @Id
    private String id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;
}

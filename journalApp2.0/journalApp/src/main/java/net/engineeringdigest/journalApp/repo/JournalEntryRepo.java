package net.engineeringdigest.journalApp.repo;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.jar.JarEntry;

@Repository
public interface JournalEntryRepo extends MongoRepository<JournalEntry , ObjectId> {
}

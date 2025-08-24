package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<String, JournalEntry> journalEntries =new HashMap<>();


    @GetMapping("/get")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values()) ;
    }

    @PostMapping("/post")
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }


    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("/delete/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId){
       journalEntries.remove(myId);
       return true;
    }

    @PutMapping("/put/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry){
        return journalEntries.put(String.valueOf(myId),myEntry);
    }


}

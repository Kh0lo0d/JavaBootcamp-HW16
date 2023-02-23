package com.example.project_madison.Cotroller;

import com.example.project_madison.Model.Madison;
import com.example.project_madison.Service.MadisonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("api/v1/madison")
public class MadisonController {

private final MadisonService madisonService;

    @GetMapping("/get")
    public ResponseEntity getAllMadison()
    {
        List<Madison> madisons=madisonService.getAllMadison();
        return ResponseEntity.status(200).body(madisons);

    }

   @GetMapping("/get/{id}/{name}")
   public ResponseEntity getEXpire(@PathVariable Integer id, @Valid@RequestBody String name)
   {Date e=madisonService.getEXpire(id,name);
       return ResponseEntity.status(200).body(e);

   }

    @PostMapping("/add")
    public ResponseEntity addMadison(@Valid @RequestBody Madison madison)
    {

        madisonService.addMadison(madison);
        return ResponseEntity.status(200).body("madison added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMadison(@PathVariable Integer id, @Valid@RequestBody Madison madison)
    {


        boolean isUbdate= madisonService.updateMadison(id,madison);

        if(isUbdate==true)
            return ResponseEntity.status(200).body("madison updated");

        else

            return ResponseEntity.status(400).body("Wrong id");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMadison(@PathVariable Integer id){
        boolean isDeleted= madisonService.deleteMadison(id);
        if(isDeleted==true)
            return ResponseEntity.status(200).body("madison deleted");
        else
            return ResponseEntity.status(400).body("Wrong id");

    }


}

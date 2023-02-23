package com.example.project_madison.Cotroller;

import com.example.project_madison.Model.Request;
import com.example.project_madison.Service.RequestServer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestServer requestService;

    @GetMapping("/get")
    public ResponseEntity getRequest(){
        List<Request> requests = requestService.getRequest();
        return ResponseEntity.status(200).body(requests);
    }

    @PostMapping("/add")
    public ResponseEntity addRequest(@Valid @RequestBody Request request, Errors errors){
        requestService.addRequest(request);
        return ResponseEntity.status(200).body("Request Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRequest(@Valid @RequestBody Request request, @PathVariable Integer id, Errors errors){
        requestService.updateRequest(id, request);
        return ResponseEntity.status(200).body("Request Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRequest(@PathVariable Integer id, Errors errors){

        requestService.deleteRequest(id);
        return ResponseEntity.status(200).body("Request Deleted");}

    @PutMapping("/price/{id}")
    public ResponseEntity updatePrice(@PathVariable Integer id, Errors errors){
        requestService.totalPrice(id);
        return ResponseEntity.status(200).body("Price Updated ");
    }

    @PutMapping("/check/{id}")
    public ResponseEntity check(@PathVariable Integer id){
        requestService.checkStatus(id);
        return ResponseEntity.status(200).body("Request Approved");
    }

    @PutMapping("/updatestatus/{id}")
    public ResponseEntity checkStatus(@Valid @RequestBody Request request, @PathVariable Integer id){
        requestService.Statustoscheduled(id, request);
        return ResponseEntity.status(200).body("Request Updated");
    }
}
